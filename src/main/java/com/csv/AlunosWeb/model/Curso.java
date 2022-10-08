package com.csv.AlunosWeb.model;

public class Curso {

	private int id;
	private String nomeCurso;
	private String cargaHoraria;
	
	
	
	public Curso() {
		super();
	}



	public Curso(int id, String nomeCurso, String cargaHoraria) {
		super();
		this.id = id;
		this.nomeCurso = nomeCurso;
		this.cargaHoraria = cargaHoraria;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDescrição() {
		return nomeCurso;
	}



	public void setDescrição(String nomeCurso) {
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
