package com.ibm.dst.frame.ssm.common.base.exception;

public class BaseException extends Exception {

	private static final long serialVersionUID = -6629941095634875488L;

    public BaseException() {
    	super();
    }

    public BaseException(String message, Throwable cause) {
    	super(message, cause);
    }

    public BaseException(String message) {
    	super(message);
    }

    public BaseException(Throwable cause) {
    	super(cause);
    }
    
}
