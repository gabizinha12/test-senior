package com.senior.teste.crud.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senior.teste.crud.dto.EmpresaDTO;
import com.senior.teste.crud.entities.Empresa;
import com.senior.teste.crud.exceptions.DatabaseException;
import com.senior.teste.crud.exceptions.ResourceNotFoundException;
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
		Empresa entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Objeto inexistente na base de dados"));
		copyDTOToEntity(dto, entity);
		entity = repository.save(entity);
		return new EmpresaDTO(entity);

	}

	public void delete(Long id) {
		try {
		repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não existe " + id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação na integridade da base de dados");
		}
	}

	@Transactional(readOnly = true)
	public EmpresaDTO findById(Long id) {
		Empresa entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id inexistente"));
		return new EmpresaDTO(entity);

	}

	@Transactional(readOnly = true)
	public List<EmpresaDTO> findAll() {
		List<Empresa> list = repository.findAll();
		return list.stream().map(e -> new EmpresaDTO(e)).collect(Collectors.toList()); // percorre a lista e converte
																						// cada objeto para o dto e em
																						// seguida converte em lista

	}

	public void copyDTOToEntity(EmpresaDTO dto, Empresa entity) {
		entity.setSocialReason(dto.getSocialReason());
		entity.setFantasyName(dto.getFantasyName());
		entity.setNickName(dto.getNickName());
		entity.setCnpj(dto.getCnpj());
		entity.setEmail(dto.getEmail());
		entity.setTelephone(dto.getTelephone());
		entity.setCnae(dto.getCnae());
		entity.setAddress(dto.getAddress());
	}

}
