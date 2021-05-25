package com.springboot.bankapplication.dto;

import java.time.LocalDate;

public class TransactionDetailsResponseDto {

	private Long accountNumber;
	private double amount;
	private LocalDate transactionDate;
	private Long creditFrom;
	private Long debitTo;

	public TransactionDetailsResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionDetailsResponseDto(Long accountNumber, String process, double amount, LocalDate transactionDate,
			Long creditFrom, Long debitTo) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.creditFrom = creditFrom;
		this.debitTo = debitTo;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Long getCreditFrom() {
		return creditFrom;
	}

	public void setCreditFrom(Long creditFrom) {
		this.creditFrom = creditFrom;
	}

	public Long getDebitTo() {
		return debitTo;
	}

	public void setDebitTo(Long debitTo) {
		this.debitTo = debitTo;
	}

}
