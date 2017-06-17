package com.deangerber.demo.infrastructure.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTS")
public class ClientEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotEmpty
  @Column(name = "NAME", nullable = false, unique = true)
  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  private List<AddressEntity> addresses;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<AddressEntity> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<AddressEntity> addresses) {
    this.addresses = addresses;
  }

  @Override
  public String toString() {
    return "ClientEntity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", addresses=" + addresses +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ClientEntity that = (ClientEntity) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(name, that.name) &&
        Objects.equals(addresses, that.addresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, addresses);
  }
}
