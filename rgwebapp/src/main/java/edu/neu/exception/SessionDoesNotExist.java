package edu.neu.exception;

public class SessionDoesNotExist extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
 
	public String getErrorMessage() {
		return errorMessage;
	}
	public SessionDoesNotExist(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public SessionDoesNotExist() {
		super();
	}

}
