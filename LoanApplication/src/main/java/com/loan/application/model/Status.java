package com.loan.application.model;


/////Model of Status for passing the object to the front end
public class Status<T> {
	
	int statusCode;
	T message;
	
	public Status(int statusCode, T message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public T getMessage() {
		return message;
	}

	public void setMessage(T message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Status [statusCode=" + statusCode + ", message=" + message + "]";
	}
	
	

}
