package com.desafio.d20210318.exception;

import java.io.Serializable;

public class LogicaImplException extends Exception implements Serializable{

	private String codigoLogicaImplException;
	
	private static final long serialVersionUID = 7672936385153673862L;

	public LogicaImplException(){
		super();
	}

	public LogicaImplException(String message){
		super(message);
	}
	
	public LogicaImplException(String codigoLogicaImplException, String message) {
		super(message);
		this.codigoLogicaImplException = codigoLogicaImplException;
	}

	public LogicaImplException(String message, Throwable cause){
		super(message, cause);
	}
	
	
	public LogicaImplException(Throwable cause){
		super(cause);
	}

	public String getCodigoLogicaImplException() {
		return codigoLogicaImplException;
	}

	public void setCodigoLogicaImplException(String codigoLogicaImplException) {
		this.codigoLogicaImplException = codigoLogicaImplException;
	}
	
}
