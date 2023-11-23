package br.com.fiap.mspatients.http;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("ms-patients")
public interface AppointmentPatient {

    /*
    @RequestMapping(method = RequestMethod.GET, value = "/patients/{id)/appointment")
    List<AppointmentDTO> findAppointmentById(@PathVariable(name="id") Long id);
     */

}
