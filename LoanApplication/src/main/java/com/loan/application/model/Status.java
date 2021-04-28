package com.loan.application.model;

public class Status {
	
	int statusCode;
	String message;
	
	public Status(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Status [statusCode=" + statusCode + ", message=" + message + "]";
	}
	
	

}
