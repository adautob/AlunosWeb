package com.csv.AlunosWeb.dto;

public class MatriculaDto {

	private Integer id;
	private Integer idAluno;
	private Integer idCurso;
	private String status;
	
	
	public MatriculaDto() {
		super();
	}


	
	public MatriculaDto(Integer id, Integer idAluno, Integer idCurso, String status) {
		super();
		this.id = id;
		this.idAluno = idAluno;
		this.idCurso = idCurso;
		this.status = status;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getIdAluno() {
		return idAluno;
	}


	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}


	public Integer getIdCurso() {
		return idCurso;
	}


	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


}
