package com.springboot.bankapplication.service;

import java.util.List;

import com.springboot.bankapplication.dto.TransactionDetailsResponseDto;

public interface StatementService {
	List<TransactionDetailsResponseDto> monthlyStatement(Long accountNumber, String month, String year);
}
