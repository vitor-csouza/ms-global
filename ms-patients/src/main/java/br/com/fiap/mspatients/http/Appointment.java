package br.com.fiap.mspatients.http;

import br.com.fiap.mspatients.dto.AppointmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("ms-patients")
public interface Appointment {

    @RequestMapping(method = RequestMethod.GET, value = "/patients/{id)/appointment")
    List<AppointmentDTO> findAppointmentById(@PathVariable(name="id") Long id);

}
