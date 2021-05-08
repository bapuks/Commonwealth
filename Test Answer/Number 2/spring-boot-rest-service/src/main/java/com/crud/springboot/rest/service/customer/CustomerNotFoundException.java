package com.crud.springboot.rest.service.customer;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(String exception) {
		super(exception);
	}
}
