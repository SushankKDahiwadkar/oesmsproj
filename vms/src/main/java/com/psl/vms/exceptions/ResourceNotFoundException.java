package com.psl.vms.exceptions;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Mahesh_Kurade
 *
 */
public class ResourceNotFoundException extends ApplicationBaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4404705408272240813L;
	/**
	 * 
	 */
	HttpStatus httpStatus = HttpStatus.NOT_FOUND;

	/**
	 * 
	 */
	public ResourceNotFoundException() {

	}

	/**
	 * 
	 * @param message
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param t
	 */
	public ResourceNotFoundException(Throwable t) {
		super(t);
	}

	/**
	 * 
	 * @param s
	 * @param t
	 */
	public ResourceNotFoundException(String s, Throwable t) {
		super(s, t);
	}

	/**
	 * 
	 * @param s
	 * @param t
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ResourceNotFoundException(String s, Throwable t, boolean enableSuppression, boolean writableStackTrace) {
		super(s, t, enableSuppression, writableStackTrace);
	}

}
