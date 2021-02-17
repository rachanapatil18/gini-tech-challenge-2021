package net.gini.challenge.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import net.gini.challenge.exceptions.DataCommunicationException;
import net.gini.challenge.model.ExceptionResponse;

/**
 * Customised class handles all known exceptions.
 * 
 * @author Rachana
 *
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler {
	
	@ExceptionHandler(DataCommunicationException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public final ExceptionResponse handleAllExceptions(DataCommunicationException ex, WebRequest request) {
		return new ExceptionResponse(new Date(), ex.getMessage(), "Data source broken!!! " + ex.getApiName());
	}

}
