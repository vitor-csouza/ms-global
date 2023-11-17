package br.com.fiap.mspatients.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_PATIENT")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=3, max=100, message = "Nome deve conter entre 3 e 100 caractéres")
    private String name;

    @NotNull
    private String
}
