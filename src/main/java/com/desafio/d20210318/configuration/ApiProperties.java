package com.desafio.d20210318.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
/****Properties que pueden cambiar el valor ****/
public class ApiProperties {
	
	@Value("${info.app.name}")
	private String nombreAplicacion;
	
	@Value("${rest.client.saas.miindicador.endpoint}")
	private String clientSaas_miindicador;
	
	@Value("${rest.client.saas.miindicador.service.obtenerxcodigoxfecha}")
	private String clientSaas_miindicador_obtenerxcodigoxfecha;

	public String getNombreAplicacion() {
		return nombreAplicacion;
	}

	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}

	public String getClientSaas_miindicador() {
		return clientSaas_miindicador;
	}

	public void setClientSaas_miindicador(String clientSaas_miindicador) {
		this.clientSaas_miindicador = clientSaas_miindicador;
	}

	public String getClientSaas_miindicador_obtenerxcodigoxfecha() {
		return clientSaas_miindicador_obtenerxcodigoxfecha;
	}

	public void setClientSaas_miindicador_obtenerxcodigoxfecha(String clientSaas_miindicador_obtenerxcodigoxfecha) {
		this.clientSaas_miindicador_obtenerxcodigoxfecha = clientSaas_miindicador_obtenerxcodigoxfecha;
	}
	
	
}