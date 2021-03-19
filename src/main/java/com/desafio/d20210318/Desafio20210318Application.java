package com.desafio.d20210318;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableConfigurationProperties(FactoryApiProperties.class)
@EntityScan({"com.desafio.d20210318.entidad"})
@EnableJpaRepositories("com.desafio.d20210318.repository")
public class Desafio20210318Application {

	public static void main(String[] args) {
		SpringApplication.run(Desafio20210318Application.class, args);
	}

}
