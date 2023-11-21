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
    private Long appointmentId;

    @NotNull
    private Long patientId;

    @Positive
    private int consumedCalories;

    @Positive
    private int waterConsumption;

    @Positive
    private int heartRate;

    @Positive
    private float temperature;

    public HealthData(){

    }

    public HealthData(Long id, Long appointmentId, Long patientId, int consumedCalories, int waterConsumption, int heartRate, float temperature) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.consumedCalories = consumedCalories;
        this.waterConsumption = waterConsumption;
        this.heartRate = heartRate;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public int getConsumedCalories() {
        return consumedCalories;
    }

    public void setConsumedCalories(int consumedCalories) {
        this.consumedCalories = consumedCalories;
    }

    public int getWaterConsumption() {
        return waterConsumption;
    }

    public void setWaterConsumption(int waterConsumption) {
        this.waterConsumption = waterConsumption;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
