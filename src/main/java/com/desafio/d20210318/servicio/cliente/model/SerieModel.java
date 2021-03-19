package com.desafio.d20210318.servicio.cliente.model;

import java.io.Serializable;
import java.util.Date;

public class SerieModel implements Serializable{
	   
	private static final long serialVersionUID = -8493849801913595675L;

	private String fecha;
	private double valor;
	
	public SerieModel() {
		super();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
