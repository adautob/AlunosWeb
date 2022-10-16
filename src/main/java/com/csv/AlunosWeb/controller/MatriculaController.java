package com.csv.AlunosWeb.controller;

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
import com.csv.AlunosWeb.dto.MatriculaDto;
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
		mv.addObject("matricula", new Matricula());
		mv.addObject("listAluno", listAluno);
		mv.addObject("listCurso", listCurso);
		return mv;
	}

	@PostMapping("/matriculas/create")
	public String salvarMatricula(MatriculaDto matriculaDto) {
		Aluno aluno = new AlunoDao().getAluno(matriculaDto.getIdAluno());
		Curso curso = new CursoDao().getCurso(matriculaDto.getIdCurso()); 
		Matricula salvarMatricula = new Matricula();
		salvarMatricula.setAluno(aluno);
		salvarMatricula.setCurso(curso);
		salvarMatricula.setStatus(StatusCurso.Iniciado);

		MatriculaDao matriculaDao = new MatriculaDao();
		if (matriculaDto.getId() != null) {	
			matriculaDao.AtualizarMatricula(salvarMatricula.getId(), salvarMatricula);
		} else {			
			salvarMatricula.setId(0);
			matriculaDao.AdicionarMatricula(salvarMatricula);
		}
		return "redirect:/matriculas";
	}

	
	
	@GetMapping("/matriculas/edit/concluir/{id}")
	public String editConcluir(@PathVariable("id") int id) {
		
		MatriculaDao matriculaDao = new MatriculaDao();
		Matricula matricula = matriculaDao.getMatricula(id);
		matricula.setStatus(StatusCurso.Concluido);
		matriculaDao.AtualizarMatricula(matricula.getId(), matricula);

		return "redirect:/matriculas";
		
	}
	
	@GetMapping("/matriculas/edit/cancelar/{id}")
	public String editCancelar(@PathVariable("id") int id) {
		
		MatriculaDao matriculaDao = new MatriculaDao();
		Matricula matricula = matriculaDao.getMatricula(id);
		matricula.setStatus(StatusCurso.Cancelado);
		matriculaDao.AtualizarMatricula(matricula.getId(), matricula);

		return "redirect:/matriculas";
		
	}	

}
