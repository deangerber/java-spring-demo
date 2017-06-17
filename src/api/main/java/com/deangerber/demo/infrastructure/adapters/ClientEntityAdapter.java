package com.deangerber.demo.infrastructure.adapters;

import com.deangerber.demo.domain.client.Address;
import com.deangerber.demo.domain.client.Client;
import com.deangerber.demo.infrastructure.entities.AddressEntity;
import com.deangerber.demo.infrastructure.entities.ClientEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ClientEntityAdapter {

  public ClientEntity from(Client client) {
    ClientEntity entity = new ClientEntity();
    entity.setId(client.getId());
    entity.setName(client.getName());
    entity.setAddresses(addressEntities(client.getAddresses()));

    return entity;
  }

  public Client from(ClientEntity newEntity) {
    Client client = new Client(newEntity.getName());
    client.setId(newEntity.getId());
    client.setAddresses(addresses(newEntity.getAddresses()));
    return client;
  }

  public List<Client> from(List<ClientEntity> entities) {
    return entities.stream().map(clientEntity -> from(clientEntity)).collect(Collectors.toList());
  }

  private List<AddressEntity> addressEntities(List<Address> addresses) {
    return addresses.stream().map(address -> {
      AddressEntity addressEntity = new AddressEntity();
      addressEntity.setId(address.getId());
      addressEntity.setLine1(address.getLine1());
      addressEntity.setLine2(address.getLine2());
      return addressEntity;
    }).collect(Collectors.toList());
  }

  private List<Address> addresses(List<AddressEntity> addressEntities) {
    return addressEntities.stream().map(addressEntity -> {
      Address address = new Address();
      address.setId(addressEntity.getId());
      address.setLine1(addressEntity.getLine1());
      address.setLine2(addressEntity.getLine2());
      return address;
    }).collect(Collectors.toList());
  }
}
