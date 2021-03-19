//package com.desafio.d20210318.entidad;
//
//import java.io.Serializable;
//import java.lang.String;
//
//import javax.persistence.*;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
///**
// * Entity implementation class for Entity: Comuna
// * en la base de Datos almacena las Comunas de Chile a las cuales puede pertenecer la empresa o persona
// */
//@Entity
//@Table (name="tipo_indicador")
//public class TipoIndicador implements Serializable{
//	   
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -8493849801913595675L;
//
//	@Id
//	@OrderBy
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id_tipo_indicador")
//	private Integer idTipoIndicador;
//	
//	@Column(name="codigo_tipo_indicador")
//	private String codigoTipoIndicador;
//	
//	@Column(name="nombre_tipo_indicador")
//	private String nombreTipoIndicador;
//	
//	@Column(name="fecha")
//	private String fecha;
//	
//	public TipoIndicador() {
//		super();
//	}
//	
//	public TipoIndicador(Integer idTipoIndicador) {
//		super();
//		this.idTipoIndicador = idTipoIndicador;
//	}
//
//	public TipoIndicador(String codigoTipoIndicador, String nombreTipoIndicador, String fecha) {
//		super();
//		this.codigoTipoIndicador = codigoTipoIndicador;
//		this.nombreTipoIndicador = nombreTipoIndicador;
//		this.fecha = fecha;
//	}
//
//
//
//	public Integer getIdTipoIndicador() {
//		return idTipoIndicador;
//	}
//
//	public void setIdTipoIndicador(Integer idTipoIndicador) {
//		this.idTipoIndicador = idTipoIndicador;
//	}
//
//	public String getCodigoTipoIndicador() {
//		return codigoTipoIndicador;
//	}
//
//	public void setCodigoTipoIndicador(String codigoTipoIndicador) {
//		this.codigoTipoIndicador = codigoTipoIndicador;
//	}
//
//	public String getNombreTipoIndicador() {
//		return nombreTipoIndicador;
//	}
//
//	public void setNombreTipoIndicador(String nombreTipoIndicador) {
//		this.nombreTipoIndicador = nombreTipoIndicador;
//	}
//	
//}
