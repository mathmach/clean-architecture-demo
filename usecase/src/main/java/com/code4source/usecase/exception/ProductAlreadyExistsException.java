package com.code4source.usecase.exception;

public class ProductAlreadyExistsException extends RuntimeException {
	public ProductAlreadyExistsException(final String email) {
		super(email);
	}
}
