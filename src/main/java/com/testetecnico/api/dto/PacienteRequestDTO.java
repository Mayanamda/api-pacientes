package com.testetecnico.api.dto;

import java.time.LocalDate;

public class PacienteRequestDTO {
	
	private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;
    private String numeroCartaoSus;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNumeroCartaoSus() {
		return numeroCartaoSus;
	}
	public void setNumeroCartaoSus(String numeroCartaoSus) {
		this.numeroCartaoSus = numeroCartaoSus;
	}
}
