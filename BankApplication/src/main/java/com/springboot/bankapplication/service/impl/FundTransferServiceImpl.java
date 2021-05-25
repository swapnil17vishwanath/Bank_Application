package com.springboot.bankapplication.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bankapplication.dto.FundTransferDto;
import com.springboot.bankapplication.entity.CustomerAccountDetails;
import com.springboot.bankapplication.entity.TransactionDetails;
import com.springboot.bankapplication.exception.AccountNotFoundException;
import com.springboot.bankapplication.repository.CustomerAccountDetailsRepository;
import com.springboot.bankapplication.repository.TransactionDeatilsRepository;
import com.springboot.bankapplication.service.FundTransferService;

@Service
@Transactional
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	private CustomerAccountDetailsRepository customerAccountDetailsRepository;

	@Autowired
	private TransactionDeatilsRepository transactionDeatilsRepository;

	@Override
	public FundTransferDto fundtransfer(Long fromAccountNumber, Long toAccountNumber, double amount) {
		
		if (fromAccountNumber.equals(toAccountNumber)) {
			throw new AccountNotFoundException(" Sender can't send amount in same Account Number ");
		}
		CustomerAccountDetails fromAccountDetails = customerAccountDetailsRepository.findByAccountNumber(fromAccountNumber);
		if (fromAccountDetails == null) {
			throw new AccountNotFoundException(" Sender Account Number is not valid ");
		}

		CustomerAccountDetails toAccountDetails = customerAccountDetailsRepository.findByAccountNumber(toAccountNumber);
		if (toAccountDetails == null) {
			throw new AccountNotFoundException(" Receiver Account Number is not valid ");
		}

		double remainingBalance = 0;
		double creaditBalance = 0;

		if (fromAccountDetails.getAvailableBalance() >= amount) {

			remainingBalance = fromAccountDetails.getAvailableBalance() - amount;
			creaditBalance = toAccountDetails.getAvailableBalance() + amount;

			fromAccountDetails.setAvailableBalance(remainingBalance);
			toAccountDetails.setAvailableBalance(creaditBalance);

		}

		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setAmount(amount);
		transactionDetails.setTransactionDate(LocalDate.now());
		transactionDetails.setDebitFrom(fromAccountNumber);
		transactionDetails.setCreditTo(toAccountNumber);
		transactionDeatilsRepository.save(transactionDetails);

		return new FundTransferDto(fromAccountNumber, toAccountNumber, amount,
				"Rs." + amount + " Transfer Successfully to " + toAccountNumber,
				transactionDetails.getTransactionDate());

	}

}
