package com.springboot.bankapplication.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InsufficientBalanceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InsufficientBalanceException(String message) {
		super(message);
	}
}
