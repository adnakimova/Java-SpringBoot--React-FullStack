package com.springer.demo.core.utilities.results;

public class ErrorDataResult<T> extends DataResult{

	public ErrorDataResult(String message, T data) {
		super(false,message, data);
		// TODO Auto-generated constructor stub
	}
	public ErrorDataResult (T data) {
		super(false,data);
	}
	
	public ErrorDataResult(String message) {
		super(false,message, null);
	}
}
