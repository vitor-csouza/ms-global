package br.com.fiap.msdoctors.dto;

import br.com.fiap.msdoctors.model.Doctor;

public class DoctorDTO {

    private Long id;
    private String name;
    private String email;
    private String crm;
    private String phone;
    private String specialty;

    public DoctorDTO() {
    }

    public DoctorDTO(Doctor entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.crm = entity.getCrm();
        this.phone = entity.getPhone();
        this.specialty = entity.getSpecialty().name();
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCrm() {
        return crm;
    }

    public String getPhone() {
        return phone;
    }

    public String getSpecialty() {
        return specialty;
    }
}
