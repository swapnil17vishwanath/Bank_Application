package com.springboot.bankapplication.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankapplication.dto.TransactionDetailsResponseDto;
import com.springboot.bankapplication.entity.CustomerAccountDetails;
import com.springboot.bankapplication.entity.TransactionDetails;
import com.springboot.bankapplication.exception.AccountNotFoundException;
import com.springboot.bankapplication.repository.CustomerAccountDetailsRepository;
import com.springboot.bankapplication.repository.TransactionDeatilsRepository;
import com.springboot.bankapplication.service.StatementService;
import com.springboot.bankapplication.util.BankUtility;

@Service
public class StatementServiceImpl implements StatementService {

	@Autowired
	private TransactionDeatilsRepository transactionDeatilsRepository;

	@Autowired
	private CustomerAccountDetailsRepository customerAccountDetailsRepository;

	@Override
	public List<TransactionDetailsResponseDto> monthlyStatement(Long accountNumber, String month, String year) {

		CustomerAccountDetails getAccount = customerAccountDetailsRepository.findByAccountNumber(accountNumber);

		if (getAccount == null) {
			throw new AccountNotFoundException("Account Number is not valid");
		}

		List<TransactionDetailsResponseDto> detailsResponseDtos = new ArrayList<TransactionDetailsResponseDto>();

		/*
		 * Converting in date format
		 */
		List<LocalDate> dateList = BankUtility.convertMonthIntoDate(month, year);

		LocalDate endDate = dateList.get(0);
		LocalDate startDate = dateList.get(1);

		List<TransactionDetails> listOfTransaction = transactionDeatilsRepository
				.findByTransactionDateBetween(startDate, endDate);

		for (TransactionDetails details : listOfTransaction) {

			TransactionDetailsResponseDto responseDto = new TransactionDetailsResponseDto();

			if (accountNumber.toString().equals(details.getCreditTo().toString())
					|| accountNumber.toString().equals(details.getDebitFrom().toString())) {

				responseDto.setAccountNumber(accountNumber);
				responseDto.setAmount(details.getAmount());
				responseDto.setTransactionDate(details.getTransactionDate());
				if (accountNumber.toString().equals(details.getCreditTo().toString())) {
					responseDto.setCreditFrom(details.getDebitFrom());
					responseDto.setDebitTo(0L);
				}
				if (accountNumber.toString().equals(details.getDebitFrom().toString())) {
					responseDto.setDebitTo(details.getCreditTo());
					responseDto.setCreditFrom(0L);
				}

				detailsResponseDtos.add(responseDto);
			}

		}

		return detailsResponseDtos;
	}

}
