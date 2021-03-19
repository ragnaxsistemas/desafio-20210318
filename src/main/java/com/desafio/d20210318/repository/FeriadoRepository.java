package com.desafio.d20210318.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.desafio.d20210318.entidad.Feriado;


public 
interface FeriadoRepository extends JpaRepository<Feriado, Integer> {
	
	@Query("select f from Feriado f where f.fechaFeriado = ?1")
	Page<Feriado> findByFechaFeriado(String fechaFeriado, Pageable pageable);
	
	
}
