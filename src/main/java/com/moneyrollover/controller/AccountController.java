package com.moneyrollover.controller;

import com.moneyrollover.model.Account;
import com.moneyrollover.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Sort;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    // Get all accounts
    @GetMapping("/Account")
    public List<Account> getAllAccount() {
        return accountRepository.findAll(Sort.by(Sort.Direction.ASC, "paymentDueDay"));
    }

    // Create a new account
    @PostMapping("/Account")
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    // find an account
    @GetMapping("/Account/{id}")
    public Account getAccountById(@PathVariable(value = "id") Integer accountId) throws AccountNotFoundException {
        return accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException(accountId));
    }

    // update an account
    @PutMapping("/Account/{id}")
    public Account updateAccount(@PathVariable(value = "id") Integer accountId, @RequestBody Account accountDetails)
            throws AccountNotFoundException {

        Account account = accountRepository.findById(accountId)
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

        Account updatedAccount = accountRepository.save(account);

        return updatedAccount;
    }

    // Delete a Note
    @DeleteMapping("/Account/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") Integer accountId)
            throws AccountNotFoundException {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(accountId));

        accountRepository.delete(account);

        return ResponseEntity.ok().build();
    }
}