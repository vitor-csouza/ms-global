package br.com.fiap.mshealthdata.service;

import br.com.fiap.mshealthdata.dto.HealthDataDTO;
import br.com.fiap.mshealthdata.model.HealthData;
import br.com.fiap.mshealthdata.repository.HealthDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HealthDataService {

    @Autowired
    private HealthDataRepository repository;

    @Transactional(readOnly = true)
    public List<HealthDataDTO> getAll() {
        List<HealthData> list = repository.findAll();
        return list.stream().map(healthData -> new HealthDataDTO(healthData)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public HealthDataDTO getById(Long id) {
        HealthData healthData = repository.findById(id).orElseThrow();
        return new HealthDataDTO(healthData);
    }

    private void copyDtoToEntity(HealthDataDTO dto, HealthData entity) {
        entity.setPatientId(dto.getPatientId());
        entity.setConsumedCalories(dto.getConsumedCalories());
        entity.setWaterConsumption(dto.getWaterConsumption());
        entity.setTemperature(dto.getTemperature());
        entity.setHeartRate(dto.getHeartRate());
        entity.setAppointmentId(dto.getAppointmentId());
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
        HealthData healthData = repository.getReferenceById(id);
        copyDtoToEntity(dto, healthData);
        healthData = repository.save(healthData);
        return new HealthDataDTO(healthData);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}