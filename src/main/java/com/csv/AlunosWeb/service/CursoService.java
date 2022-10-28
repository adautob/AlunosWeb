package com.csv.AlunosWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.csv.AlunosWeb.dao.CursoDao;
import com.csv.AlunosWeb.model.Curso;

@Service
public class CursoService {
	
	@Autowired
	CursoDao cursoDao;
	@Autowired
	Curso curso;
	
	public ModelAndView editar(Integer id) {
		ModelAndView mv = new ModelAndView("create");

		curso = cursoDao.getCurso(id);
		mv.addObject("curso", curso);
		return mv;
	}
	
	public void salvar(Curso curso) {
		if (curso.getId() != null) {	
			cursoDao.AtualizarCurso(curso.getId(), curso);
		} else {
			Curso c = new Curso();
			c.setId(0);
			c.setNomeCurso(curso.getNomeCurso());
			c.setCargaHoraria(curso.getCargaHoraria());
			cursoDao.AdicionarCurso(curso);
		}
		
	}

}
