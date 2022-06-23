package com.foodservice.fs.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodservice.fs.domain.Pessoa;
import com.foodservice.fs.domain.PessoaCliente;
import com.foodservice.fs.dtos.PessoaClienteDTO;
import com.foodservice.fs.repositories.PessoaClienteRepository;
import com.foodservice.fs.repositories.PessoaRepository;
import com.foodservice.fs.services.exceptions.DataIntegratyViolationException;
import com.foodservice.fs.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaClienteService {

	@Autowired
	public PessoaClienteRepository repository;
	
	@Autowired
	public PessoaRepository pessoaRepository;
	
	public PessoaCliente findById(Integer id) {
		Optional<PessoaCliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+id+", Tipo: "+PessoaCliente.class.getName()));
	}

	public List<PessoaCliente> findAll() {
		return repository.findAll();
	}
	
	public PessoaCliente create(PessoaClienteDTO objDTO) {
		if(findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}

		return repository.save(new PessoaCliente(null, objDTO.getNome(), objDTO.getNascimento(), objDTO.getNaturalidade(), objDTO.getSexo(), objDTO.getCpf()));
	}

	public PessoaCliente update(Integer id, @Valid PessoaClienteDTO objDTO) {
		PessoaCliente oldObj = findById(id);
		
		if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		
		oldObj.setNome(objDTO.getNome());
		oldObj.setNascimento(objDTO.getNascimento());
		oldObj.setNaturalidade(objDTO.getNaturalidade());
		oldObj.setSexo(objDTO.getSexo());
		oldObj.setCpf(objDTO.getCpf());
		
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {	
		PessoaCliente obj = findById(id);
		if(obj.getList().size() > 0) {
			throw new DataIntegratyViolationException("Cliente possui compras efetuadas! Não é possível remover!");
		}
		
		repository.deleteById(id);
	}
	
	private Pessoa findByCPF(PessoaClienteDTO objDTO) {
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		
		if(obj != null) {
			return obj;
		}
		
		return null;
	}

}
