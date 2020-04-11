package com.moneyrollover.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TransactionId")
  private int transactionId;

  @Column(name = "AccountId")
  private int accountId;

  @Column(name = "Name")
  private String name;

  @Column(name = "DueDate")
  private Date dueDate;

  @Column(name = "PostedDate")
  private Date postDate;

  @Column(name = "Amount")
  private double amount;

  @Column(name = "TransactionType")
  private boolean transactionType;

  @Column(name = "Comments")
  private String comments;

  @Column(name = "CreatedDate")
  private Date createdDate = new Date();

  @Column(name = "ModifiedDate")
  private Date modifiedDate = new Date();

  public int getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(int transactionId) {
    this.transactionId = transactionId;
  }

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

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date date) {
    this.dueDate = date;
  }

  public Date getPostDate() {
    return postDate;
  }

  public void setPostDate(Date date) {
    this.postDate = date;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public boolean getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(boolean transactionType) {
    this.transactionType = transactionType;
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