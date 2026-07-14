package com.testetecnico.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.testetecnico.api.entity.Paciente;
import com.testetecnico.api.repository.PacienteRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PacienteController.class)
public class PacienteControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	@MockitoBean
    private PacienteRepository repository;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarPaciente() throws Exception {


        Paciente paciente = new Paciente();

        paciente.setId(1L);
        paciente.setNome("Maria Silva");
        paciente.setCpf("12345678900");
        paciente.setTelefone("81999999999");
        paciente.setEmail("maria@email.com");
        paciente.setDataNascimento(
                LocalDate.of(1990,5,10)
        );


        when(repository.save(any(Paciente.class)))
                .thenReturn(paciente);



        mockMvc.perform(post("/api/v1/pacientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paciente)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome")
                        .value("Maria Silva"))
                .andExpect(jsonPath("$.cpf")
                        .value("12345678900"));
    }

    @Test
    void deveListarPacientes() throws Exception {


        Paciente paciente = new Paciente();

        paciente.setId(1L);
        paciente.setNome("Maria Silva");


        when(repository.findAll())
                .thenReturn(List.of(paciente));


        mockMvc.perform(get("/api/v1/pacientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome")
                        .value("Maria Silva"));

    }

    @Test
    void deveBuscarPacientePorId() throws Exception {


        Paciente paciente = new Paciente();

        paciente.setId(1L);
        paciente.setNome("Maria Silva");


        when(repository.findById(1L))
                .thenReturn(Optional.of(paciente));


        mockMvc.perform(get("/api/v1/pacientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome")
                        .value("Maria Silva"));

    }

    @Test
    void deveRetornar404QuandoPacienteNaoExistir()
            throws Exception {


        when(repository.findById(1L))
                .thenReturn(Optional.empty());


        mockMvc.perform(get("/api/v1/pacientes/1"))
                .andExpect(status().isNotFound());

    }

    @Test
    void deveDeletarPaciente() throws Exception {


        when(repository.existsById(1L))
                .thenReturn(true);


        mockMvc.perform(delete("/api/v1/pacientes/1"))
                .andExpect(status().isNoContent());

    }
}
