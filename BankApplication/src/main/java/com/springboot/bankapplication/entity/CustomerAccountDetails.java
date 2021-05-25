package com.springboot.bankapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CustomerAccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long accountId;
	@JsonIgnore
	private Long accountNumber;
	private String accountType;
	@JsonIgnore
	private double availableBalance;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private BankCustomer bankCustomer;

	public CustomerAccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerAccountDetails(Long accountNumber, String accountType, double availableBalance, long customerId,
			BankCustomer bankCustomer) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.availableBalance = availableBalance;
		this.bankCustomer = bankCustomer;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public BankCustomer getBankCustomer() {
		return bankCustomer;
	}

	public void setBankCustomer(BankCustomer bankCustomer) {
		this.bankCustomer = bankCustomer;
	}

	@Override
	public String toString() {
		return "CustomerAccountDetails [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountType="
				+ accountType + ", availableBalance=" + availableBalance + ", bankCustomer=" + bankCustomer + "]";
	}
	
	

}
