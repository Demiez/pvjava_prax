package com.petrenko.lab0302.security;

public class BadDecryptException extends Exception {

	private static final long serialVersionUID = -7988512254768705427L;
	
	public BadDecryptException(String str) {
		super(str);
	}

}