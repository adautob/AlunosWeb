package com.csv.AlunosWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csv.AlunosWeb.dao.AlunoDao;
import com.csv.AlunosWeb.model.Aluno;
import com.csv.AlunosWeb.service.AlunoService;

@Controller()
public class AlunoController {
	
	AlunoService alunoService;
	

	public AlunoController(AlunoService alunoService) {
		super();
		this.alunoService = alunoService;
	}

	@GetMapping("/aluno")
	public String listaAlunos(ModelMap modelMap) {
		AlunoDao alunoDao = new AlunoDao();
		modelMap.addAttribute("lista", alunoDao.SelecionarTodos());

		return "alunos";
	}

	@GetMapping("/aluno/create")
	public ModelAndView novoAluno() {
		ModelAndView mv = new ModelAndView("create");
		mv.addObject("aluno", new Aluno());
		return mv;
	}

	@PostMapping("/aluno/create")
	public String salvarAluno(Aluno aluno) {
		alunoService.salvar(aluno);
		return "redirect:/aluno";
	}	
	
	@GetMapping("/aluno/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		return alunoService.editar(id);
	}

}
