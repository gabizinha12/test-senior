package com.senior.teste.crud.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senior.teste.crud.dto.EmpresaDTO;
import com.senior.teste.crud.entities.Empresa;
import com.senior.teste.crud.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repository;
	
	
	@Transactional
	public EmpresaDTO createEmpresa(EmpresaDTO empresaDTO) {
		Empresa empresa = new Empresa();
		copyDTOToEntity(empresaDTO, empresa);
		empresa = repository.save(empresa);
		return new EmpresaDTO(empresa);
	}
	
	@Transactional
	public EmpresaDTO update(Long id, EmpresaDTO dto) {
		Empresa entity = repository.findById(id).get();
		copyDTOToEntity(dto, entity);
		entity = repository.save(entity);
		return new EmpresaDTO(entity);
	}
	
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public EmpresaDTO findById(Long id) {
		Empresa entity = repository.findById(id).get();
		return new EmpresaDTO(entity);
		
	}
	
	public void copyDTOToEntity(EmpresaDTO dto, Empresa entity) {
		entity.setSocialReason(dto.getSocialReason());
		entity.setFantasyName(dto.getFantasyName());
		entity.setCnpj(dto.getCnpj());
		entity.setEmail(dto.getEmail());
		entity.setTelephone(dto.getTelephone());
		entity.getCnae().clear();
	}
 
}
