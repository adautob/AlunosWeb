package com.csv.AlunosWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csv.AlunosWeb.dao.AlunoDao;
import com.csv.AlunosWeb.model.Aluno;

@Controller
public class AlunoController {

	@GetMapping("alunos")
	public String listaAlunos(ModelMap modelMap) {
		AlunoDao alunoDao = new AlunoDao();
		modelMap.addAttribute("lista", alunoDao.SelecionarTodos());

		return "alunos";
	}

	@GetMapping("alunos/create")
	public ModelAndView novoAluno() {
	    ModelAndView mv = new ModelAndView("create");
	    mv.addObject("aluno", new Aluno());
	    return mv;
	}

	@PostMapping("alunos/create")
	public String salvarAluno(ModelMap modelMap) {

		return "alunos";
	}

}
