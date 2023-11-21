package br.com.fiap.msappointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAppointmentApplication.class, args);
	}

}

/*
 * 88455 - Vitor André Costa de Souza
 * 88018 - Christian Gaxiola
 * 87153 - Luan de Lima Santos
 */