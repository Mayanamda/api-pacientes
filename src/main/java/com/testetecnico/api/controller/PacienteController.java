package com.testetecnico.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testetecnico.api.entity.Paciente;
import com.testetecnico.api.repository.PacienteRepository;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {
	
	private final PacienteRepository repository;


    public PacienteController(PacienteRepository repository) {
        this.repository = repository;
    }


    // CADASTRAR PACIENTE
    @PostMapping
    public ResponseEntity<Paciente> criar(
            @RequestBody Paciente paciente) {

        Paciente salvo = repository.save(paciente);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(salvo);
    }


    // LISTAR PACIENTES
    @GetMapping
    public ResponseEntity<List<Paciente>> listar() {

        return ResponseEntity.ok(repository.findAll());
    }


    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // ATUALIZAR PACIENTE
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizar(
            @PathVariable Long id,
            @RequestBody Paciente dados) {


        return repository.findById(id)
                .map(paciente -> {

                    paciente.setNome(dados.getNome());
                    paciente.setCpf(dados.getCpf());
                    paciente.setTelefone(dados.getTelefone());
                    paciente.setEmail(dados.getEmail());
                    paciente.setDataNascimento(dados.getDataNascimento());
                    paciente.setNumeroCartaoSus(dados.getNumeroCartaoSus());
                    Paciente atualizado = repository.save(paciente);
                    return ResponseEntity.ok(atualizado);

                }).orElse(ResponseEntity.notFound().build());
    }


    // DELETAR PACIENTE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {


        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
