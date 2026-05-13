package com.example.david.service;

import com.example.david.model.Miembros;
import com.example.david.repository.MiembrosRepository;
import com.example.david.exception.MiembrosNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiembrosService {

    @Autowired
    private MiembrosRepository repository;

    public Miembros guardarEstudiante(Miembros miembros) {
        return repository.save(miembros);
    }

    public List<Miembros> obtenerTodos() {
        return repository.findAll();
    }

    public Miembros obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MiembrosNotFoundException(id));
    }

    public Miembros actualizarEstudiante(Long id, Miembros datos) {
        Miembros existente = obtenerPorId(id);
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