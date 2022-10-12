package com.csv.AlunosWeb.dao;
import java.util.ArrayList;

import com.csv.AlunosWeb.model.Matricula;



public class MatriculaDao {
	
	
	public MatriculaDao() {
		
	}
	
	public void AdicionarMatricula(Matricula m) {
		
		// código para incrementar o ID, pois este não será fornecido pelo usuário
		int idMaior = 0;
		for (Matricula mat : SelecionarTodos()) {
			if (mat.getId() > idMaior) idMaior = mat.getId();
		}

		m.setId(++idMaior);
		Banco.matriculas.add(m);
		
	}
	
	public void RemoverMatricula(int id) {
		for (int i = 0; i < Banco.matriculas.size(); i++) {
			if (Banco.matriculas.get(i).getId()==id)
				Banco.matriculas.remove(i);
		}
		
		
	}
	
	public ArrayList<Matricula> SelecionarTodos(){
		return Banco.matriculas;	
	}
	
	public Matricula getMatricula(int index) {
		Matricula matricula = new Matricula();
		for (int i = 0; i < Banco.matriculas.size(); i++) {
			if (Banco.matriculas.get(i).getId()==index)
				matricula = Banco.matriculas.get(i);
		}
		return matricula;
	}
	
	public void AtualizarMatricula(int id, Matricula matricula) {
		for (int i = 0; i < Banco.matriculas.size(); i++) {
			if (Banco.matriculas.get(i).getId()==id)
				Banco.matriculas.set(i, matricula);
		}
	}

}

