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
