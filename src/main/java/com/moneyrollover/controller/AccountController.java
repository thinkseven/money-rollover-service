package com.moneyrollover.controller;

import com.moneyrollover.model.AccountDto;
import com.moneyrollover.service.AccountService;
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
@RequestMapping("/Account")
public class AccountController {

  Logger logger = LoggerFactory.getLogger(AccountController.class);

  @Autowired
  AccountService accountService;

  /**
   * Get all accounts.
   * @return
   */
  @GetMapping
  public List<AccountDto> getAllAccount() {
    logger.info("get all accounts");
    return accountService.getAllAccounts();
  }

  /**
   * Create a new account.
   * @param account create new account
   * @return
   */
  @PostMapping
  public AccountDto createAccount(@RequestBody AccountDto account) {
    logger.info("create new account");
    return accountService.createAccount(account);
  }

  /**
   * find the account.
   * @param accountId find the account with given accountId
   * @return
   */
  @GetMapping("/{id}")
  public AccountDto getAccountById(@PathVariable(value = "id") int accountId) {
    logger.info("find new account");
    return accountService.getAccount(accountId);
  }

  /**
   * Update the account.
   * @param accountId find the account by given accountId
   * @param accountDetails update the found account with new details
   * @return
   */
  @PutMapping("/{id}")
  public AccountDto updateAccount(@PathVariable(value = "id") int accountId,
      @RequestBody AccountDto accountDetails) {
    logger.info("update account");
    return accountService.updateAccount(accountId, accountDetails);
  }

  /**
   * Delete a acccount.
   * @param accountId find the account by given accountId to delete 
   *      otherwise throw Account Not found exception
   * @return
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteAccount(@PathVariable(value = "id") int accountId) {
    logger.info("delete account");
    accountService.deleteAccount(accountId);    
    return ResponseEntity.ok().build();
  }

}