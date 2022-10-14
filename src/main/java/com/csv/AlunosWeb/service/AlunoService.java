package com.csv.AlunosWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.csv.AlunosWeb.dao.AlunoDao;
import com.csv.AlunosWeb.model.Aluno;

@Service
public class AlunoService {
	
	@Autowired
	AlunoDao alunoDao;
	@Autowired
	Aluno aluno;
	
	public ModelAndView editar(Integer id) {
		ModelAndView mv = new ModelAndView("create");

		aluno = alunoDao.getAluno(id);
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	public void salvar(Aluno aluno) {
		if (aluno.getId() != null) {	
			alunoDao.AtualizarAluno(aluno.getId(), aluno);
		} else {
			Aluno a = new Aluno();
			a.setId(0);
			a.setNome(aluno.getNome());
			a.setEmail(aluno.getEmail());
			a.setTelefone(aluno.getTelefone());
			alunoDao.AdicionarAluno(a);
		}
		
	}

}
