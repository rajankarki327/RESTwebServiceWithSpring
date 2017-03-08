package spring.rest.controller;

public enum ErrorCode {
	
	ERROR_VALIDATION("4001", "VAlidation Failed"), AUTHOR_NOT_FOUND("4002","Author Validation");
	
	String code;
	String message;
	
	ErrorCode(String code, String message){
		this.code=code;
		this.message=message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
