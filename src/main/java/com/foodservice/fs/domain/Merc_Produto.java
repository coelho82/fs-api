package com.foodservice.fs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Merc_Produto extends Mercadoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "produto")
	private List<VendaItem> list = new ArrayList<>();	
	
	public Merc_Produto() {
		super();
	}

	public Merc_Produto(Integer id, String nome, String und_medida, Integer qtde, String descricao,
			Integer cod_barras) {
		super(id, nome, und_medida, qtde, descricao, cod_barras);
	}

	public List<VendaItem> getList() {
		return list;
	}

	public void setList(List<VendaItem> list) {
		this.list = list;
	}
	
}
