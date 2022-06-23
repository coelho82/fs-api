package com.foodservice.fs.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodservice.fs.domain.Merc_Produto;
import com.foodservice.fs.dtos.Merc_ProdutoDTO;
import com.foodservice.fs.repositories.Merc_ProdutoRepository;
import com.foodservice.fs.repositories.MercadoriaRepository;
import com.foodservice.fs.services.exceptions.DataIntegratyViolationException;
import com.foodservice.fs.services.exceptions.ObjectNotFoundException;

@Service
public class Merc_ProdutoService {

	@Autowired
	public Merc_ProdutoRepository repository;
	
	@Autowired
	public MercadoriaRepository repositoryProduto;
	
	public Merc_Produto findById(Integer id) {
		Optional<Merc_Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+id+", Tipo: "+Merc_Produto.class.getName()));
	}
	
	public List<Merc_Produto> findAll() {
		return repository.findAll();
	}
	
	public Merc_Produto create(Merc_ProdutoDTO objDTO) {
		/*
		if(findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		*/

		return repository.save(new Merc_Produto(null, objDTO.getNome(), objDTO.getUnd_medida(), objDTO.getQtde(), objDTO.getDescricao(), objDTO.getCod_barras()));
	}
	
	public Merc_Produto update(Integer id, @Valid Merc_ProdutoDTO objDTO) {
		Merc_Produto oldObj = findById(id);
		
		/*
		if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		*/
		
		oldObj.setNome(objDTO.getNome());
		oldObj.setUnd_medida(objDTO.getUnd_medida());
		oldObj.setQtde(objDTO.getQtde());
		oldObj.setDescricao(objDTO.getDescricao());
		oldObj.setCod_barras(objDTO.getCod_barras());
		
		
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {	
		Merc_Produto obj = findById(id);
		if(obj.getList().size() > 0) {
			throw new DataIntegratyViolationException("Produto possui compras relacionadas! Não é possível remover!");
		}
		
		repository.deleteById(id);
	}
}
