package com.deangerber.demo.domain.exceptions;

public class InvalidClientException extends RuntimeException {
  private DomainError error;

  public InvalidClientException(String message) {
    super(message);
    this.error = new DomainError(message);
  }

  public DomainError error() {
    return error;
  }
}
