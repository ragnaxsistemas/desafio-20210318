package com.desafio.d20210318.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.d20210318.entidad.Indicador;

public 
	interface IndicadorRepository extends JpaRepository<Indicador, Integer> {
	
	Indicador findByCodigoIndicadorAndFecha(String codigoIndicador, String fecha);
	
	
	
}
