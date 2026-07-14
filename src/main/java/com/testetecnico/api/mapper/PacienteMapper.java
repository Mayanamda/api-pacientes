package com.testetecnico.api.mapper;

import org.springframework.stereotype.Component;

import com.testetecnico.api.dto.PacienteRequestDTO;
import com.testetecnico.api.dto.PacienteResponseDTO;
import com.testetecnico.api.entity.Paciente;

@Component
public class PacienteMapper {
	
	public Paciente toEntity(PacienteRequestDTO dto) {
		
		Paciente paciente = new Paciente();

        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setTelefone(dto.getTelefone());
        paciente.setEmail(dto.getEmail());
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setNumeroCartaoSus(dto.getNumeroCartaoSus());

        return paciente;
    }

    public PacienteResponseDTO toDTO(Paciente paciente) {
    	
    	PacienteResponseDTO dto = new PacienteResponseDTO();

        dto.setId(paciente.getId());
        dto.setNome(paciente.getNome());
        dto.setCpf(paciente.getCpf());
        dto.setTelefone(paciente.getTelefone());
        dto.setEmail(paciente.getEmail());
        dto.setDataNascimento(paciente.getDataNascimento());
        dto.setNumeroCartaoSus(paciente.getNumeroCartaoSus());

        return dto;
    }

}
