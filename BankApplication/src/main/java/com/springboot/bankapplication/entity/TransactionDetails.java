package com.springboot.bankapplication.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	private Long debitFrom;
	private Long creditTo;
	private double amount;
	private LocalDate transactionDate;

	public TransactionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionDetails(Long transactionId, Long debitFrom, Long creditTo, double amount,
			LocalDate transactionDate) {
		super();
		this.transactionId = transactionId;
		this.debitFrom = debitFrom;
		this.creditTo = creditTo;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Long getDebitFrom() {
		return debitFrom;
	}

	public void setDebitFrom(Long debitFrom) {
		this.debitFrom = debitFrom;
	}

	public Long getCreditTo() {
		return creditTo;
	}

	public void setCreditTo(Long creditTo) {
		this.creditTo = creditTo;
	}

}
