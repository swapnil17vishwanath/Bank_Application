package com.springboot.bankapplication.service;

import com.springboot.bankapplication.dto.BankCustomerResponseDto;
import com.springboot.bankapplication.entity.BankCustomer;

public interface BankService {

	BankCustomerResponseDto registerCustomer(BankCustomer bankCustomer);

}
