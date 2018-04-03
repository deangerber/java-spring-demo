package com.deangerber.demo.infrastructure.actions;

import com.deangerber.demo.domain.client.Client;
import com.deangerber.demo.infrastructure.adapters.ClientEntityAdapter;
import com.deangerber.demo.infrastructure.entities.ClientEntity;
import com.deangerber.demo.infrastructure.repositories.ClientRepository;

import java.util.List;

public class FindClient {

  private ClientRepository repository;
  private ClientEntityAdapter adapter = new ClientEntityAdapter();

  public FindClient(ClientRepository repository) {
    this.repository = repository;
  }

  public Client byId(Long id) {
    ClientEntity entity = repository.findById(id).get();
    return adapter.from(entity);
  }

  public List<Client> all() {
    List<ClientEntity> entities = (List<ClientEntity>) repository.findAll();
    return adapter.from(entities);
  }
}
