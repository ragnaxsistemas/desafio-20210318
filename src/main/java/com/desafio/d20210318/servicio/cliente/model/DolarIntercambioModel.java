package com.desafio.d20210318.servicio.cliente.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class DolarIntercambioModel extends TipoIndicadorModel implements Serializable{
	   
	public DolarIntercambioModel() {
		super();
	}
}
