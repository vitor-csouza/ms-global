package br.com.fiap.msappointment.service;

import br.com.fiap.msappointment.dto.AppointmentDTO;
import br.com.fiap.msappointment.model.Appointment;
import br.com.fiap.msappointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Transactional(readOnly = true)
    public List<AppointmentDTO> getAll() {
        List<Appointment> list = repository.findAll();
        return list.stream().map(appointment -> new AppointmentDTO(appointment)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AppointmentDTO getById(Long id) {
        Appointment appointment = repository.findById(id).orElseThrow();
        return new AppointmentDTO(appointment);
    }

    private void copyDtoToEntity(AppointmentDTO dto, Appointment entity) {
        entity.setPatientId(dto.getPatientId());
        entity.setDoctorId(dto.getDoctorId());
        entity.setHealthDataId(dto.getHealthDataId());
        entity.setDateTime(dto.getDateTime());
    }

    @Transactional
    public AppointmentDTO insert(AppointmentDTO dto) {
        Appointment appointment = new Appointment();
        copyDtoToEntity(dto, appointment);
        appointment = repository.save(appointment);
        return new AppointmentDTO(appointment);
    }

    @Transactional
    public AppointmentDTO update(AppointmentDTO dto, Long id) {
        Appointment appointment = repository.getReferenceById(id);
        copyDtoToEntity(dto, appointment);
        appointment = repository.save(appointment);
        return new AppointmentDTO(appointment);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
