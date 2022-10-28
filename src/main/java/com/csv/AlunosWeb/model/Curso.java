package com.csv.AlunosWeb.model;

import org.springframework.stereotype.Component;

@Component
public class Curso {

	private Integer id;
	private String nomeCurso;
	private String cargaHoraria;
	
	
	
	public Curso() {
		super();
	}



	public Curso(Integer id, String nomeCurso, String cargaHoraria) {
		super();
		this.id = id;
		this.nomeCurso = nomeCurso;
		this.cargaHoraria = cargaHoraria;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNomeCurso() {
		return nomeCurso;
	}



	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}



	public String getCargaHoraria() {
		return cargaHoraria;
	}



	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}



	@Override
	public String toString() {
		return "Curso [id=" + id + ", curso=" + nomeCurso + ", cargaHoraria=" + cargaHoraria + "]";
	}
	
	
	
}
