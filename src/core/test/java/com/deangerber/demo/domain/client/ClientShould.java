package com.deangerber.demo.domain.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClientShould {

  @Test
  void initialise_with_only_name() {
    assertNotNull(new Client("Test Client"));
  }

  @Test
  void initialise_with_name_and_address() {
    assertNotNull(new Client("Test Client", new Address("Line 1", "Line 2")));
  }
}