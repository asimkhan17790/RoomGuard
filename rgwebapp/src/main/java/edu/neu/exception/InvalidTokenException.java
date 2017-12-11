package edu.neu.exception;

public class InvalidTokenException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		private String errorMessage;
	 
		public String getErrorMessage() {
			return errorMessage;
		}
		public InvalidTokenException(String errorMessage) {
			super(errorMessage);
			this.errorMessage = errorMessage;
		}
		public InvalidTokenException() {
			super();
		}
	}