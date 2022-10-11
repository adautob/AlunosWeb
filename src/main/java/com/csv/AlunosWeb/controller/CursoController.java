package com.csv.AlunosWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csv.AlunosWeb.dao.CursoDao;
import com.csv.AlunosWeb.model.Curso;

@Controller
public class CursoController {

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
		CursoDao cursoDao = new CursoDao();
		if (curso.getId() != null) {	
			cursoDao.AtualizarCurso(curso.getId(), curso);
		} else {
			Curso c = new Curso();
			c.setId(0);
			c.setNomeCurso(curso.getNomeCurso());
			c.setCargaHoraria(curso.getCargaHoraria());
			cursoDao.AdicionarCurso(c);

		}

		return "redirect:/cursos";
	}

	
	
	@GetMapping("/cursos/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("createCurso");

		CursoDao cursoDao = new CursoDao();
		Curso c = cursoDao.getCurso(id);
		Curso curso = new Curso();
		curso.setId(c.getId());
		curso.setNomeCurso(c.getNomeCurso());
		curso.setCargaHoraria(c.getCargaHoraria());
		cursoDao.AtualizarCurso(curso.getId(), curso);
		mv.addObject("curso", c);
		return mv;
	}

}
