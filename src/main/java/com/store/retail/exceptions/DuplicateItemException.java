package com.store.retail.exceptions;

public class DuplicateItemException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DuplicateItemException(String message) {
		super(message);
	}
}
