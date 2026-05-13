package com.example.david.controller;

import com.example.david.model.Miembros;
import com.example.david.service.MiembrosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miembros")
public class MiembrosController {

    @Autowired
    private MiembrosService service;

    @PostMapping
    public ResponseEntity<Miembros> crear(@Valid @RequestBody Miembros miembros) {
        return ResponseEntity.ok(service.guardarEstudiante(miembros));
    }

    @GetMapping
    public ResponseEntity<List<Miembros>> listarTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Miembros> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Miembros> actualizar(@PathVariable Long id,
                                               @Valid @RequestBody Miembros datos) {
        return ResponseEntity.ok(service.actualizarEstudiante(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}