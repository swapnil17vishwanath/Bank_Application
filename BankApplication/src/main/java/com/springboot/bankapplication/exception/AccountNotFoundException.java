package com.springboot.bankapplication.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String message) {
		super(message);
	}

	public AccountNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
