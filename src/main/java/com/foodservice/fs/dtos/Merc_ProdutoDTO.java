package com.foodservice.fs.dtos;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.foodservice.fs.domain.Merc_Produto;

public class Merc_ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "O campo NOME é requerido!")
	private String nome;
	
	@NotEmpty(message = "O campo UNIDADE DE MEDIDA é requerido!") 
	private String und_medida;
	
	@NotNull(message = "O campo QUANTIDADE é requerido!")
	private Integer qtde;
	
	private String descricao;
	
	private Integer cod_barras;

	public Merc_ProdutoDTO() {
		super();
	}

	public Merc_ProdutoDTO(Merc_Produto obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.und_medida = obj.getUnd_medida();
		this.qtde = obj.getQtde();
		this.descricao = obj.getDescricao();
		this.cod_barras = obj.getCod_barras();
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

	public String getUnd_medida() {
		return und_medida;
	}

	public void setUnd_medida(String und_medida) {
		this.und_medida = und_medida;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCod_barras() {
		return cod_barras;
	}

	public void setCod_barras(Integer cod_barras) {
		this.cod_barras = cod_barras;
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
		Merc_ProdutoDTO other = (Merc_ProdutoDTO) obj;
		return Objects.equals(id, other.id);
	}
	
}
