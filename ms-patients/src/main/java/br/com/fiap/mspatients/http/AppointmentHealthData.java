package br.com.fiap.mspatients.http;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("ms-healthdata")
public interface AppointmentHealthData {
}
