package com.deangerber.demo.infrastructure.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "ADDRESSES")
public class AddressEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotEmpty
  @Column(name = "LINE1", nullable = false)
  private String line1;

  @Column(name = "LINE2")
  private String line2;

  @ManyToOne
  @JoinColumn
  private ClientEntity client;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLine1() {
    return line1;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public String getLine2() {
    return line2;
  }

  public void setLine2(String line2) {
    this.line2 = line2;
  }

  @Override
  public String toString() {
    return "AddressEntity{" +
        "id=" + id +
        ", line1='" + line1 + '\'' +
        ", line2='" + line2 + '\'' +
        ", client=" + client +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AddressEntity that = (AddressEntity) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(line1, that.line1) &&
        Objects.equals(line2, that.line2) &&
        Objects.equals(client, that.client);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, line1, line2, client);
  }
}
