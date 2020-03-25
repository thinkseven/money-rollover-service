package com.moneyrollover.controller;

public class TransactionNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 8853311789797876422L;

    public TransactionNotFoundException(Integer id) {
        super(String.format("Transaction is not found with id : '%s'", id));
    }
}