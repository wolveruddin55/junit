package com.junit.demo.utility;

import org.springframework.stereotype.Component;

@Component
public class Result {

	private Integer statusCode;
	private String message;
	private Object data;

	public Result() {
		super();
	}

	public Result(Integer statusCode, String message, Object data) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
