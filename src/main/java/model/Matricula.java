package model;

public class Matricula {

	private int id;
	private Aluno aluno;
	private Curso curso;
	private enum Status {
		EM_ANDAMENTO,
		CONCLUIDO
	}
	Status status;
	
	
	public Matricula() {
		super();
	}

	public Matricula(int id, Aluno aluno, Curso curso, Status status) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.curso = curso;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	
}
