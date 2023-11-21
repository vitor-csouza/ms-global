package br.com.fiap.msappointment.controller;

import br.com.fiap.msappointment.dto.AppointmentDTO;
import br.com.fiap.msappointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAll() {
        List<AppointmentDTO> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getById(@PathVariable Long id) {
        AppointmentDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> insert(@RequestBody AppointmentDTO dto) {
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> update(@PathVariable Long id, @RequestBody AppointmentDTO dto) {
        dto = service.update(dto, id);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
