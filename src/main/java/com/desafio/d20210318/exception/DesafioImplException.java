package com.desafio.d20210318.exception;

import java.io.Serializable;

public class DesafioImplException extends Exception implements Serializable{

	private String codigoDesafioImplException;
	
	private static final long serialVersionUID = 7672936385153673862L;

	public DesafioImplException(){
		super();
	}

	public DesafioImplException(String message){
		super(message);
	}
	
	public DesafioImplException(String codigoDesafioImplException, String mensajeException){
		super(mensajeException);
		this.codigoDesafioImplException = codigoDesafioImplException;
	}
	
	public DesafioImplException(String message, Throwable cause){
		super(message, cause);
	}

	public String getCodigoDesafioImplException() {
		return codigoDesafioImplException;
	}

	public void setCodigoDesafioImplException(String codigoDesafioImplException) {
		this.codigoDesafioImplException = codigoDesafioImplException;
	}
	
	
}
