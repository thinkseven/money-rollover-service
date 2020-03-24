package com.moneyrollover.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountExceptionController {

    @ExceptionHandler(value = AccountNotFoundException.class)
    public ResponseEntity<AccountNotFoundResponse> exception(AccountNotFoundException exception) {
        return new ResponseEntity<AccountNotFoundResponse>(new AccountNotFoundResponse(exception.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}