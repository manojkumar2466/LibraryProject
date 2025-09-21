package com.library.DigitalLibrary.Exception;

public class InvalidPassword extends RuntimeException{
	
	private String message;
	
	public InvalidPassword(String message) {
		
		super(message);
		this.message=message;
	}

}
