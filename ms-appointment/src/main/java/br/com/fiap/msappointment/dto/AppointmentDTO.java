package br.com.fiap.msappointment.dto;

import br.com.fiap.msappointment.model.Appointment;

import java.time.LocalDateTime;

public class AppointmentDTO {

    private Long id;

    private Long patientId;

    private Long doctorId;

    private Long healthDataId;

    private LocalDateTime dateTime;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Appointment entity) {
        this.id = entity.getId();
        this.patientId = entity.getPatientId();
        this.doctorId = entity.getDoctorId();
        this.healthDataId = entity.getHealthDataId();
        this.dateTime = entity.getDateTime();
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
