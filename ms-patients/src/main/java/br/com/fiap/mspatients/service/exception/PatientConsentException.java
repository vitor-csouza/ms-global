package br.com.fiap.mspatients.service.exception;

public class PatientConsentException extends RuntimeException {
    public PatientConsentException(String message) {
        super(message);
    }
}