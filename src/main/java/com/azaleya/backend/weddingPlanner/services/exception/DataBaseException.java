package com.azaleya.backend.weddingPlanner.services.exception;



public class DataBaseException extends RuntimeException{
	private static final Long serialVersionUID = 1L;
	
	public DataBaseException(String msg) {
		super(msg);
	}
}
