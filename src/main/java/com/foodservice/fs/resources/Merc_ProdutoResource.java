package com.foodservice.fs.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.foodservice.fs.domain.Merc_Produto;
import com.foodservice.fs.dtos.Merc_ProdutoDTO;
import com.foodservice.fs.services.Merc_ProdutoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/produtos")
public class Merc_ProdutoResource {
	
	@Autowired
	private Merc_ProdutoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Merc_ProdutoDTO> findById(@PathVariable Integer id){
		Merc_ProdutoDTO objDTO = new Merc_ProdutoDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<Merc_ProdutoDTO>> findAll(){
		List<Merc_ProdutoDTO> listDTO = service.findAll().stream().map(obj -> new Merc_ProdutoDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	/*
	 * cria novo cadastro
	 */
	@PostMapping
	public ResponseEntity<Merc_ProdutoDTO> create(@Valid @RequestBody Merc_ProdutoDTO objDTO){
		Merc_Produto newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	/*
	 * atualiza cadastro
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Merc_ProdutoDTO> update(@PathVariable Integer id, @Valid @RequestBody Merc_ProdutoDTO objDTO){
		Merc_ProdutoDTO newObj = new Merc_ProdutoDTO(service.update(id, objDTO));
		
		return ResponseEntity.ok().body(newObj);
	}
	
	/*
	 * exclui cadastro
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}
