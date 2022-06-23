package com.foodservice.fs.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Mercadoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String und_medida;
	private Integer qtde;
	private String descricao;
	private Integer cod_barras;
	
	public Mercadoria() {
		super();
	}

	public Mercadoria(Integer id, String nome, String und_medida, Integer qtde, String descricao,
			Integer cod_barras) {
		super();
		this.id = id;
		this.nome = nome;
		this.und_medida = und_medida;
		this.qtde = qtde;
		this.descricao = descricao;
		this.cod_barras = cod_barras;
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
		Mercadoria other = (Mercadoria) obj;
		return Objects.equals(id, other.id);
	}
	
}
