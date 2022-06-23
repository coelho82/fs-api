package com.foodservice.fs.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.foodservice.fs.domain.Venda;

public class VendaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime data;
	
	@NotNull(message = "O campo CLIENTE é requerido!")
	private Integer cliente;
	
	private Float valor_total;
	
	@NotEmpty(message = " O campo TIPO DE PAGAMENTO é requerido!")
	private String tipo_pagamento;
	
	private String entrega;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime data_entrega;
	
	private String obs;
	private String status;
	private Integer id_user;
	
	public VendaDTO() {
		super();
	}

	public VendaDTO(Venda obj) {
		super();
		this.id = obj.getId();
		this.data = LocalDateTime.now();
		this.cliente = obj.getCliente().getId();
		this.valor_total = obj.getValor_total();
		this.tipo_pagamento = obj.getTipo_pagamento();
		this.entrega = obj.getEntrega();
		this.data_entrega = obj.getData_entrega();
		this.obs = obj.getObs();
		this.status = obj.getStatus();
		this.id_user = obj.getId_user();
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

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
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
	
}
