package com.csv.AlunosWeb.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csv.AlunosWeb.dao.AlunoDao;
import com.csv.AlunosWeb.dao.CursoDao;
import com.csv.AlunosWeb.dao.MatriculaDao;
import com.csv.AlunosWeb.model.Aluno;
import com.csv.AlunosWeb.model.Curso;
import com.csv.AlunosWeb.model.Matricula;
import com.csv.AlunosWeb.model.Matricula.StatusCurso;

@Controller
public class MatriculaController {

	@GetMapping("/matriculas")
	public String listaMatriculas(ModelMap modelMap) {
		MatriculaDao matriculaDao = new MatriculaDao();
		modelMap.addAttribute("lista", matriculaDao.SelecionarTodos());

		return "matriculas";
	}

	@GetMapping("/matriculas/create")
	public ModelAndView novaMatricula() {
		ModelAndView mv = new ModelAndView("createMatricula");
		AlunoDao alunoDao = new AlunoDao();
		CursoDao cursoDao = new CursoDao();
		List<Aluno> listAluno = alunoDao.SelecionarTodos();
		List<Curso> listCurso = cursoDao.SelecionarTodos();
		List<StatusCurso> listStatus = Arrays.asList(StatusCurso.values());
		mv.addObject("matricula", new Matricula());
		mv.addObject("listAluno", listAluno);
		mv.addObject("listCurso", listCurso);
		mv.addObject("listStatus", listStatus);
		return mv;
	}

	@PostMapping("/matriculas/create")
	public String salvarMatricula(Matricula matricula) {
		MatriculaDao matriculaDao = new MatriculaDao();
		if (matricula.getId() != null) {	
			matriculaDao.AtualizarMatricula(matricula.getId(), matricula);
		} else {
			Matricula m = new Matricula();
			m.setId(0);
			m.setAluno(matricula.getAluno());
			m.setCurso(matricula.getCurso());
			m.setStatus(matricula.getStatus());
			matriculaDao.AdicionarMatricula(m);

		}

		return "redirect:/matriculas";
	}

	
	
	@GetMapping("/matriculas/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("createMatricula");

		MatriculaDao matriculaDao = new MatriculaDao();
		Matricula m = matriculaDao.getMatricula(id);
		Matricula matricula = new Matricula();
		matricula.setId(m.getId());
		matricula.setAluno(m.getAluno());
		matricula.setCurso(m.getCurso());
		matricula.setStatus(m.getStatus());
		matriculaDao.AtualizarMatricula(matricula.getId(), matricula);
		mv.addObject("matricula", m);
		return mv;
	}

}
