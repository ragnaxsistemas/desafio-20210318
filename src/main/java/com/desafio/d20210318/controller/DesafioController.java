package com.desafio.d20210318.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.desafio.d20210318.entidad.Feriado;
import com.desafio.d20210318.entidad.Indicador;
import com.desafio.d20210318.exception.DesafioImplException;
import com.desafio.d20210318.servicio.DesafioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("api/v1")
public class DesafioController {
	/**TODO Para usar el commons por el momento es necesario hacer esta Wea**/
	@Autowired
	DesafioService desafioService;
	
	@Value("${swagger.configuracion.documentacion.textoendpoint}")
	private String texto;
	/***************************************************/
	/*************** prueba *** *******************/
	/***************************************************/
	@ApiOperation(value = "prueba con Parametros -> http://localhost:8080/api/v1/2021-03-22",  response = Feriado.class)
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "Error al procesar el negocio", response = ApiError.class),
			@ApiResponse(code = 208, message = "Error al procesar los datos", response = ApiError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = ApiError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Feriado.class)
	})
	@GetMapping(value = "${servicio.app.uri.almacenarFeriado}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Feriado>  almacenarFeriado(@ApiParam(value = "objeto de entrada", required = true, defaultValue = "01-01-2000") 
			@PathVariable String fechaFeriado)  throws DesafioImplException{

		return new ResponseEntity<>(desafioService.almacenarFechaFeriado(fechaFeriado), HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "prueba con Parametros -> http://localhost:8080/api/v1/dolar/03-03-2021", response = Indicador.class)
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "Error al procesar el negocio", response = ApiError.class),
			@ApiResponse(code = 208, message = "Error al procesar los datos", response = ApiError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = ApiError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Indicador.class)
	})
	@GetMapping(value = "${servicio.app.uri.obtenerIndicadores}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Indicador>  obtenerIndicadores(
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "dolar") @PathVariable String codigoindicador,
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "01-01-2000") @PathVariable String fecha)  throws DesafioImplException{

		return new ResponseEntity<>(desafioService.buscarIndicadorxCodigoxFecha(codigoindicador, fecha), HttpStatus.OK);

	}
	
	@ApiOperation(value = "obtenerIndicadoresOptions", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Error al procesar los datos de creacion"),
	})
	@RequestMapping(value = "${servicio.app.uri.obtenerIndicadores}", method = RequestMethod.OPTIONS)
	public ResponseEntity<Indicador>  obtenerIndicadoresOptions()  throws DesafioImplException{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Max-Age", "86400");
		headers.add("Access-Control-Allow-Headers", "*");
	    headers.add("Access-Control-Allow-Origin", "*");
	    headers.add("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, OPTIONS");
		return new ResponseEntity<>(null, headers, HttpStatus.NO_CONTENT);
	}
	
}
