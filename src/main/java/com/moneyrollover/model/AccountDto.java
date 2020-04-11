package com.moneyrollover.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {

  int accountId;

  String name;

  double initialBalance;

  double currentBalance;

  String accountType;

  Date paymentDueDay;

  Date statementClosingDay;

  double installmentAmount;

  String comments;

}