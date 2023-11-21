package br.com.fiap.mshealthdata.dto;

import br.com.fiap.mshealthdata.model.HealthData;

public class HealthDataDTO {

    private Long id;

    private Long appointmentId;

    private Long patientId;

    private int consumedCalories;

    private int waterConsumption;

    private int heartRate;

    private float temperature;

    public HealthDataDTO() {
    }

    public HealthDataDTO(HealthData entity) {
        this.id = entity.getId();
        this.appointmentId = entity.getAppointmentId();
        this.patientId = entity.getPatientId();
        this.consumedCalories = entity.getConsumedCalories();
        this.waterConsumption = entity.getWaterConsumption();
        this.heartRate = entity.getHeartRate();
        this.temperature = entity.getTemperature();
    }

    public Long getId() {
        return id;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public int getConsumedCalories() {
        return consumedCalories;
    }

    public int getWaterConsumption() {
        return waterConsumption;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public float getTemperature() {
        return temperature;
    }
}