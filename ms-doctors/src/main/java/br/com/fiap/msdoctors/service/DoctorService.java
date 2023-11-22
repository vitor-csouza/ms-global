package br.com.fiap.msdoctors.service;

import br.com.fiap.msdoctors.dto.DoctorDTO;
import br.com.fiap.msdoctors.model.Doctor;
import br.com.fiap.msdoctors.model.Specialty;
import br.com.fiap.msdoctors.repository.DoctorRepository;
import br.com.fiap.msdoctors.service.exception.DatabaseException;
import br.com.fiap.msdoctors.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Transactional(readOnly = true)
    public List<DoctorDTO> getAll(){
        List<Doctor> list = repository.findAll();
        return list.stream().map(doctor -> new DoctorDTO(doctor)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DoctorDTO getById(Long id){
        Doctor doctor = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso não foi encontrado")
        );
        return new DoctorDTO(doctor);
    }

    private void copyDtoToEntity(DoctorDTO dto, Doctor entity){
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setCrm(dto.getCrm());
        entity.setPhone(dto.getPhone());
        entity.setSpecialty(Specialty.valueOf(dto.getSpecialty()));
    }

    @Transactional()
    public DoctorDTO insert(DoctorDTO dto){
        Doctor doctor = new Doctor();
        copyDtoToEntity(dto, doctor);
        doctor = repository.save(doctor);
        return new DoctorDTO(doctor);
    }

    @Transactional()
    public DoctorDTO update(DoctorDTO dto, Long id){
        try {
            Doctor doctor = repository.getReferenceById(id);
            copyDtoToEntity(dto, doctor);
            doctor = repository.save(doctor);
            return new DoctorDTO(doctor);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não foi encontrado");
        }
    }

    @Transactional
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não foi encontrado");
        }
        try{
            repository.deleteById(id);
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException("Recurso não foi encontrado");
        }
    }
}
