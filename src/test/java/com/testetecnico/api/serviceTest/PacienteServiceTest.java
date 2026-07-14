package com.testetecnico.api.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.testetecnico.api.dto.PacienteResponseDTO;
import com.testetecnico.api.entity.Paciente;
import com.testetecnico.api.mapper.PacienteMapper;
import com.testetecnico.api.repository.PacienteRepository;
import com.testetecnico.api.service.PacienteServiceImpl;

@SpringBootTest
public class PacienteServiceTest {
	
	@Test
	void deveBuscarPacientePorId() {

		PacienteRepository repository = Mockito.mock(PacienteRepository.class);

		PacienteMapper mapper = Mockito.mock(PacienteMapper.class);

		PacienteServiceImpl service = new PacienteServiceImpl(repository, mapper);

		Paciente paciente = new Paciente();

		paciente.setId(1L);
		paciente.setNome("Maria Silva");

		PacienteResponseDTO dto = new PacienteResponseDTO();

		dto.setId(1L);
		dto.setNome("Maria Silva");

		when(repository.findById(1L)).thenReturn(Optional.of(paciente));
		when(mapper.toDTO(paciente)).thenReturn(dto);

		PacienteResponseDTO resultado = service.buscarPorId(1L);

		assertThat(resultado.getNome()).isEqualTo("Maria Silva");

	}
}
