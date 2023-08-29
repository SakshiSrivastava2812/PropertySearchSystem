package com.amdocs.propertysearch.exception;

public class DeleteException extends Exception {
	public DeleteException(Exception e)
	{
		System.out.println("Record cannot be deleted due to below error");
		System.out.println(e.getMessage());
	}
}
