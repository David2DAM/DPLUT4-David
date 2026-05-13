package com.example.david.exception;

public class MiembrosNotFoundException extends RuntimeException {

    public MiembrosNotFoundException(Long id) {
        super("No se encontró el estudiante con id: " + id);
    }
}