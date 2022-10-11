package com.csv.AlunosWeb.dao;
import java.util.ArrayList;

import com.csv.AlunosWeb.model.Curso;



public class CursoDao {
	
	
	public CursoDao() {
		
	}
	
	public void AdicionarCurso(Curso c) {
		
		// código para incrementar o ID, pois este não será fornecido pelo usuário
		int idMaior = 0;
		for (Curso cur : SelecionarTodos()) {
			if (cur.getId() > idMaior) idMaior = cur.getId();
		}

		c.setId(++idMaior);
		Banco.cursos.add(c);
		
	}
	
	public void RemoverCurso(int id) {
		for (int i = 0; i < Banco.alunos.size(); i++) {
			if (Banco.cursos.get(i).getId()==id)
				Banco.cursos.remove(i);
		}
		
		
	}
	
	public ArrayList<Curso> SelecionarTodos(){
		return Banco.cursos;	
	}
	
	public Curso getCurso(int index) {
		Curso curso = new Curso();
		for (int i = 0; i < Banco.cursos.size(); i++) {
			if (Banco.cursos.get(i).getId()==index)
				curso = Banco.cursos.get(i);
		}
		return curso;
	}
	
	public void AtualizarCurso(int id, Curso curso) {
		for (int i = 0; i < Banco.cursos.size(); i++) {
			if (Banco.cursos.get(i).getId()==id)
				Banco.cursos.set(i, curso);
		}
	}

}

