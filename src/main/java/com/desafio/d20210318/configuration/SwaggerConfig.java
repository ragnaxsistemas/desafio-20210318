package com.desafio.d20210318.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;

/**
 * Created by juliocornejo
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	/*** http://localhost:8085/swagger-ui.html# *****/
	private static final String PACKAGE_CONTROLLER = "com.desafio.d20210318.controller";
	
	@Value("${swagger.configuracion.apiinfo.empresa}")
	private String contactoEmpresa;
	
	@Value("${swagger.configuracion.apiinfo.mail}")
	private String contactoMail;
	
	@Value("${swagger.configuracion.apiinfo.titulo}")
	private String apiinfoTitulo;
	
	@Value("${swagger.configuracion.apiinfo.descripcion}")
	private String apiinfoDescripcion;
	
	@Value("${swagger.configuracion.apiinfo.version}")
	private String apiinfoVersion;
	
	@Value("${swagger.configuracion.apiinfo.termsOfServiceUrl}")
	private String apiinfoTermsOfServiceUrl;
	
	@Value("${swagger.configuracion.apiinfo.license}")
	private String apiinfoLicense;
	
	@Value("${swagger.configuracion.apiinfo.licenseUrl}")
	private String apiinfoLicenseUrl;
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.POST, new ArrayList<>())
                .globalResponseMessage(RequestMethod.GET, new ArrayList<>())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_CONTROLLER))
                .paths(PathSelectors.any())
                .build();
    }
	
	private ApiInfo apiInfo() {
        Contact contacto = new Contact(contactoEmpresa, apiinfoLicenseUrl,contactoMail);
        
        return new ApiInfo(apiinfoTitulo, apiinfoDescripcion,
                apiinfoVersion, apiinfoTermsOfServiceUrl, contacto, apiinfoLicense,
                apiinfoLicenseUrl, new ArrayList<VendorExtension>());
    }

}