package com.springboot.bankapplication.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankapplication.dto.FundTransferDto;
import com.springboot.bankapplication.service.FundTransferService;

@RestController
@RequestMapping("/api/bank")
public class FundTransferController {
	
	@Autowired
	private FundTransferService fundTransferService;
	
	@PostMapping("/fundtransfer")
	public ResponseEntity<FundTransferDto> fundtransfer(@NotNull @RequestParam Long fromAccountNumber,@NotNull @RequestParam Long toAccountNumber,
			@NotNull @RequestParam double amount) {
		if (fromAccountNumber != 0 && toAccountNumber !=0 && amount != 0) {
			FundTransferDto fundTransferDto=  fundTransferService.fundtransfer(fromAccountNumber, toAccountNumber, amount);
			return new ResponseEntity<FundTransferDto>(fundTransferDto, HttpStatus.OK);
		}
		 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
