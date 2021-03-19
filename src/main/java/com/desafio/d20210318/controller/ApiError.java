package com.desafio.d20210318.controller;

import java.io.Serializable;

public class ApiError implements Serializable {
	
	private static final long serialVersionUID = -1360021176413807221L;
	
	private int codigo;
	private String mensaje;

	public ApiError() {
	}
	
	public ApiError(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	
	public ApiError(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
