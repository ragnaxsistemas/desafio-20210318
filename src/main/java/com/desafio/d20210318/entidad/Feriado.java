package com.desafio.d20210318.entidad;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 *  implementation class for : Provincia
 * en la base de Datos representa el detalle de las Provincias por Pais
 */
@Entity
@Table (name="feriado")

public class Feriado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2840616643537410153L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@OrderBy
	@Column(name="id_feriado")
	private Integer idFeriado;
	
	@Column(name="fecha_feriado")
	private String fechaFeriado;
	
	public Feriado() {
		super();
	}
	
	public Feriado(Integer idFeriado) {
		super();
		this.idFeriado = idFeriado;
	}

	public Feriado(String fechaFeriado) {
		super();
		this.fechaFeriado = fechaFeriado;
	}
	
	public Feriado(Integer idFeriado, String fechaFeriado) {
		super();
		this.idFeriado = idFeriado;
		this.fechaFeriado = fechaFeriado;
	}

	public Integer getIdFeriado() {
		return idFeriado;
	}

	public void setIdFeriado(Integer idFeriado) {
		this.idFeriado = idFeriado;
	}

	public String getFechaFeriado() {
		return fechaFeriado;
	}

	public void setFechaFeriado(String fechaFeriado) {
		this.fechaFeriado = fechaFeriado;
	}
	
	

}
