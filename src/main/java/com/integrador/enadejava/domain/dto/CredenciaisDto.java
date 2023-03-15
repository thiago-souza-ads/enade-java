package com.integrador.enadejava.domain.dto;

import java.io.Serializable;

public class CredenciaisDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;
	
	public CredenciaisDto() {}

	public String getEmail() {
		return login;
	}

	public void setEmail(String email) {
		this.login = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
