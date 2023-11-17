package br.com.fiap.msdoctors.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tb_doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=3, max=100, message="Nome deve conter entre 5 a 100 caracteres")
    private String name;

    @NotNull
    @Email(message="Forneça um email válido")
    private String email;

    @NotNull
    private  String crm;

    @NotNull
    private String telefone;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    public Doctor() {
    }

    public Doctor(Long id, String name, String email, String crm, String telefone, Specialty specialty) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.crm = crm;
        this.telefone = telefone;
        this.specialty = specialty;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
