package com.deangerber.demo.infrastructure.parsers;

import com.deangerber.demo.domain.exceptions.DomainError;
import com.google.gson.Gson;

public class JSONDomainError {

  public static String toJSON(DomainError error) {
    // TODO: should I isolate this dependency behind its own interface?
    Gson gson = new Gson();
    return gson.toJson(error);
  }
}
