package br.com.fiap.mspatients.dto;

import br.com.fiap.mspatients.model.Patient;

import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class PatientDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;

    private Double weight;

    private Double height;

    public PatientDTO() {
    }

    public PatientDTO(Patient entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.phone = entity.getPhone();
        this.birthDate = entity.getBirthDate();
        this.weight = entity.getWeight();
        this.height = entity.getHeight();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getHeight() {
        return height;
    }
}