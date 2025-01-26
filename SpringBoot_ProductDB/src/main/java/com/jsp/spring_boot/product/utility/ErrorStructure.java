package com.jsp.spring_boot.product.utility;

public class ErrorStructure {
	private int errorStatus;
	private String errorMessage;
	private String rootCause;
	
	public int getStatus() {
		return errorStatus;
	}
	public String getMessage() {
		return errorMessage;
	}
	public String getRootCause() {
		return rootCause;
	}
	public void setStatus(int errorStatus) {
		this.errorStatus = errorStatus;
	}
	public void setMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}
	
	public static  ErrorStructure create(int errorStatus, String errorMessage, String rootCause) {
		ErrorStructure error = new ErrorStructure();
		error.setStatus(errorStatus);
		error.setMessage(errorMessage);
		error.setRootCause(rootCause);
		
		return error;
		
	}

}
