package com.moneyrollover.service;

import com.moneyrollover.controller.AccountNotFoundException;
import com.moneyrollover.model.Account;
import com.moneyrollover.model.AccountDto;
import com.moneyrollover.repository.AccountRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  Logger logger = LoggerFactory.getLogger(AccountService.class);

  @Autowired
  AccountRepository accountRepository;

  /**
   * Get all accounts.
   * @return
   */
  public List<AccountDto> getAllAccounts() {
    return accountRepository
      .findAll(Sort.by(Sort.Direction.ASC, "paymentDueDay"))
      .stream()
      .map(this::mapperToDto)
      .collect(Collectors.toList());
  } 
  
  /**
  * find the account.
  * @param accountId find the account with given accountId
  * @return
  */
  public AccountDto getAccount(int accountId) {
    return accountRepository
      .findById(accountId)
      .map(this::mapperToDto)
      .orElseThrow(() -> new AccountNotFoundException(accountId));
  }

  /**
   * Create a new account.
   * @param account create new account
   * @return
   */
  public AccountDto createAccount(AccountDto account) {
    return this.mapperToDto(accountRepository.save(this.mapperToEntity(account)));
  }

  /**
   * Update the account.
   * @param accountId find the account by given accountId
   * @param accountDetails update the found account with new details
   * @return
   */
  public AccountDto updateAccount(int accountId, AccountDto accountDetails) {
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

    return this.mapperToDto(accountRepository.save(account));
  }

  /**
   * Delete a acccount.
   * @param accountId find the account by given accountId to delete 
   *      otherwise throw Account Not found exception
   * @return
   */
  public void deleteAccount(int accountId) {
    Account account = accountRepository
        .findById(accountId)
        .orElseThrow(() -> new AccountNotFoundException(accountId));

    accountRepository.delete(account);
  }
  
  private AccountDto mapperToDto(Account account) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(account, AccountDto.class);    
  }

  private Account mapperToEntity(AccountDto account) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(account, Account.class);
  }

}