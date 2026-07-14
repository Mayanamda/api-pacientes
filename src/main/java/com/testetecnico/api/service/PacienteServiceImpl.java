package com.testetecnico.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.testetecnico.api.dto.PacienteRequestDTO;
import com.testetecnico.api.dto.PacienteResponseDTO;
import com.testetecnico.api.entity.Paciente;
import com.testetecnico.api.exception.ResourceNotFoundException;
import com.testetecnico.api.mapper.PacienteMapper;
import com.testetecnico.api.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {

	private final PacienteRepository repository;
    private final PacienteMapper mapper;

    public PacienteServiceImpl(
            PacienteRepository repository,
            PacienteMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PacienteResponseDTO salvar(PacienteRequestDTO dto) {

        Paciente paciente = mapper.toEntity(dto);

        paciente = repository.save(paciente);

        return mapper.toDTO(paciente);
    }

    @Override
    public List<PacienteResponseDTO> listar() {

        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PacienteResponseDTO buscarPorId(Long id) {

        Paciente paciente = repository.findById(id).orElseThrow(() -> 
                        new ResourceNotFoundException("Paciente não encontrado com id: " + id));

        return mapper.toDTO(paciente);
    }

    @Override
    public PacienteResponseDTO atualizar(
            Long id,
            PacienteRequestDTO dto) {

        Paciente paciente = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Paciente não encontrado com id: " + id));

        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setTelefone(dto.getTelefone());
        paciente.setEmail(dto.getEmail());
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setNumeroCartaoSus(dto.getNumeroCartaoSus());

        paciente = repository.save(paciente);

        return mapper.toDTO(paciente);
    }

    @Override
    public void deletar(Long id) {

        Paciente paciente = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Paciente não encontrado com id: " + id));

        repository.delete(paciente);
    }
}
