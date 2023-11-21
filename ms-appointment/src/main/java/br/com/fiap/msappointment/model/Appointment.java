package br.com.fiap.msappointment.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotNull
    private Long healthDataId;

    @NotNull
    private LocalDateTime dateTime;

    public Appointment(){

    }

    public Appointment(Long id, Long patientId, Long doctorId, Long healthDataId, LocalDateTime dateTime) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.healthDataId = healthDataId;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getHealthDataId() {
        return healthDataId;
    }

    public void setHealthDataId(Long healthDataId) {
        this.healthDataId = healthDataId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
