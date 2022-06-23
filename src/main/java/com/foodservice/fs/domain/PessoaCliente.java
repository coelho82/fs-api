package com.foodservice.fs.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PessoaCliente extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Venda> list = new ArrayList<>();	

	public PessoaCliente() {
		super();
	}

	public PessoaCliente(Integer id, String nome, LocalDateTime nascimento, String naturalidade, String sexo,
			String cpf) {
		super(id, nome, nascimento, naturalidade, sexo, cpf);
	}

	public List<Venda> getList() {
		return list;
	}

	public void setList(List<Venda> list) {
		this.list = list;
	}
	
}
