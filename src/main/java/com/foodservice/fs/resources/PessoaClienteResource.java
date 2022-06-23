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

import com.foodservice.fs.domain.PessoaCliente;
import com.foodservice.fs.dtos.PessoaClienteDTO;
import com.foodservice.fs.services.PessoaClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/clientes")
public class PessoaClienteResource {

	@Autowired
	private PessoaClienteService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaClienteDTO> findById(@PathVariable Integer id){
		PessoaClienteDTO objDTO = new PessoaClienteDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaClienteDTO>> findAll(){
		List<PessoaClienteDTO> listDTO = service.findAll().stream().map(obj -> new PessoaClienteDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	/*
	 * cria novo cadastro
	 */
	@PostMapping
	public ResponseEntity<PessoaClienteDTO> create(@Valid @RequestBody PessoaClienteDTO objDTO){
		PessoaCliente newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	/*
	 * atualiza cadastro
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody PessoaClienteDTO objDTO){
		PessoaClienteDTO newObj = new PessoaClienteDTO(service.update(id, objDTO));
		
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
