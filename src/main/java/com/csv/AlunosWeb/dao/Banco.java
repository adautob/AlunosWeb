package com.csv.AlunosWeb.dao;

import java.util.ArrayList;

import com.csv.AlunosWeb.model.Aluno;
import com.csv.AlunosWeb.model.Curso;
import com.csv.AlunosWeb.model.Matricula;
import com.csv.AlunosWeb.model.Matricula.StatusCurso;

public class Banco {

	public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	public static ArrayList<Curso> cursos = new ArrayList<Curso>();
	public static ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
		
	
	public static void inicia() {
		Aluno a1 = new Aluno(1, "Adauto", "adauto@email.com", "1223455677");
		Aluno a2 = new Aluno(2, "Joao", "joao@email.com", "1223455677");
		Curso c1 = new Curso(1, "Java", "40");
		Curso c2 = new Curso(2, "Html", "30");
		Matricula m1 = new Matricula(1, a1, c1, StatusCurso.EM_ANDAMENTO);
		Matricula m2 = new Matricula(2, a1, c2, StatusCurso.EM_ANDAMENTO);
		Matricula m3 = new Matricula(3, a2, c1, StatusCurso.EM_ANDAMENTO);
		
		alunos.add(a1);
		alunos.add(a2);
		cursos.add(c1);
		cursos.add(c2);
		matriculas.add(m1);
		matriculas.add(m2);
		matriculas.add(m3);
		
	}
	
}
