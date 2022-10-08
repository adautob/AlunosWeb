package com.csv.AlunosWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlunoController {

	@RequestMapping("alunos")
	public String listaAlunos(ModelMap modelMap) {
		modelMap.put("id", 1);
		modelMap.put("nome", "Adauto");
		modelMap.put("email", "adauto@email.com");
		
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
