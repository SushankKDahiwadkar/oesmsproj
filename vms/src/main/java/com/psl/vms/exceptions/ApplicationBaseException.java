package com.psl.vms.exceptions;



import org.springframework.http.HttpStatus;

/**
 * 
 * @author Mahesh_Kurade
 *
 */
public class ApplicationBaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7662616986379903561L;
	
	/**
	 * Http status this exception class represent
	 */
	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

	public ApplicationBaseException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ApplicationBaseException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ApplicationBaseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ApplicationBaseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ApplicationBaseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return HttpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * 
	 * @param httpStatus
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
