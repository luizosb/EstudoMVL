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
@RequestMapping("/showderock")
public class TituloController {
	
	@Autowired
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("ShowDeRock");
		mv.addObject("todosStatusIngresso", StatusTitulo.values());
		return mv;
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public ModelAndView salvar(Titulo showderock) {
		titulos.save(showderock);
		
		ModelAndView mv = new ModelAndView("ShowDeRock");
		mv.addObject("mensagem", "Ingresso salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Titulo> todosIngressos = titulos.findAll();
		for (Titulo titulo : todosIngressos) {
			System.out.println(titulo.getDescricao());
		}
		ModelAndView mv = new ModelAndView("PesquisaIngressos");
		mv.addObject("showderock", todosIngressos);
		return mv;
	}
	
	@ModelAttribute("todosStatusIngresso")
	public List<StatusTitulo> todosStatusIngresso(){
		return Arrays.asList(StatusTitulo.values());
	}
}
