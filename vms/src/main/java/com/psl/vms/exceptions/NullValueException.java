package com.psl.vms.exceptions;

public class NullValueException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NullValueException(){}
	public NullValueException(String s){
		super(s);
	}
	public NullValueException(Throwable t){
		super(t);
	}
	public NullValueException(String s, Throwable t){
		super(s, t);
	}
	public NullValueException(String s, Throwable t, boolean enableSuppression, boolean writableStackTrace){
		super(s, t, enableSuppression, writableStackTrace);
	}
}
