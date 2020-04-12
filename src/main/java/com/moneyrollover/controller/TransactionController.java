package com.moneyrollover.controller;

import com.moneyrollover.model.TransactionDto;
import com.moneyrollover.service.TransactionService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
  
  Logger logger = LoggerFactory.getLogger(TransactionController.class);

  @Autowired
  TransactionService transactionService;

  /**
   * Get all transactions.
   * @return
   */
  @GetMapping
  public List<TransactionDto> getAllTransaction() {
    logger.info("get all transactions");
    return transactionService.getAllTransactions();
  }

  /**
   * Create a new Transaction.
   * @param transaction create new transaction
   * @return
   */
  @PostMapping
  public TransactionDto createTransaction(@RequestBody TransactionDto transaction) {
    logger.info("create new transaction");
    return transactionService.createTransaction(transaction);
  }

  /**
   * find an Transaction.
   * @param transactionId return the transaction for given transactionId
   * @return
   */
  @GetMapping("/{id}")
  public TransactionDto getTransactionById(@PathVariable(value = "id") int transactionId) {
    logger.info("find transaction");
    return transactionService.getTransaction(transactionId);
  }

  /**
   * update an Transaction.
   * @param transactionId find the transaction by given accountId
   * @param transactionDetails update the found transaction with new details
   * @return
   */
  @PutMapping("/{id}")
  public TransactionDto updateTransaction(@PathVariable(value = "id") int transactionId,
      @RequestBody TransactionDto transactionDetails) {
    logger.info("update transaction");
    return transactionService.updateTransaction(transactionId, transactionDetails);
  }

  /**
   * Delete a transaction.
   * @param transactionId find the transaction by given transactionId to delete 
   *      otherwise throw Account Not found exception
   * @return
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteTransaction(@PathVariable(value = "id") int transactionId) {
    transactionService.deleteTransaction(transactionId);
    logger.info("deleted transaction");
    return ResponseEntity.ok().build();
  }
  
}