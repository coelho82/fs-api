package com.foodservice.fs.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VendaItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_venda")
	private Venda venda;

	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Merc_Produto produto;

	private Integer qtde_v;
	private Float valor_unitario;
	private Float valor_total;

	public VendaItem() {
		super();
	}

	public VendaItem(Integer id, Venda venda, Merc_Produto produto, Integer qtde_v, Float valor_unitario,
			Float valor_total) {
		super();
		this.id = id;
		this.venda = venda;
		this.produto = produto;
		this.qtde_v = qtde_v;
		this.valor_unitario = valor_unitario;
		this.valor_total = valor_total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Merc_Produto getProduto() {
		return produto;
	}

	public void setProduto(Merc_Produto produto) {
		this.produto = produto;
	}

	public Integer getQtde() {
		return qtde_v;
	}

	public void setQtde(Integer qtde_v) {
		this.qtde_v = qtde_v;
	}

	public Float getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(Float valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public Float getValor_total() {
		return valor_total;
	}

	public void setValor_total(Float valor_total) {
		this.valor_total = valor_total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		VendaItem other = (VendaItem) obj;
		return Objects.equals(id, other.id);
	}

}
