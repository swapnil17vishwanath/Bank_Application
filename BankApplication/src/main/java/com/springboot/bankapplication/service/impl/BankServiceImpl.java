package com.springboot.bankapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankapplication.dto.BankCustomerResponseDto;
import com.springboot.bankapplication.entity.BankCustomer;
import com.springboot.bankapplication.entity.CustomerAccountDetails;
import com.springboot.bankapplication.repository.BankCustomerRepository;
import com.springboot.bankapplication.service.BankService;
import com.springboot.bankapplication.util.BankUtility;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankCustomerRepository bankCustomerRepository;


	CustomerAccountDetails accountDetails = null;

	@Override
	public BankCustomerResponseDto registerCustomer(BankCustomer bankCustomer) {

		accountDetails = new CustomerAccountDetails();
		accountDetails.setAccountNumber(BankUtility.bankAccountNoCreator());
		accountDetails.setAccountType(bankCustomer.getCustomerAccountDetails().getAccountType());
		accountDetails.setAvailableBalance(5000);
		accountDetails.setBankCustomer(bankCustomer);
		
		bankCustomer.setCustomerAccountDetails(accountDetails);
		
		BankCustomer createdCustomer = bankCustomerRepository.save(bankCustomer);

		BankCustomerResponseDto bankCustomerResponseDto = new BankCustomerResponseDto(createdCustomer.getFirstName(),
				createdCustomer.getLastName(), createdCustomer.getCity(), createdCustomer.getMobileNo(),
				createdCustomer.getCustomerAccountDetails().getAccountNumber(), createdCustomer.getCustomerAccountDetails().getAvailableBalance());

		return bankCustomerResponseDto;
	}

}
