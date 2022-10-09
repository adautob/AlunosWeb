package com.csv.AlunosWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csv.AlunosWeb.dao.AlunoDao;

@Controller
public class AlunoController {

	@RequestMapping("alunos")
	public String listaAlunos(ModelMap modelMap) {
		AlunoDao alunoDao = new AlunoDao();
		modelMap.addAttribute("lista", alunoDao.SelecionarTodos());
				
		return "alunos";
	}
	
	@RequestMapping("alunos/novo")
	public String novoAluno() {
		return "novoAluno";
	}
	
	@RequestMapping("alunos/salvar")
	public String salvarAluno(ModelMap modelMap) {
		
		return "alunos";
	}
	
	
}
