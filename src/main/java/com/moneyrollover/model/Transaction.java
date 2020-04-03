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
    private Integer transactionId;

    @Column(name = "AccountId")
    private Integer accountId;

    @Column(name = "Name")
    private String name;

    @Column(name = "DueDate")
    private Date dueDate;

    @Column(name = "PostedDate")
    private Date postDate;

    @Column(name = "Amount")
    private Double amount;

    @Column(name = "TransactionType")
    private Boolean transactionType;

    @Column(name = "Comments")
    private String comments;

    @Column(name = "CreatedDate")
    private Date createdDate = new Date();

    @Column(name = "ModifiedDate")
    private Date modifiedDate = new Date();

    public Transaction() {

    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Boolean transactionType) {
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