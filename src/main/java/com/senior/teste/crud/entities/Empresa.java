package com.senior.teste.crud.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_empresa")
public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cnpj;
	private String socialReason;
	private String fantasyName;
	private String nickName;
	private String telephone;
	private String email;
	private String address;
    @ElementCollection
	private List<String> cnae = new ArrayList<>();


	public Empresa() {
	}

	public Empresa(Long id, String cnpj, String socialReason, String fantasyName, String nickName, String telephone,
			String email,  String address, List<String> cnae) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.socialReason = socialReason;
		this.fantasyName = fantasyName;
		this.nickName = nickName;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
		this.cnae = cnae;
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
