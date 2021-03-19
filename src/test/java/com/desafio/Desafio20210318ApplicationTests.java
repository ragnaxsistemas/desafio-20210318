package com.desafio;

import static org.mockito.Mockito.doNothing;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.desafio.d20210318.Desafio20210318Application;
import com.desafio.d20210318.entidad.Feriado;
import com.desafio.d20210318.entidad.Indicador;
import com.desafio.d20210318.exception.DesafioImplException;
import com.desafio.d20210318.repository.FeriadoRepository;
import com.desafio.d20210318.repository.IndicadorRepository;
import com.desafio.d20210318.servicio.DesafioServiceImpl;
import com.desafio.d20210318.servicio.cliente.impl.MindicadorCliente;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Desafio20210318Application.class)
class Desafio20210318ApplicationTests {
	
	@InjectMocks
	private DesafioServiceImpl desafioServiceImpl = new DesafioServiceImpl();

	@Mock
	private MindicadorCliente mindicadorCliente;
	
	@Mock
	private FeriadoRepository feriadoRepository;
	
	@Mock
	private IndicadorRepository indicadorRepository;
	
	@Spy
	Feriado feriadoOK = new Feriado(0, "OK");

	@Spy
	Indicador IndicadorOK = new Indicador(0,"OK", "OK", 0);
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void almacenarFechaFeriado_throwsFechaInvalida() throws DesafioImplException {
		
		Assertions.assertThrows(DesafioImplException.class, () -> {
			desafioServiceImpl.almacenarFechaFeriado("03-TT-2021");
		  });
		
	}
	
	@Test
	void almacenarFechaFeriado_throwsExisteFeriado() throws DesafioImplException {
		
		Page<Feriado> pageIdFeriado = Mockito.mock(Page.class);
		
		Mockito.when(this.feriadoRepository.findByFechaFeriado(Matchers.anyString(), org.mockito.Matchers.isA(Pageable.class))).thenReturn(pageIdFeriado);
		
		Assertions.assertThrows(DesafioImplException.class, () -> {
			desafioServiceImpl.almacenarFechaFeriado("03-03-2021");
		  });
		
	}
	
	@Test
	void almacenarFechaFeriado_OK() throws DesafioImplException {

		Mockito.when(this.feriadoRepository.findByFechaFeriado(Matchers.anyString(), org.mockito.Matchers.isA(Pageable.class))).thenReturn(null);
		
		Mockito.when(this.feriadoRepository.save(Matchers.any())).thenReturn(feriadoOK);
		
		desafioServiceImpl.almacenarFechaFeriado("03-03-2021");
	}

}
