package com.moneyrollover.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {

  int transactionId;
  int accountId;
  String name;
  Date dueDate;
  Date postDate;
  double amount;
  Boolean transactionType;
  String comments;

}