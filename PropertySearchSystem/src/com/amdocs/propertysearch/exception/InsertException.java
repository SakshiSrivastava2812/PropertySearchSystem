package com.amdocs.propertysearch.exception;

public class InsertException extends Exception {
	public InsertException(Exception e)
	{
		System.out.println("Record cannot be inserted due to below error");
		System.out.println(e.getMessage());
	}

}
