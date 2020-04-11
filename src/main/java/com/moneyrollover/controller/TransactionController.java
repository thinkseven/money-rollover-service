package com.moneyrollover.controller;

import com.moneyrollover.model.Transaction;
import com.moneyrollover.model.TransactionDto;
import com.moneyrollover.repository.TransactionRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

  @Autowired
  TransactionRepository transactionRepository;

  /**
   * Get all transactions.
   * @return
   */
  @GetMapping("/Transaction")
  public List<TransactionDto> getAllTransaction() {
    return transactionRepository
      .findAll(Sort.by(Sort.Direction.ASC, "dueDate", "name"))
      .stream()
      .map(this::mapperToDto)
      .collect(Collectors.toList());
  }

  /**
   * Create a new Transaction.
   * @param transaction create new transaction
   * @return
   */
  @PostMapping("/Transaction")
  public TransactionDto createTransaction(@RequestBody TransactionDto transaction) {
    return this.mapperToDto(transactionRepository.save(this.mapperToEntity(transaction)));
  }

  /**
   * find an Transaction.
   * @param transactionId return the transaction for given transactionId
   * @return
   */
  @GetMapping("/Transaction/{id}")
  public TransactionDto getTransactionById(@PathVariable(value = "id") int transactionId) {
    return transactionRepository
      .findById(transactionId)
      .map(this::mapperToDto)
      .orElseThrow(() -> new TransactionNotFoundException(transactionId));
  }

  /**
   * update an Transaction.
   * @param transactionId find the transaction by given accountId
   * @param transactionDetails update the found transaction with new details
   * @return
   */
  @PutMapping("/Transaction/{id}")
  public TransactionDto updateTransaction(@PathVariable(value = "id") int transactionId,
      @RequestBody TransactionDto transactionDetails) {

    Transaction transaction = transactionRepository
        .findById(transactionId)
        .orElseThrow(() -> new TransactionNotFoundException(transactionId));

    transaction.setAccountId(transactionDetails.getAccountId());
    transaction.setName(transactionDetails.getName());
    transaction.setDueDate(transactionDetails.getDueDate());
    transaction.setPostDate(transactionDetails.getPostDate());
    transaction.setAmount(transactionDetails.getAmount());
    transaction.setTransactionType(transactionDetails.getTransactionType());
    transaction.setComments(transactionDetails.getComments());
    transaction.setModifiedDate();

    return this.mapperToDto(transactionRepository.save(transaction));
  }

  /**
   * Delete a transaction.
   * @param transactionId find the transaction by given transactionId to delete 
   *      otherwise throw Account Not found exception
   * @return
   */
  @DeleteMapping("/Transaction/{id}")
  public ResponseEntity<Object> deleteTransaction(@PathVariable(value = "id") int transactionId) {
    Transaction transaction = transactionRepository
        .findById(transactionId)
        .orElseThrow(() -> new TransactionNotFoundException(transactionId));

    transactionRepository.delete(transaction);

    return ResponseEntity.ok().build();
  }

  private TransactionDto mapperToDto(Transaction transaction) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(transaction, TransactionDto.class);    
  }

  private Transaction mapperToEntity(TransactionDto transaction) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(transaction, Transaction.class);
  }

}