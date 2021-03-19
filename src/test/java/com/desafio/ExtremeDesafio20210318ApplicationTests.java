package com.desafio;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.d20210318.Desafio20210318Application;
import com.desafio.d20210318.entidad.Feriado;
import com.desafio.d20210318.entidad.Indicador;
import com.desafio.d20210318.exception.DesafioImplException;
import com.desafio.d20210318.repository.FeriadoRepository;
import com.desafio.d20210318.repository.IndicadorRepository;
import com.desafio.d20210318.servicio.cliente.impl.MindicadorCliente;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Desafio20210318Application.class)
class ExtremeDesafio20210318ApplicationTests {
	
	@Autowired
	private MindicadorCliente mindicadorCliente;
	
	@Autowired
	private FeriadoRepository feriadoRepository;
	
	@Autowired
	private IndicadorRepository indicadorRepository;

	@Test
	public void consultaIndicadoresEntities() throws DesafioImplException{
		mindicadorCliente.obtenerIndicadores();
		mindicadorCliente.obtenerIndicadoresxCodigoIndicadorxFecha("dolar", "03-03-2021");
	}

	@Test
	public void crearIndicadoresEntities(){
		crearFeriadoTest();
		crearIndicadorTest();
	}
	
	public void crearFeriadoTest() {

		Feriado feriado = 
				new Feriado("pruebaA");

		feriadoRepository.save(feriado);
	}
	
	public void crearIndicadorTest() {

		Indicador indicador = 
				new Indicador("prueba", "fechaPrueba", 0);

		indicadorRepository.save(indicador);
	}
}
