package br.com.fiap.mspatients.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("ms-healthdata")
public interface HealthDataClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/healthdata/{id}/consent")
    void consentHealthData(@PathVariable Long id);
}
