package com.deangerber.demo.actions.client;

import com.deangerber.demo.domain.client.Address;
import com.deangerber.demo.domain.client.Client;
import com.deangerber.demo.domain.exceptions.InvalidClientException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateClientShould {

  @Test
  void throw_exception_if_create_fails() {
    InvalidClientException exception = assertThrows(InvalidClientException.class, () -> {
      CreateClient.create("", "Address Line 1", "Address Line 2");
    });

    assertEquals("Client is missing required information", exception.error().message);
  }

  @Test
  void return_populated_client() {
    Client createdClient = CreateClient.create("Test Client", "Address Line 1", "Address Line 2");
    Client expectedClient = new Client("Test Client", new Address("Address Line 1", "Address Line 2"));
    assertEquals(expectedClient, createdClient);
  }
}