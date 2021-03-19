package com.desafio.d20210318.entidad;
import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comuna
 * en la base de Datos almacena las Comunas de Chile a las cuales puede pertenecer la empresa o persona
 */
@Entity
@Table (name="indicador")
public class Indicador implements Serializable{
	   
	private static final long serialVersionUID = 3775795074985877007L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_indicador")
	private Integer idIndicador;
	
	@Column(name="codigo_indicador")
	private String codigoIndicador;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="valor")
	private double valor;

	public Indicador() {
		super();
	}

//	public Indicador(String codigoIndicador, Date fecha) {
//		super();
//		this.codigoIndicador = codigoIndicador;
//		this.fecha = fecha;
//	}

	public Indicador(String codigoIndicador, String fecha, double valor) {
		super();
		this.codigoIndicador = codigoIndicador;
		this.fecha = fecha;
		this.valor = valor;
	}
	
	public Indicador(Integer idIndicador, String codigoIndicador, String fecha, double valor) {
	super();
	this.idIndicador = idIndicador;
	this.codigoIndicador = codigoIndicador;
	this.fecha = fecha;
	this.valor = valor;
}

	public Integer getIdIndicador() {
		return idIndicador;
	}

	public void setIdIndicador(Integer idIndicador) {
		this.idIndicador = idIndicador;
	}

	public String getCodigoIndicador() {
		return codigoIndicador;
	}

	public void setCodigoIndicador(String codigoIndicador) {
		this.codigoIndicador = codigoIndicador;
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
	