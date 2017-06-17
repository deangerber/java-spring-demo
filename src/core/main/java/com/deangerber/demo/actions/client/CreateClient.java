package com.deangerber.demo.actions.client;

import com.deangerber.demo.domain.client.Address;
import com.deangerber.demo.domain.client.Client;
import com.deangerber.demo.domain.exceptions.InvalidClientException;

public class CreateClient {

  public static Client create(String name, String addressLine1, String addressLine2) {
    if (hasRequiredData(name)) {
      return new Client(name, new Address(addressLine1, addressLine2));
    } else {
      throw new InvalidClientException("Client is missing required information");
    }
  }

  private static boolean hasRequiredData(String name) {
    return hasName(name);
  }

  private static boolean hasName(String name) {
    return name != null && !name.isEmpty();
  }
}
