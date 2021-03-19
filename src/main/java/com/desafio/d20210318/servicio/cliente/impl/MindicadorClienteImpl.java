package com.desafio.d20210318.servicio.cliente.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.d20210318.configuration.ApiProperties;
import com.desafio.d20210318.servicio.cliente.model.ConsultaIndicadorFechaModel;
import com.desafio.d20210318.servicio.cliente.model.ConsultaTipoIndicadorModel;
import com.desafio.d20210318.servicio.utilidades.CONSTANTES_CONFIGURACION;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service 
public class MindicadorClienteImpl implements MindicadorCliente
{	
	@Autowired
	private ApiProperties apiProperties;
	/*****Segun se necesite se van creando llamadas al repositorio para devolver entities.*****/
	private static final Logger LOGGER = LoggerFactory.getLogger(MindicadorClienteImpl.class);

	@Autowired
	private RestTemplate restTemplate;
	
	Gson gson = new GsonBuilder()
			.setDateFormat(CONSTANTES_CONFIGURACION.GSON_TIMESTAMP) // "yyyy-MM-dd'T'HH:mm:ssZ"
			.setPrettyPrinting().create();
	
	public ConsultaTipoIndicadorModel obtenerIndicadores()
	{
		String path = apiProperties.getClientSaas_miindicador();
		
		LOGGER.info("path de obtenerIndicadores : {}", apiProperties.getClientSaas_miindicador());
		
		ResponseEntity<ConsultaTipoIndicadorModel> retorno
		  = restTemplate.getForEntity(path, ConsultaTipoIndicadorModel.class);
		
		return retorno.getBody();

	}
	
	public ConsultaIndicadorFechaModel obtenerIndicadoresxCodigoIndicadorxFecha(String codigoIdentificador, String fechaIdentificador)
	{
		
		String path = apiProperties.getClientSaas_miindicador_obtenerxcodigoxfecha();
		
		path = path.replace("{codigoIndicador}",codigoIdentificador);
		path = path.replace("{fecha}", fechaIdentificador);
		
		LOGGER.info("path de obtenerIndicadoresxCodigoIndicadorxFecha : {}", path);
		
		ResponseEntity<String> retorno
		  = restTemplate.getForEntity(path, String.class);
		
		return gson.fromJson(retorno.getBody(), ConsultaIndicadorFechaModel.class);
		

	}
	
}
