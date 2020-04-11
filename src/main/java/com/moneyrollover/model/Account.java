package com.moneyrollover.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "AccountId")
  private int accountId;

  @Column(name = "Name")
  private String name;

  @Column(name = "InitialBalance")
  private double initialBalance;

  @Column(name = "CurrentBalance")
  private double currentBalance;

  @Column(name = "AccountType")
  private String accountType;

  @Column(name = "PaymentDueDay")
  private Date paymentDueDay;

  @Column(name = "StatementClosingDay")
  private Date statementClosingDay;

  @Column(name = "InstallmentAmount")
  private double installmentAmount;

  @Column(name = "Comments")
  private String comments;

  @Column(name = "CreatedDate")
  private Date createdDate = new Date();

  @Column(name = "ModifiedDate")
  private Date modifiedDate = new Date();

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getInitialBalance() {
    return initialBalance;
  }

  public void setInitialBalance(double initialBalance) {
    this.initialBalance = initialBalance;
  }

  public double getCurrentBalance() {
    return currentBalance;
  }

  public void setCurrentBalance(double currentBalance) {
    this.currentBalance = currentBalance;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public Date getPaymentDueDay() {
    return paymentDueDay;
  }

  public void setPaymentDueDay(Date paymentDueDay) {
    this.paymentDueDay = paymentDueDay;
  }

  public Date getStatementClosingDay() {
    return statementClosingDay;
  }

  public void setStatementClosingDay(Date statementClosingDay) {
    this.statementClosingDay = statementClosingDay;
  }

  public double getInstallmentAmount() {
    return installmentAmount;
  }

  public void setInstallmentAmount(double installmentAmount) {
    this.installmentAmount = installmentAmount;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public Date getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate() {
    this.modifiedDate = new Date();
  }

}