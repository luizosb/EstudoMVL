package com.algaworks.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algaworks.cobranca.model.Titulo;


@Controller
public class TituloController {
	
	@RequestMapping("showderock/novo")
	public String novo() {
		return "CadastroTitulo";
	}
	
	@RequestMapping(value="showderock", method = RequestMethod.POST)
	public String  salvar(Titulo showderock) {
		//TODO: Salvar no banco de dados
		System.out.println(">>>> " + showderock.getDescricao());
		
		return "CadastroTitulo";
		
	}

	
	
}
