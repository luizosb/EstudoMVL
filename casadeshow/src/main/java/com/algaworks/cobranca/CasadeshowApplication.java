package com.algaworks.cobranca;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.LocaleResolver;

@SpringBootApplication
public class CasadeshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasadeshowApplication.class, args);
	}
		
		
		
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
	
		
}


