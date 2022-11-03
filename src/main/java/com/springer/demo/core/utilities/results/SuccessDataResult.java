package com.springer.demo.core.utilities.results;

public class SuccessDataResult<T> extends DataResult{

	public SuccessDataResult(String message, T data) {
		super(true,message, data);
		// TODO Auto-generated constructor stub
	}
	public SuccessDataResult(T data) {
		super(true,data);
	}
	
	public SuccessDataResult(String message) {
		super(true,message, null);
	}
	

}
