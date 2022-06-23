package com.foodservice.fs.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "venda")
	private List<VendaItem> list = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime data;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private PessoaCliente cliente;
	
	private Float valor_total;
	private String tipo_pagamento;
	private String entrega;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime data_entrega;
	
	private String obs;
	private String status;
	private Integer id_user;
	
	public Venda() {
		super();
	}

	public Venda(Integer id, LocalDateTime data, PessoaCliente cliente, Float valor_total, String tipo_pagamento,
			String entrega, LocalDateTime data_entrega, String obs, String status, Integer id_user) {
		super();
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.valor_total = valor_total;
		this.tipo_pagamento = tipo_pagamento;
		this.entrega = entrega;
		this.data_entrega = data_entrega;
		this.obs = obs;
		this.status = status;
		this.id_user = id_user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public PessoaCliente getCliente() {
		return cliente;
	}

	public void setCliente(PessoaCliente cliente) {
		this.cliente = cliente;
	}

	public Float getValor_total() {
		return valor_total;
	}

	public void setValor_total(Float valor_total) {
		this.valor_total = valor_total;
	}

	public String getTipo_pagamento() {
		return tipo_pagamento;
	}

	public void setTipo_pagamento(String tipo_pagamento) {
		this.tipo_pagamento = tipo_pagamento;
	}

	public String getEntrega() {
		return entrega;
	}

	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	public LocalDateTime getData_entrega() {
		return data_entrega;
	}

	public void setData_entrega(LocalDateTime data_entrega) {
		this.data_entrega = data_entrega;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
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
		Venda other = (Venda) obj;
		return Objects.equals(id, other.id);
	}
	
}
