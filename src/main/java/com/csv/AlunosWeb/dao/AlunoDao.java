package com.csv.AlunosWeb.dao;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.csv.AlunosWeb.model.Aluno;


@Component
public class AlunoDao {
	
	
	public AlunoDao() {
		
	}
	
	public void AdicionarAluno(Aluno a) {
		
		// código para incrementar o ID, pois este não será fornecido pelo usuário
		int idMaior = 0;
		for (Aluno alu : SelecionarTodos()) {
			if (alu.getId() > idMaior) idMaior = alu.getId();
		}

		a.setId(++idMaior);
		Banco.alunos.add(a);
		
	}
	
	// percorre a lista de alunos para remover o aluno
	public void RemoverAluno(int id) {
		for (int i = 0; i < Banco.alunos.size(); i++) {
			// compara se o Id recebido no parâmetro é o mesmo que está sendo iterado
			// se for igual remove o aluno da lista
			if (Banco.alunos.get(i).getId()==id)
				Banco.alunos.remove(i);
		}
		
		
	}
	
	public ArrayList<Aluno> SelecionarTodos(){
		return Banco.alunos;	
	}
	
	// percorre a lista para encontrar um aluno pelo id
	public Aluno getAluno(int index) {
		Aluno aluno = new Aluno();
		for (int i = 0; i < Banco.alunos.size(); i++) {
			if (Banco.alunos.get(i).getId()==index)
				aluno = Banco.alunos.get(i);
		}
		return aluno;
	}
	
	// atualiza o aluno na lista, recebendo como parâmetro o id a ser alterado e o Aluno
	public void AtualizarAluno(int id, Aluno aluno) {
		for (int i = 0; i < Banco.alunos.size(); i++) {
			if (Banco.alunos.get(i).getId()==id)
				Banco.alunos.set(i, aluno);
		}
	}

}

