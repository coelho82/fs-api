package com.foodservice.fs.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodservice.fs.domain.PessoaCliente;
import com.foodservice.fs.domain.Venda;
import com.foodservice.fs.dtos.VendaDTO;
import com.foodservice.fs.repositories.VendaRepository;
import com.foodservice.fs.services.exceptions.ObjectNotFoundException;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private PessoaClienteService pessoaClienteService;
	
	public Venda findById(Integer id) {
		Optional<Venda> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Venda.class.getName()));
	}
	
	public List<Venda> findAll(){
		return repository.findAll();
	}

	public Venda create(@Valid VendaDTO obj) {
		return fromDTO(obj);
	}
	
	public Venda update(@Valid VendaDTO obj) {
		findById(obj.getId());
		
		return fromDTO(obj);
	}
	
	private Venda fromDTO(VendaDTO obj) {
		Venda newObj = new Venda();
		
		newObj.setId(obj.getId());
		newObj.setData(obj.getData());
		
		PessoaCliente cli = pessoaClienteService.findById(obj.getCliente()); 
		
		newObj.setCliente(cli);
		newObj.setValor_total(obj.getValor_total());
		newObj.setTipo_pagamento(obj.getTipo_pagamento());
		newObj.setEntrega(obj.getEntrega());
		newObj.setData_entrega(obj.getData_entrega());
		newObj.setObs(obj.getObs());
		newObj.setStatus(obj.getStatus());
		newObj.setId_user(obj.getId_user());
		
		return repository.save(newObj);
	}

}
