package com.david.service;

import com.example.david.model.Miembros;
import com.example.david.repository.MiembrosRepository;

import com.example.david.service.MiembrosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MiembrosServiceTest {

    @Mock
    private MiembrosRepository repository;

    @InjectMocks
    private MiembrosService service;

    private Miembros miembros;

    @BeforeEach
    void setUp() {
        miembros = new Miembros();
        miembros.setId(1L);
        miembros.setNombre("Juan Perez");
        miembros.setEmail("juan@ejemplo.com");
        miembros.setEdad(20);
    }

    @Test
    void testGuardarEstudiante() {
        when(repository.save(any(Miembros.class)))
                .thenReturn(miembros);
        Miembros guardado = service.guardarEstudiante(miembros);
        assertNotNull(guardado);
        assertEquals("Juan Perez", guardado.getNombre());
        verify(repository, times(1))
                .save(any(Miembros.class));
    }

    @Test
    void testObtenerTodos() {
        when(repository.findAll())
                .thenReturn(List.of(miembros));
        List<Miembros> lista = service.obtenerTodos();
        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        verify(repository, times(1)).findAll();
    }
}