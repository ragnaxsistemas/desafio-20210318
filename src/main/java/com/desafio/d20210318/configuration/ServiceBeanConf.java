package com.desafio.d20210318.configuration;

import java.nio.charset.Charset;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.desafio.d20210318.servicio.utilidades.CONSTANTES_CONFIGURACION;

@Configuration
public class ServiceBeanConf {
	
	@Bean
    public RestTemplate obtenerRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add (0,new StringHttpMessageConverter(Charset.forName(CONSTANTES_CONFIGURACION.CHARSET_FOR_NAME)));


		SimpleClientHttpRequestFactory clientHttpRequestFactory
		= new SimpleClientHttpRequestFactory();
		/***Connect timeout***/
		clientHttpRequestFactory.setConnectTimeout(CONSTANTES_CONFIGURACION.CLIENTE_CONNECT_TIMEOUT);

		/***Read timeout***/
		clientHttpRequestFactory.setReadTimeout(CONSTANTES_CONFIGURACION.CLIENTE_READ_TIMEOUT);
		restTemplate.setRequestFactory(clientHttpRequestFactory);
		
        return restTemplate;
    }
}
