package com.algaworks.cobranca.model;

public enum StatusTitulo {

	ESGOTADO("Esgotado"),
	DISPONIVEL("Disponivel");
	
	
	private String descricao;
	
	StatusTitulo(String descricao){
		this.descricao = descricao;
		
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
