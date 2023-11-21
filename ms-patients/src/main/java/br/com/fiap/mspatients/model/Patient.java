package br.com.fiap.mspatients.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_PATIENT")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 100, message = "Nome deve conter entre 3 e 100 caracteres")
    private String name;

    @NotNull
    @Email(message = "E-mail deve ser válido")
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String birth_date;

    @Positive
    private Double weight;

    @Positive
    private Double height;

    public Patient() {
    }

    public Patient(Long id, String name, String email, String phone, String birthDate, Double weight, Double height) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birth_date = birthDate;
        this.weight = weight;
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birth_date;
    }

    public void setBirthDate(String birthDate) {
        this.birth_date = birthDate;
    }
}