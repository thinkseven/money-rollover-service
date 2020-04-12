package com.moneyrollover.service;

import com.moneyrollover.controller.TransactionNotFoundException;
import com.moneyrollover.model.Transaction;
import com.moneyrollover.model.TransactionDto;
import com.moneyrollover.repository.TransactionRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

  Logger logger = LoggerFactory.getLogger(TransactionService.class);

  @Autowired
  TransactionRepository transactionRepository;

  /**
   * Get all transactions.
   * @return
   */
  public List<TransactionDto> getAllTransactions() {
    return transactionRepository
      .findAll(Sort.by(Sort.Direction.ASC, "dueDate", "name"))
      .stream()
      .map(this::mapperToDto)
      .collect(Collectors.toList());
  } 
  
  /**
   * find an Transaction.
   * @param transactionId return the transaction for given transactionId
   * @return
   */
  public TransactionDto getTransaction(int transactionId) {
    return transactionRepository
      .findById(transactionId)
      .map(this::mapperToDto)
      .orElseThrow(() -> new TransactionNotFoundException(transactionId));
  }

  /**
   * Create a new Transaction.
   * @param transaction create new transaction
   * @return
   */
  public TransactionDto createTransaction(TransactionDto transaction) {
    return this.mapperToDto(transactionRepository.save(this.mapperToEntity(transaction)));
  }

  /**
   * update an Transaction.
   * @param transactionId find the transaction by given accountId
   * @param transactionDetails update the found transaction with new details
   * @return
   */
  public TransactionDto updateTransaction(int transactionId, TransactionDto transactionDetails) {
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
  public void deleteTransaction(int transactionId) {
    Transaction transaction = transactionRepository
        .findById(transactionId)
        .orElseThrow(() -> new TransactionNotFoundException(transactionId));

    transactionRepository.delete(transaction);
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