package br.com.fiap.mspatients.dto;

import java.time.LocalDateTime;

public class AppointmentDTO {

    private Long id;

    private Long patientId;

    private Long doctorId;

    private Long healthDataId;

    private LocalDateTime dateTime;

    public AppointmentDTO(Long id, Long patientId, Long doctorId, Long healthDataId, LocalDateTime dateTime) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.healthDataId = healthDataId;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public Long getHealthDataId() {
        return healthDataId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
