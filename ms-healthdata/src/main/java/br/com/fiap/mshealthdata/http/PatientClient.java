package br.com.fiap.mshealthdata.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("ms-patients")
public interface PatientClient {

    @RequestMapping(method = RequestMethod.PUT, value = "patients/{id}/consent")
    void consentHealthData(@PathVariable Long id);
}
