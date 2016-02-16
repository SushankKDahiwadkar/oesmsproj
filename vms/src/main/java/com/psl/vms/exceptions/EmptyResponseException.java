package com.psl.vms.exceptions;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Mahesh_Kurade
 *
 */
public class EmptyResponseException extends ApplicationBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2013195595770657326L;
	/**
	 * 
	 */
	HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;

	/**
	 * 
	 */
	public EmptyResponseException() {

	}

	/**
	 * 
	 * @param message
	 */
	public EmptyResponseException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param t
	 */
	public EmptyResponseException(Throwable t) {
		super(t);
	}

	/**
	 * 
	 * @param s
	 * @param t
	 */
	public EmptyResponseException(String s, Throwable t) {
		super(s, t);
	}

	/**
	 * 
	 * @param s
	 * @param t
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public EmptyResponseException(String s, Throwable t, boolean enableSuppression, boolean writableStackTrace) {
		super(s, t, enableSuppression, writableStackTrace);
	}

}
