package com.desafio.d20210318.servicio;

import com.desafio.d20210318.entidad.Feriado;
import com.desafio.d20210318.entidad.Indicador;
import com.desafio.d20210318.exception.DesafioImplException;

public interface DesafioService {
	
	public Feriado almacenarFechaFeriado(String sFeriado) throws DesafioImplException;
	
	public Indicador buscarIndicadorxCodigoxFecha(String codigoIndicador, String fechaIndicador) throws DesafioImplException ;
}
