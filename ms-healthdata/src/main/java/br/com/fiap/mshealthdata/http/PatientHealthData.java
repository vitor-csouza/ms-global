package br.com.fiap.mshealthdata.http;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("ms-patients")
public interface PatientHealthData {
}
