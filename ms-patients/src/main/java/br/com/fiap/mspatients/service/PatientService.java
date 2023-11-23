package br.com.fiap.mspatients.service;

import br.com.fiap.mspatients.dto.PatientDTO;
import br.com.fiap.mspatients.http.AppointmentPatient;
import br.com.fiap.mspatients.http.HealthDataClient;
import br.com.fiap.mspatients.model.Patient;
import br.com.fiap.mspatients.repository.PatientRepository;
import br.com.fiap.mspatients.service.exception.DatabaseException;
import br.com.fiap.mspatients.service.exception.PatientConsentException;
import br.com.fiap.mspatients.service.exception.ResourceNotFoundException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {


    @Autowired
    private HealthDataClient healthDataClient;

    @Autowired
    private PatientRepository repository;



    @Transactional(readOnly = true)
    public List<PatientDTO> getAll() {
        List<Patient> list = repository.findAll();
        return list.stream().map(patient -> new PatientDTO(patient)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PatientDTO getById(Long id) {
        Patient patient = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não foi encontrado")
        );
        PatientDTO dto = new PatientDTO(patient);
        return dto;
    }



    private void copyDtoToEntity(PatientDTO dto, Patient entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setBirthDate(dto.getBirthDate());
        entity.setWeight(dto.getWeight());
        entity.setHeight(dto.getHeight());
    }

    @Transactional
    public PatientDTO insert(PatientDTO dto) {
        Patient patient = new Patient();
        copyDtoToEntity(dto, patient);
        patient = repository.save(patient);
        return new PatientDTO(patient);
    }

    @Transactional
    public PatientDTO update(PatientDTO dto, Long id) {
        try{
            Patient patient = repository.getReferenceById(id);
            copyDtoToEntity(dto, patient);
            patient = repository.save(patient);
            return new PatientDTO(patient);
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
    public void consentHealthData(Long id) {
        Optional<Patient> patientOptional = repository.findById(id);

        try {
            if (!patientOptional.isPresent()) {
                throw new ResourceNotFoundException("Paciente não encontrado");
            }
            healthDataClient.consentHealthData(id);
        } catch (FeignException e) {
            throw new PatientConsentException("Erro ao conceder permissão para dados de saúde");
        }
    }
}