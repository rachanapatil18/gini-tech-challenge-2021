/**
 * 
 */
package net.gini.challenge.exceptions;

/**
 * @author Rachana
 * Represents any communication failure that could happen with
 * 3rd party data providers
 */
 public class DataCommunicationException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String apiName = null;

	private String apiEndpoint = null;

	public DataCommunicationException(String message, Throwable cause, String apiName, String apiEndPoint) {
		super(message, cause);
		this.apiName = apiName;
		this.apiEndpoint = apiEndPoint;
	}

	public String getApiName() {
		return apiName;
	}

	public String getApiEndpoint() {
		return apiEndpoint;
	}

}
