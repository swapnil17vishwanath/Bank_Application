package com.springboot.bankapplication.dto;

import java.time.LocalDate;

public class FundTransferDto {

	private Long fromAccountNo;
	private Long toAccountNo;
	private double amount;
	private String message;
	private LocalDate transactionDate;

	public FundTransferDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FundTransferDto(Long fromAccountNo, Long toAccountNo, double amount, String message,
			LocalDate transactionDate) {
		super();
		this.fromAccountNo = fromAccountNo;
		this.toAccountNo = toAccountNo;
		this.amount = amount;
		this.message = message;
		this.transactionDate = transactionDate;
	}

	public Long getFromAccountNo() {
		return fromAccountNo;
	}

	public void setFromAccountNo(Long fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}

	public Long getToAccountNo() {
		return toAccountNo;
	}

	public void setToAccountNo(Long toAccountNo) {
		this.toAccountNo = toAccountNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

}
