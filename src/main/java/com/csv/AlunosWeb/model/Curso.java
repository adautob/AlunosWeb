package com.csv.AlunosWeb.model;

public class Curso {

	private int id;
	private String descrição;
	private String cargaHoraria;
	
	
	
	public Curso() {
		super();
	}



	public Curso(int id, String descrição, String cargaHoraria) {
		super();
		this.id = id;
		this.descrição = descrição;
		this.cargaHoraria = cargaHoraria;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDescrição() {
		return descrição;
	}



	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}



	public String getCargaHoraria() {
		return cargaHoraria;
	}



	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}



	@Override
	public String toString() {
		return "Curso [id=" + id + ", descrição=" + descrição + ", cargaHoraria=" + cargaHoraria + "]";
	}
	
	
	
	
	
	
}
