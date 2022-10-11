package com.csv.AlunosWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csv.AlunosWeb.dao.AlunoDao;
import com.csv.AlunosWeb.model.Aluno;

@Controller
public class AlunoController {

	@GetMapping("/alunos")
	public String listaAlunos(ModelMap modelMap) {
		AlunoDao alunoDao = new AlunoDao();
		modelMap.addAttribute("lista", alunoDao.SelecionarTodos());

		return "alunos";
	}

	@GetMapping("/alunos/create")
	public ModelAndView novoAluno() {
		ModelAndView mv = new ModelAndView("create");
		mv.addObject("aluno", new Aluno());
		return mv;
	}

	@PostMapping("/alunos/create")
	public String salvarAluno(Aluno aluno) {
		AlunoDao alunoDao = new AlunoDao();
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

		return "redirect:/alunos";
	}

	
	
	@GetMapping("/alunos/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("create");

		AlunoDao alunoDao = new AlunoDao();
		Aluno a = alunoDao.getAluno(id);
		Aluno aluno = new Aluno();
		aluno.setId(a.getId());
		aluno.setNome(a.getNome());
		aluno.setEmail(a.getEmail());
		aluno.setTelefone(a.getTelefone());
		alunoDao.AtualizarAluno(aluno.getId(), aluno);
		mv.addObject("aluno", a);
		return mv;
	}

}
