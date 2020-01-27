package com.algaworks.cobranca.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;

@Controller
@RequestMapping("/showderock")
public class TituloController {

	private final String SHOWDEROCK_VIEW = "ShowDeRock";

	@Autowired
	private Titulos titulos;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(SHOWDEROCK_VIEW);
		mv.addObject("todosStatusIngresso", StatusTitulo.values());
		mv.addObject(new Titulo());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Titulo showderock, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return SHOWDEROCK_VIEW;
		}
		titulos.save(showderock);
		attributes.addFlashAttribute("mensagem", "Ingresso salvo com sucesso!");
		return "redirect:/showderock/novo";
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

	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Optional<Titulo> showderock) {
		ModelAndView mv = new ModelAndView(SHOWDEROCK_VIEW);
		System.out.println(showderock.get().getDescricao());
		mv.addObject(showderock.get());
		return mv;
	}

	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		titulos.deleteById(codigo); 

		attributes.addFlashAttribute("mensagem", "Ingresso deletado com sucesso!");
		return "redirect:/showderock";
	}

	@ModelAttribute("todosStatusIngresso")
	public List<StatusTitulo> todosStatusIngresso() {
		return Arrays.asList(StatusTitulo.values());
	}
}
