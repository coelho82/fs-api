package com.foodservice.fs.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.foodservice.fs.dtos.VendaDTO;
import com.foodservice.fs.services.VendaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/venda")
public class VendaResource {
	
	@Autowired
	private VendaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<VendaDTO> findById(@PathVariable Integer id){
		VendaDTO obj = new VendaDTO(service.findById(id));
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<VendaDTO>> findAll(){
		List<VendaDTO> list = service.findAll().stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<VendaDTO> create(@Valid @RequestBody VendaDTO obj){
		obj = new VendaDTO(service.create(obj));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<VendaDTO> update(@Valid @RequestBody VendaDTO obj){
		obj = new VendaDTO(service.update(obj));
		
		return ResponseEntity.ok().body(obj);
	}
}
