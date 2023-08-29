package com.amdocs.propertysearch.exception;

public class UpdateException extends Exception {
	public UpdateException(Exception e)
	{
		System.out.println("Record cannot be updated due to below error");
		System.out.println(e.getMessage());
	}

}
