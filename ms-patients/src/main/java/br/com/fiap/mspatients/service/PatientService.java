package br.com.fiap.mspatients.service;

import br.com.fiap.mspatients.dto.PatientDTO;
import br.com.fiap.mspatients.http.Appointment;
import br.com.fiap.mspatients.model.Patient;
import br.com.fiap.mspatients.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {


    @Autowired
    private Appointment appointment;

    @Autowired
    private PatientRepository repository;



    @Transactional(readOnly = true)
    public List<PatientDTO> getAll() {
        List<Patient> list = repository.findAll();
        return list.stream().map(patient -> new PatientDTO(patient)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PatientDTO getById(Long id) {
        Patient patient = repository.findById(id).orElseThrow();
        //get all consultas pelo usuarioId
        PatientDTO paciente = new PatientDTO(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getBirthDate(),
                patient.getWeight(),
                patient.getHeight(),
                appointment.findAppointmentById(patient.getId())
        );
        return paciente;
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
        Patient patient = repository.getReferenceById(id);
        copyDtoToEntity(dto, patient);
        patient = repository.save(patient);
        return new PatientDTO(patient);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}