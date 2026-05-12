package com.example.david.service;

import com.example.david.model.Estudiante;
import com.example.david.repository.EstudianteRepository;
import com.example.david.exception.EstudianteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public List<Estudiante> obtenerTodos() {
        return repository.findAll();
    }

    public Estudiante obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EstudianteNotFoundException(id));
    }

    public Estudiante actualizarEstudiante(Long id, Estudiante datos) {
        Estudiante existente = obtenerPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setEmail(datos.getEmail());
        existente.setEdad(datos.getEdad());
        return repository.save(existente);
    }

    public void eliminarEstudiante(Long id) {
        obtenerPorId(id); // lanza excepción si no existe
        repository.deleteById(id);
    }
}