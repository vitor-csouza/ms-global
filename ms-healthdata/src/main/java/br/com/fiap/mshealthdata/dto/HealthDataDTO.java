package br.com.fiap.mshealthdata.dto;

import br.com.fiap.mshealthdata.model.HealthData;

public class HealthDataDTO {

    private Long id;

    private Long doctorId;

    private Long patientId;

    private double consumedCalories;

    private double hydrationLevel;

    private double heartRate;

    private double temperature;

    private boolean statusConsentData;

    public HealthDataDTO() {
    }

    public HealthDataDTO(HealthData entity) {
        this.id = entity.getId();
        this.patientId = entity.getPatientId();
        this.consumedCalories = entity.getConsumedCalories();
        this.hydrationLevel = entity.getHydrationLevel();
        this.heartRate = entity.getHeartRate();
        this.temperature = entity.getTemperature();
        this.statusConsentData = entity.isStatusConsentData();
    }

    public Long getId() {
        return id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public double getConsumedCalories() {
        return consumedCalories;
    }

    public double getHydrationLevel() { return hydrationLevel; }

    public double getHeartRate() {
        return heartRate;
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean isStatusConsentData() {
        return statusConsentData;
    }
}