package com.deangerber.demo.domain.client;

import java.util.Objects;

public class Address {
  private long id;
  private String line1;
  private String line2;

  public Address() {
  }

  public Address(String line1, String line2) {
    this.line1 = line1;
    this.line2 = line2;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
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
    return "Address{" +
        "id=" + id +
        ", line1='" + line1 + '\'' +
        ", line2='" + line2 + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address = (Address) o;
    return id == address.id &&
        Objects.equals(line1, address.line1) &&
        Objects.equals(line2, address.line2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, line1, line2);
  }
}
