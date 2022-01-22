package com.complexivo.hoteles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
/*@EntityScan(basePackages ={"model"})
@EnableJpaRepositories(basePackages ={"dao"})
@ComponentScan(basePackages ={"controller","dao","service","repository"})*/
public class HotelesApplication {

	//SIN EUREKA
	//http://localhost:9897/hoteles
	//CON EUREKA
	//http://servicio-hoteles/hoteles

	public static void main(String[] args) {
		SpringApplication.run(HotelesApplication.class, args);
	}

}
