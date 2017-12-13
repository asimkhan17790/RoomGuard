package edu.neu.exception;

import org.springframework.http.HttpStatus;

public class PersonErrorInformation {
	private HttpStatus ErrorCode;
	private String description;
	public HttpStatus getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(HttpStatus conflict) {
		ErrorCode = conflict;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
