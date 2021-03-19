package com.desafio.d20210318.servicio.cliente.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class TipoIndicadorModel implements Serializable{
	   
	private static final long serialVersionUID = -8493849801913595675L;

	private String codigo;
	private String nombre;
	private String unidad_medida;
	private Date fecha;
	private double valor;
	

	
	public TipoIndicadorModel() {
		super();
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUnidad_medida() {
		return unidad_medida;
	}


	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
