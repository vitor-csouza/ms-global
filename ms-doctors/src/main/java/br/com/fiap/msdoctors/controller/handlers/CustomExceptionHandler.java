package br.com.fiap.msdoctors.controller.handlers;

import br.com.fiap.msdoctors.dto.ValidationCustomErrorDTO;
import br.com.fiap.msdoctors.service.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity resourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ValidationCustomErrorDTO errorDTO = new ValidationCustomErrorDTO(Instant.now(),
                status.value(), exception.getMessage(), request.getRequestURI());
        return  ResponseEntity.status(status).body(errorDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationCustomErrorDTO> methodArgumentsNotValid(
            MethodArgumentNotValidException exception,
            HttpServletRequest REQUEST){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationCustomErrorDTO errorDTO = new ValidationCustomErrorDTO(
                Instant.now(),
                status.value(),
                "Dados inválidos",
                REQUEST.getRequestURI());
        for(FieldError fieldError: exception.getBindingResult().getFieldErrors()){
            errorDTO.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(errorDTO);
    }}