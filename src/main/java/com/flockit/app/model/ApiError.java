package com.flockit.app.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

	private Integer code;
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime date;
	private String message;
	private String requestDescription;

	private ApiError() {
		date = LocalDateTime.now();
	}

	public ApiError(HttpStatus status) {
		this();
		this.code = status.value();
		this.status = status;
	}

	public ApiError(HttpStatus status, String message, String requestDesc) {
		this();
		this.code = status.value();
		this.status = status;
		this.message = message;
		this.requestDescription = requestDesc;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequestDescription() {
		return requestDescription;
	}

	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}
}
