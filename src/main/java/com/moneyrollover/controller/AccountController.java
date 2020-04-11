package com.moneyrollover.controller;

import com.moneyrollover.model.Account;
import com.moneyrollover.repository.AccountRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class AccountController {

  Logger logger = LoggerFactory.getLogger(AccountController.class);

  @Autowired
  AccountRepository accountRepository;

  // Get all accounts
  @GetMapping("/Account")
  public List<Account> getAllAccount() {
    logger.info("get all accounts");
    return accountRepository.findAll(Sort.by(Sort.Direction.ASC, "paymentDueDay"));
  }

  // Create a new account
  @PostMapping("/Account")
  public Account createAccount(@RequestBody Account account) {
    return accountRepository.save(account);
  }

  /**
   * find the account.
   * @param accountId find the account with given accountId
   * @return
   */
  @GetMapping("/Account/{id}")
  public Account getAccountById(@PathVariable(value = "id") int accountId) {
    return accountRepository
      .findById(accountId)
      .orElseThrow(() -> new AccountNotFoundException(accountId));
  }

  /**
   * Update the account.
   * @param accountId find the account by given accountId
   * @param accountDetails update the found account with new details
   * @return
   */
  @PutMapping("/Account/{id}")
  public Account updateAccount(@PathVariable(value = "id") int accountId,
      @RequestBody Account accountDetails) {

    Account account = accountRepository
        .findById(accountId)
        .orElseThrow(() -> new AccountNotFoundException(accountId));

    account.setName(accountDetails.getName());
    account.setInitialBalance(accountDetails.getInitialBalance());
    account.setCurrentBalance(accountDetails.getCurrentBalance());
    account.setAccountType(accountDetails.getAccountType());
    account.setPaymentDueDay(accountDetails.getPaymentDueDay());
    account.setStatementClosingDay(accountDetails.getStatementClosingDay());
    account.setInstallmentAmount(accountDetails.getInstallmentAmount());
    account.setComments(accountDetails.getComments());
    account.setModifiedDate();

    return accountRepository.save(account);
  }

  /**
   * Delete a acccount.
   * @param accountId find the account by given accountId to delete 
   *      otherwise throw Account Not found exception
   * @return
   */
  @DeleteMapping("/Account/{id}")
  public ResponseEntity<Object> deleteAccount(@PathVariable(value = "id") int accountId) {
    Account account = accountRepository
        .findById(accountId)
        .orElseThrow(() -> new AccountNotFoundException(accountId));

    accountRepository.delete(account);
    
    return ResponseEntity.ok().build();
  }
}