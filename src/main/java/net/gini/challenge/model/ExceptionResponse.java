package net.gini.challenge.model;

import java.util.Date;

/**
 * 
 * @author Rachana 
 * Adding error information for response
 */
public class ExceptionResponse {

	private String message;
	private String details;
	private Date timestamp;

	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

}
