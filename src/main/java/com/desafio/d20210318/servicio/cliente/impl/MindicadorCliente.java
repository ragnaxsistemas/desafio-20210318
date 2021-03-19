package com.desafio.d20210318.servicio.cliente.impl;

import com.desafio.d20210318.servicio.cliente.model.ConsultaIndicadorFechaModel;
import com.desafio.d20210318.servicio.cliente.model.ConsultaTipoIndicadorModel;

public interface MindicadorCliente {
	
	public ConsultaTipoIndicadorModel obtenerIndicadores();
	
	public ConsultaIndicadorFechaModel obtenerIndicadoresxCodigoIndicadorxFecha(String codigoIdentificador, String fechaIdentificador);
//	public void obtenerIndicadorXCodigo(String codigoIdentificador);
//	
//	public void obtenerIndicadorXCodigoxFecha
	
	
	
}
