package com.springboot.bankapplication.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankapplication.dto.TransactionDetailsResponseDto;
import com.springboot.bankapplication.service.StatementService;

@RestController
@RequestMapping("/api/bank")
public class StatementController {

	@Autowired
	private StatementService statementService;

	@PostMapping("/statement")
	public ResponseEntity<List<TransactionDetailsResponseDto>> monthlyStatement(@NotNull @RequestParam Long accountNumber,
			@NotNull @RequestParam String month,@NotNull @RequestParam String year) {
		if (accountNumber != 0) {
			List<TransactionDetailsResponseDto> detailsResponseDtos = statementService.monthlyStatement(accountNumber,
					month, year);
			return new ResponseEntity<List<TransactionDetailsResponseDto>>(detailsResponseDtos, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
