package com.csv.AlunosWeb.model;

import org.springframework.stereotype.Component;

@Component
public class Aluno {

	private Integer id;
	private String nome;
	private String email;
	private String telefone;
	
	
	
	public Aluno() {
		super();
	}


	public Aluno(Integer id, String nome, String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]";
	}
	
	
	
}
