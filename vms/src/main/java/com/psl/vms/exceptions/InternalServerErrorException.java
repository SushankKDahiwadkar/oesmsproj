package com.psl.vms.exceptions;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ApplicationBaseException {

	/**
	 * 
	 */
	HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InternalServerErrorException() {

	}

	public InternalServerErrorException(String message) {
		super(message);
	}

	public InternalServerErrorException(Throwable t) {
		super(t);
	}

	public InternalServerErrorException(String s, Throwable t) {
		super(s, t);
	}

	public InternalServerErrorException(String s, Throwable t, boolean enableSuppression, boolean writableStackTrace) {
		super(s, t, enableSuppression, writableStackTrace);
	}

}
