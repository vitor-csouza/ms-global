package br.com.fiap.mspatients.dto;

import br.com.fiap.mspatients.model.Patient;

import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String birthDate;

    private Double weight;

    private Double height;


    public PatientDTO() {
    }

    public PatientDTO(Long id, String name, String email, String phone, String birthDate, Double weight, Double height) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.weight = weight;
        this.height = height;
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

    public String getBirthDate() {
        return birthDate;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getHeight() {
        return height;
    }

}