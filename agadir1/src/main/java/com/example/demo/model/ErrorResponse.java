package com.example.demo.model;


import java.util.Date;
import java.util.List;

public class ErrorResponse {
	private String message;
	private String StatusCode;
	private Date date;
	private List<String> details;
	public ErrorResponse(String message, String statusCode, List<String> details) {
		super();
		this.message = message;
		StatusCode = statusCode;
		this.details = details;
		this.date=new Date();
	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	
	
	
	
}
