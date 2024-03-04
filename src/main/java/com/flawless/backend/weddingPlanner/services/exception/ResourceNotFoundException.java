package com.flawless.backend.weddingPlanner.services.exception;



public class ResourceNotFoundException extends RuntimeException{
	private static final Long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
