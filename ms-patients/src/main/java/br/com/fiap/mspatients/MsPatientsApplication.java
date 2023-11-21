package br.com.fiap.mspatients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MsPatientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPatientsApplication.class, args);
	}

}


/*
 * 88455 - Vitor André Costa de Souza
 * 88018 - Christian Gaxiola
 * 87153 - Luan de Lima Santos
 */

