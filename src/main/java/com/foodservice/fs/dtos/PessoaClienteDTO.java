package com.foodservice.fs.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.foodservice.fs.domain.PessoaCliente;

public class PessoaClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "O campo NOME é requerido!")
	private String nome;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime nascimento;
	private String naturalidade;
	private String sexo;
	
	@CPF
	@NotEmpty(message = "O campo CPF é requerido!")
	private String cpf;

	public PessoaClienteDTO() {
		super();
	}

	public PessoaClienteDTO(PessoaCliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.nascimento = obj.getNascimento();
		this.naturalidade = obj.getNaturalidade();
		this.sexo = obj.getSexo();
		this.cpf = obj.getCpf();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDateTime nascimento) {
		this.nascimento = nascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaClienteDTO other = (PessoaClienteDTO) obj;
		return Objects.equals(id, other.id);
	}

}
