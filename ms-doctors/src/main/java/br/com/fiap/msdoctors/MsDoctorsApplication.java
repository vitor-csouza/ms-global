package br.com.fiap.msdoctors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsDoctorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDoctorsApplication.class, args);
	}

}


/*
 * 88455 - Vitor André Costa de Souza
 * 88018 - Christian Gaxiola
 * 87153 - Luan de Lima Santos
 */