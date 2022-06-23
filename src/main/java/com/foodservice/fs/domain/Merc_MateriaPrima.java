package com.foodservice.fs.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Merc_MateriaPrima extends Mercadoria implements Serializable{
	private static final long serialVersionUID = 1L;

	public Merc_MateriaPrima() {
		super();
	}

	public Merc_MateriaPrima(Integer id, String nome, String und_medida, Integer qtde, String descricao,
			Integer cod_barras) {
		super(id, nome, und_medida, qtde, descricao, cod_barras);
	}
	
}
