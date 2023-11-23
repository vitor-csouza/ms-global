package br.com.fiap.mshealthdata.controller;

import br.com.fiap.mshealthdata.dto.HealthDataDTO;
import br.com.fiap.mshealthdata.service.HealthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/healthdata")
public class HealthDataController {

    @Autowired
    private HealthDataService service;

    @GetMapping
    public ResponseEntity<List<HealthDataDTO>> getAll() {
        List<HealthDataDTO> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthDataDTO> getById(@PathVariable Long id) {
        HealthDataDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<HealthDataDTO> insert(@RequestBody HealthDataDTO dto) {
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthDataDTO> update(@PathVariable Long id, @RequestBody HealthDataDTO dto) {
        dto = service.update(dto, id);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/consent")
    public void consentHealthData(@PathVariable Long id) {
        service.consentHealthData(id);
    }
}
