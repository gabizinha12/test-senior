package com.senior.teste.crud.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import com.senior.teste.crud.entities.Empresa;

public class EmpresaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	@CNPJ
	private String cnpj;
	private String socialReason;
	private String fantasyName;
	@Size(max = 30)
	private String nickName;
	@Pattern(regexp = "^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$")
	private String telephone;
	@Email(message = "Favor entrar um email válido")
	private String email;
	private String address;
    @ElementCollection
	private List<String> cnae = new ArrayList<>();

	public EmpresaDTO() {
	}

	public EmpresaDTO(Empresa entity) {
		id = entity.getId();
		cnpj = entity.getCnpj();
		socialReason = entity.getSocialReason();
		fantasyName = entity.getFantasyName();
		nickName = entity.getNickName();
		telephone = entity.getTelephone();
		email = entity.getEmail();
		cnae = entity.getCnae();
		setAddress(entity.getAddress());
	}

	public EmpresaDTO(Long id, @CNPJ String cnpj, String socialReason, String fantasyName,
			@Size(max = 30) String nickName,
			@Pattern(regexp = "/^\\([0-9]{2}\\) [0-9]?[0-9]{4}-[0-9]{4}$/\r\n") String telephone,
			@Email(message = "Favor entrar um email válido") String email, List<String> cnae, String address) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.socialReason = socialReason;
		this.fantasyName = fantasyName;
		this.nickName = nickName;
		this.telephone = telephone;
		this.email = email;
		this.cnae = cnae;
	    this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSocialReason() {
		return socialReason;
	}

	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getCnae() {
		return cnae;
	}

	public void setCnae(List<String> cnae) {
		this.cnae = cnae;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
