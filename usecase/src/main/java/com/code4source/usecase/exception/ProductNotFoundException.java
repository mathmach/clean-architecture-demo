package com.code4source.usecase.exception;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(final String message) {
		super(message);
	}
}
