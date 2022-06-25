package com.senior.teste.crud.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.senior.teste.crud.dto.EmpresaDTO;
import com.senior.teste.crud.services.EmpresaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@Api(tags = "Empresas")
@RequestMapping("/empresas")
public class EmpresaController {

	
	@Autowired
	private EmpresaService service;
	
	
	
	@ApiOperation(value = "Busca uma empresa por id", notes = "Este endpoint busca uma empresa por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmpresaDTO> findById(@PathVariable Long id) {
		EmpresaDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	@ApiOperation(value = "Cria uma empresa", notes = "Este endpoint cria uma empresa")
	@PostMapping(value = "/create")
	public ResponseEntity<EmpresaDTO> create(@Valid @RequestBody EmpresaDTO dto) {
		dto = service.createEmpresa(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@ApiOperation(value = "Atualiza uma empresa", notes = "Este endpoint atualiza uma empresa")
	@PutMapping(value = "/{id}")
	public ResponseEntity<EmpresaDTO> update(@PathVariable Long id,@Valid @RequestBody EmpresaDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	@ApiOperation(value = "Deleta uma empresa", notes = "Este endpoint deleta uma empresa")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<EmpresaDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
