package com.testetecnico.api.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.testetecnico.api.entity.Paciente;


@SpringBootTest
public class PacienteRepositoryTest {


    @Autowired
    private PacienteRepository repository;


    @Test
    void deveSalvarPaciente() {

        Paciente paciente = new Paciente();

        paciente.setNome("Maria Silva");
        paciente.setCpf("12345678900");
        paciente.setTelefone("81999999999");
        paciente.setEmail("maria@email.com");
        paciente.setDataNascimento(
                LocalDate.of(1990, 5, 10)
        );


        Paciente salvo = repository.save(paciente);

        assertThat(salvo.getId()).isNotNull();
        assertThat(salvo.getNome()).isEqualTo("Maria Silva");
    }


    @Test
    void deveBuscarPacientePorId() {

        Paciente paciente = new Paciente();

        paciente.setNome("João");
        paciente.setCpf("11111111111");

        Paciente salvo = repository.save(paciente);

        Paciente encontrado = repository.findById(salvo.getId()).orElse(null);

        assertThat(encontrado).isNotNull();

        assertThat(encontrado.getCpf()).isEqualTo("11111111111");
    }


    @Test
    void deveDeletarPaciente() {

        Paciente paciente = new Paciente();

        paciente.setNome("Ana");
        paciente.setCpf("22222222222");

        Paciente salvo = repository.save(paciente);

        repository.deleteById(salvo.getId());

        assertThat(repository.findById(salvo.getId())).isEmpty();
    }
}
