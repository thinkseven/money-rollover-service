package com.moneyrollover.controller;

public class AccountNotFoundResponse {
  private String message;

  public AccountNotFoundResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}