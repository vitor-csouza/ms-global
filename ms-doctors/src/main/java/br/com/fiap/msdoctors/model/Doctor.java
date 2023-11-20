package br.com.fiap.msdoctors.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    private String phone;

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
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
