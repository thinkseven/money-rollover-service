package com.moneyrollover.controller;

public class AccountNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 8853311789797876422L;

    public AccountNotFoundException(Integer id) {
        super(String.format("Account is not found with id : '%s'", id));
    }
}