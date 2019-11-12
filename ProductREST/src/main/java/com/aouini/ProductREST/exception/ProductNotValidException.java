package com.aouini.ProductREST.exception;

public class ProductNotValidException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ProductNotValidException(String msg)
	{
		super(msg);
	}

}
