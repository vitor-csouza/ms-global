package br.com.fiap.mshealthdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class MsHealthdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsHealthdataApplication.class, args);
	}

}
/*
 * 88455 - Vitor André Costa de Souza
 * 88018 - Christian Gaxiola
 * 87153 - Luan de Lima Santos
 */