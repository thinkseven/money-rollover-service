package com.moneyrollover.controller;

import com.moneyrollover.model.Transaction;
import com.moneyrollover.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    // Get all Transactions
    @GetMapping("/Transaction")
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll(Sort.by(Sort.Direction.ASC, "dueDate", "name"));
    }

    // Create a new Transaction
    @PostMapping("/Transaction")
    public Transaction createTransaction(@RequestBody Transaction Transaction) {
        return transactionRepository.save(Transaction);
    }

    // find an Transaction
    @GetMapping("/Transaction/{id}")
    public Transaction getTransactionById(@PathVariable(value = "id") Integer TransactionId)
            throws TransactionNotFoundException {
        return transactionRepository.findById(TransactionId)
                .orElseThrow(() -> new TransactionNotFoundException(TransactionId));
    }

    // update an Transaction
    @PutMapping("/Transaction/{id}")
    public Transaction updateTransaction(@PathVariable(value = "id") Integer TransactionId,
            @RequestBody Transaction transactionDetails) throws TransactionNotFoundException {

        Transaction transaction = transactionRepository.findById(TransactionId)
                .orElseThrow(() -> new TransactionNotFoundException(TransactionId));

        transaction.setAccountId(transactionDetails.getAccountId());
        transaction.setName(transactionDetails.getName());
        transaction.setDueDate(transactionDetails.getDueDate());
        transaction.setPostDate(transactionDetails.getPostDate());
        transaction.setAmount(transactionDetails.getAmount());
        transaction.setTransactionType(transactionDetails.getTransactionType());
        transaction.setComments(transactionDetails.getComments());
        transaction.setModifiedDate();
        Transaction updatedTransaction = transactionRepository.save(transaction);

        return updatedTransaction;
    }

    // Delete a Note
    @DeleteMapping("/Transaction/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable(value = "id") Integer TransactionId)
            throws TransactionNotFoundException {
        Transaction Transaction = transactionRepository.findById(TransactionId)
                .orElseThrow(() -> new TransactionNotFoundException(TransactionId));

        transactionRepository.delete(Transaction);

        return ResponseEntity.ok().build();
    }
}