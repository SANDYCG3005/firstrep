package com.example.demo.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	private LocalDateTime timestamp;
	private String message;
	private HttpStatus http;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttp() {
		return http;
	}
	public void setHttp(HttpStatus http) {
		this.http = http;
	}
	public ErrorResponse() {
		
	}
	@Override
	public String toString() {
		return "ErrorResponse [timestamp=" + timestamp + ", message=" + message + ", http=" + http + "]";
	}
	
	

}
