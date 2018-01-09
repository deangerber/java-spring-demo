package com.deangerber.demo.infrastructure.parsers;

import com.deangerber.demo.domain.exceptions.DomainError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JSONDomainErrorShould {

  @Test
  void return_valid_JSON_for_a_message() {
    DomainError error = new DomainError("Unit test error message.");
    String actual = JSONDomainError.toJSON(error);
    assertEquals("{\"message\":\"Unit test error message.\"}", actual);
  }
}