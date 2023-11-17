package br.com.fiap.msdoctors.dto;

import br.com.fiap.msdoctors.model.Doctor;

public class DoctorDTO {

    private final Long id;
    private final String name;
    private final String email;
    private final String crm;
    private final String telefone;
    private final String specialty;

    public DoctorDTO(Doctor entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.crm = entity.getCrm();
        this.telefone = entity.getTelefone();
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

    public String getTelefone() {
        return telefone;
    }

    public String getSpecialty() {
        return specialty;
    }
}
