package com.springboot.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankapplication.dto.BankCustomerResponseDto;
import com.springboot.bankapplication.entity.BankCustomer;
import com.springboot.bankapplication.service.BankService;

@RestController
@RequestMapping("/api/bank")
public class RegisterController {

	@Autowired
	private BankService bankService;

	@PostMapping("/register")
	public ResponseEntity<BankCustomerResponseDto> registerCustomer(@RequestBody BankCustomer bankCustomer) {

		if (bankCustomer != null) {
			BankCustomerResponseDto newCreatedCustomer = bankService.registerCustomer(bankCustomer);
			return new ResponseEntity<>(newCreatedCustomer, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
