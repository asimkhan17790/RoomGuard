package edu.neu.exception;

public class MailNotSentException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  MailNotSentException() {
		super();
	}
	public MailNotSentException(String message) {
		super(message);
	}
	public MailNotSentException(String message, Throwable cause) {
		super(message,cause);
	}
}
