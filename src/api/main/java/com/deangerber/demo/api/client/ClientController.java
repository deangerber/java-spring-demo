package com.deangerber.demo.api.client;

import com.deangerber.demo.actions.client.CreateClient;
import com.deangerber.demo.domain.client.Client;
import com.deangerber.demo.domain.exceptions.InvalidClientException;
import com.deangerber.demo.infrastructure.actions.FindClient;
import com.deangerber.demo.infrastructure.actions.SaveClient;
import com.deangerber.demo.infrastructure.parsers.JSONDomainError;
import com.deangerber.demo.infrastructure.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

  private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

  @Autowired
  private ClientRepository repository;

  @RequestMapping(value = "/clients", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> create(@RequestBody ClientRequest clientRequest) {
    try {
      Client client = CreateClient.create(clientRequest.name, clientRequest.addressLine1, clientRequest.addressLine2);
      client = new SaveClient(repository).save(client);
      HttpHeaders headers = addLocationHeader(client);
      return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    } catch (InvalidClientException e) {
      LOG.debug(e.getLocalizedMessage());
      return new ResponseEntity<>(JSONDomainError.toJSON(e.error()), HttpStatus.BAD_REQUEST);
    } catch (org.springframework.dao.DataIntegrityViolationException e) {
      LOG.debug(e.getLocalizedMessage());
      return new ResponseEntity<String>(HttpStatus.CONFLICT);
    } catch (Exception e) {
      LOG.debug(e.getLocalizedMessage());
      return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> get(@PathVariable("id") long id) {
    try {
      Client client = new FindClient(repository).byId(id);
      return new ResponseEntity<>(client, HttpStatus.OK);
    } catch (Exception e) {
      LOG.debug(e.getLocalizedMessage());
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "/clients", method = RequestMethod.GET)
  public ResponseEntity<List<?>> index() {
    try {
      List<Client> clients = new FindClient(repository).all();
      return new ResponseEntity<>(clients, HttpStatus.OK);
    } catch (Exception e) {
      LOG.debug(e.getLocalizedMessage());
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  private HttpHeaders addLocationHeader(Client client) {
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(buildClientLocationURI(client));
    return headers;
  }

  private URI buildClientLocationURI(Client client) {
    return UriComponentsBuilder.newInstance().path("/api/client/{id}").buildAndExpand(client.getId()).toUri();
  }
}
