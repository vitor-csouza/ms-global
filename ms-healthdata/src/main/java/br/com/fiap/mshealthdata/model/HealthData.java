package br.com.fiap.mshealthdata.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name="healthdata")
public class HealthData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long doctorId;

    @NotNull
    private Long patientId;

    @Positive
    private double consumedCalories;

    @Positive
    private double hydrationLevel;

    @Positive
    private double heartRate;

    @Positive
    private double temperature;

    private boolean statusConsentData;

    public HealthData(){

    }

    public HealthData(Long id, Long doctorId, Long patientId, double consumedCalories, double hydrationLevel, double heartRate, double temperature, boolean statusConsentData) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.consumedCalories = consumedCalories;
        this.hydrationLevel = hydrationLevel;
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.statusConsentData = statusConsentData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public double getConsumedCalories() {
        return consumedCalories;
    }

    public void setConsumedCalories(double consumedCalories) {
        this.consumedCalories = consumedCalories;
    }

    public double getHydrationLevel() {
        return hydrationLevel;
    }

    public void setHydrationLevel(double hydrationLevel) {
        this.hydrationLevel = hydrationLevel;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isStatusConsentData() {
        return statusConsentData;
    }

    public void setStatusConsentData(boolean statusConsentData) {
        this.statusConsentData = statusConsentData;
    }
}
