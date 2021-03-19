//package com.desafio.d20210318.repository;
//
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.desafio.d20210318.entidad.TipoIndicador;
//
//public 
//interface TipoIndicadorRepository extends JpaRepository<TipoIndicador, Integer> {
//	
//	@Query("select ti from TipoIndicador ti where ti.codigoTipoIndicador = ?1")
//	Page<TipoIndicador> findByCodigoTipoIndicador(String codigoTipoIndicador, Pageable pageable);
//}