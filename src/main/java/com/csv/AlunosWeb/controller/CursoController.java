package com.csv.AlunosWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csv.AlunosWeb.dao.CursoDao;
import com.csv.AlunosWeb.model.Curso;
import com.csv.AlunosWeb.service.CursoService;

@Controller
public class CursoController {
	
	@Autowired
	CursoService cursoService;

	@GetMapping("/cursos")
	public String listaCursos(ModelMap modelMap) {
		CursoDao cursoDao = new CursoDao();
		modelMap.addAttribute("lista", cursoDao.SelecionarTodos());

		return "cursos";
	}

	@GetMapping("/cursos/create")
	public ModelAndView novoCurso() {
		ModelAndView mv = new ModelAndView("createCurso");
		mv.addObject("curso", new Curso());
		return mv;
	}

	@PostMapping("/cursos/create")
	public String salvarCurso(Curso curso) {
		cursoService.salvar(curso);
		return "redirect:/cursos";
	}

	
	
	@GetMapping("/cursos/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		return cursoService.editar(id);
	}

}
