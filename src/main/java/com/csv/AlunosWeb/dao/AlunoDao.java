package com.csv.AlunosWeb.dao;
import java.util.ArrayList;

import com.csv.AlunosWeb.model.Aluno;



public class AlunoDao {
	
	
	public AlunoDao() {
		
	}
	
	public void AdicionarCliente(Aluno a) {
		
		// código para incrementar o ID, pois este não será fornecido pelo usuário
		int idMaior = 0;
		for (Aluno alu : SelecionarTodos()) {
			if (alu.getId() > idMaior) idMaior = alu.getId();
		}

		a.setId(++idMaior);
		Banco.alunos.add(a);
		
	}
	
	public void RemoverAluno(int id) {
		for (int i = 0; i < Banco.alunos.size(); i++) {
			if (Banco.alunos.get(i).getId()==id)
				Banco.alunos.remove(i);
		}
		
		
	}
	
	public ArrayList<Aluno> SelecionarTodos(){
		return Banco.alunos;	
	}
	
	public Aluno getAluno(int index) {
		Aluno aluno = new Aluno();
		for (int i = 0; i < Banco.alunos.size(); i++) {
			if (Banco.alunos.get(i).getId()==index)
				aluno = Banco.alunos.get(i);
		}
		return aluno;
	}
	
	public void AtualizarAluno(int id, Aluno aluno) {
		for (int i = 0; i < Banco.alunos.size(); i++) {
			if (Banco.alunos.get(i).getId()==id)
				Banco.alunos.set(i, aluno);
		}
	}

}

