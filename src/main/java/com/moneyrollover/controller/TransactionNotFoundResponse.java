package com.moneyrollover.controller;

public class TransactionNotFoundResponse {
  private String message;

  public TransactionNotFoundResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}