package com.deangerber.demo.infrastructure.actions;

import com.deangerber.demo.domain.client.Client;
import com.deangerber.demo.infrastructure.adapters.ClientEntityAdapter;
import com.deangerber.demo.infrastructure.entities.ClientEntity;
import com.deangerber.demo.infrastructure.repositories.ClientRepository;

public class SaveClient {

  private ClientRepository repository;
  private ClientEntityAdapter adapter = new ClientEntityAdapter();

  public SaveClient(ClientRepository repository) {
    this.repository = repository;
  }

  public Client save(Client client) {
    ClientEntity clientEntity = adapter.from(client);
    ClientEntity entity = repository.save(clientEntity);
    return adapter.from(entity);
  }
}
