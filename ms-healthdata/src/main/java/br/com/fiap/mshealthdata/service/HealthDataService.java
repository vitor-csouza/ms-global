package br.com.fiap.mshealthdata.service;

import br.com.fiap.mshealthdata.dto.HealthDataDTO;
import br.com.fiap.mshealthdata.http.PatientClient;
import br.com.fiap.mshealthdata.model.HealthData;
import br.com.fiap.mshealthdata.repository.HealthDataRepository;
import br.com.fiap.mshealthdata.service.exception.DatabaseException;
import br.com.fiap.mshealthdata.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HealthDataService {

    @Autowired
    private PatientClient patientClient;

    @Autowired
    private HealthDataRepository repository;

    @Transactional(readOnly = true)
    public List<HealthDataDTO> getAll() {
        List<HealthData> list = repository.findAll();
        return list.stream().map(healthData -> new HealthDataDTO(healthData)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public HealthDataDTO getById(Long id) {
        HealthData healthData = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não foi encontrado")
        );
        return new HealthDataDTO(healthData);
    }

    private void copyDtoToEntity(HealthDataDTO dto, HealthData entity) {
        entity.setPatientId(dto.getPatientId());
        entity.setConsumedCalories(dto.getConsumedCalories());
        entity.setHydrationLevel(dto.getHydrationLevel());
        entity.setTemperature(dto.getTemperature());
        entity.setHeartRate(dto.getHeartRate());
        entity.setDoctorId(dto.getDoctorId());
    }

    @Transactional
    public HealthDataDTO insert(HealthDataDTO dto) {
        HealthData healthData = new HealthData();
        copyDtoToEntity(dto, healthData);
        healthData = repository.save(healthData);
        return new HealthDataDTO(healthData);
    }

    @Transactional
    public HealthDataDTO update(HealthDataDTO dto, Long id) {
        try{
            HealthData healthData = repository.getReferenceById(id);
            copyDtoToEntity(dto, healthData);
            healthData = repository.save(healthData);
            return new HealthDataDTO(healthData);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não foi encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não foi encontrado");
        }
        try{
            repository.deleteById(id);
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException("Recurso não foi encontrado");
        }
    }

    @Transactional
    public void consentHealthData(Long id){
        Optional<HealthData> healthDataOptional = repository.findById(id);

        if (!healthDataOptional.isPresent()) {
            throw new ResourceNotFoundException("Dados de saúde não encontrados");
        }

        healthDataOptional.get().setStatusConsentData(true);
        repository.save(healthDataOptional.get());
    }
}