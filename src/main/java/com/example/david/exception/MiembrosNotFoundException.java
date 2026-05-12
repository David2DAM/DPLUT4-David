package com.example.david.exception;

public class EstudianteNotFoundException extends RuntimeException {

    public EstudianteNotFoundException(Long id) {
        super("No se encontró el estudiante con id: " + id);
    }
}