package com.code4source.usecase.exception;

public class ProductValidationException extends RuntimeException {
	public ProductValidationException(final String message) {
		super(message);
	}
}
