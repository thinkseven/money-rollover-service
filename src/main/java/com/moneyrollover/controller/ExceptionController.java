package com.moneyrollover.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

  /**
   * throw account not found exception.
   * @param exception process AccountNotFoundException
   * @return
   */
  @ExceptionHandler(value = AccountNotFoundException.class)
  public ResponseEntity<AccountNotFoundResponse> exception(
      AccountNotFoundException exception) {
    return new ResponseEntity<>(
        new AccountNotFoundResponse(exception.getMessage()),
        HttpStatus.NOT_FOUND);
  }

  /**
   * throw account not found exception.
   * @param exception process TransactionNotFoundException
   * @return
   */
  @ExceptionHandler(value = TransactionNotFoundException.class)
  public ResponseEntity<TransactionNotFoundResponse> exception(
      TransactionNotFoundException exception) {
    return new ResponseEntity<>(
        new TransactionNotFoundResponse(exception.getMessage()),
        HttpStatus.NOT_FOUND);
  }
}