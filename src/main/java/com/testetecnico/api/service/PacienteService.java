package com.testetecnico.api.service;

import java.util.List;

import com.testetecnico.api.dto.PacienteRequestDTO;
import com.testetecnico.api.dto.PacienteResponseDTO;

public interface PacienteService {
	
	PacienteResponseDTO salvar(PacienteRequestDTO dto);

    List<PacienteResponseDTO> listar();

    PacienteResponseDTO buscarPorId(Long id);

    PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto);

    void deletar(Long id);
}
