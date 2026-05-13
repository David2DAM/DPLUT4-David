package com.example.david.controller;

import com.example.david.model.Miembros;
import com.example.david.service.MiembrosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MiembrosController.class)
public class MiembrosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean  // Spring Boot 3.4+ reemplaza @MockBean
    private MiembrosService service;

    @Test
    void testListarTodosEndpoint() throws Exception {
        Miembros e = new Miembros();
        e.setNombre("Ana");

        when(service.obtenerTodos()).thenReturn(List.of(e));

        mockMvc.perform(get("/api/estudiantes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("Ana"));
    }
}