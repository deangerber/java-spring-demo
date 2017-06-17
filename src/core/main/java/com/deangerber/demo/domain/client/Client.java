package com.deangerber.demo.domain.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
  private long id;
  private String name;
  private List<Address> addresses = new ArrayList<>();

  public Client(String name) {
    this.name = name;
  }

  public Client(String name, Address address) {
    this.name = name;
    this.addresses.add(address);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  @Override
  public String toString() {
    return "Client{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", addresses=" + addresses +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Client client = (Client) o;
    return id == client.id &&
        Objects.equals(name, client.name) &&
        Objects.equals(addresses, client.addresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, addresses);
  }
}
