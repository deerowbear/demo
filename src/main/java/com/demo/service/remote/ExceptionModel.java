package com.demo.service.remote;

/**
 * A model that will get converted to JSON by Spring to represent exceptions in the
 * web services.
 *
 * The httpStatusCode is a convenience property but should also be represented in the
 * HTTP status code.
 *
 * The message property is designed to be shown to the end user.
 *
 * The developerMessage property is there to assist the developer consuming the
 * service in figuring out what went wrong.  It shows up in the response, but not
 * designed to be shown to the end user.
 *
 * @author Daniel Wilmes
 */
public class ExceptionModel {
	private int httpStatusCode;
	private String code;
	private String message;
	private String developerMessage;

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
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

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
}
