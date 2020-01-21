package com.algaworks.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;


@Controller
public class TituloController {
	
	@Autowired
	private Titulos titulos;
	
	@RequestMapping("showderock/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("todosStatusIngresso", StatusTitulo.values());
		return mv;
	}
	
	@RequestMapping(value="showderock", method = RequestMethod.POST)
	public ModelAndView salvar(Titulo showderock) {
		titulos.save(showderock);
		
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Ingresso salvo com sucesso!");
		return mv;
	}
	
	@ModelAttribute("todosStatusIngresso")
	public List<StatusTitulo> todosStatusIngresso(){
		return Arrays.asList(StatusTitulo.values());
	}
}
