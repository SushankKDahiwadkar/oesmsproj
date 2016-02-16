package com.psl.vms.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.psl.vms.exceptions.ApplicationBaseException;
import com.psl.vms.model.MessageInfo;

public class BaseController {

	private static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	@ExceptionHandler(ApplicationBaseException.class)
	public ResponseEntity<Object> handleError(HttpServletRequest req, ApplicationBaseException exception) {
		LOGGER.error("Request: " + req.getRequestURL() + " raised " + exception);

		return new ResponseEntity<Object>(new MessageInfo(exception.getMessage(), exception.getHttpStatus().toString()),
				exception.getHttpStatus());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleOtherExceptions(HttpServletRequest req, Exception exception) {
		LOGGER.error("Request: " + req.getRequestURL() + " raised " + exception);

		return new ResponseEntity<Object>(
				new MessageInfo(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ResponseEntity<Object> responseCreated (HttpServletRequest req){
		return new ResponseEntity<Object>(new MessageInfo("Created", HttpStatus.CREATED.toString()), HttpStatus.CREATED);
	}

}
