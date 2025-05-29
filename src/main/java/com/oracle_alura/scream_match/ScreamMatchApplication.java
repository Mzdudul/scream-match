package com.oracle_alura.scream_match;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oracle_alura.scream_match.model.DadosSerie;
import com.oracle_alura.scream_match.service.ConsumoApi;
import com.oracle_alura.scream_match.service.ConverterDados;

@SpringBootApplication
public class ScreamMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreamMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		ConverterDados conversor = new ConverterDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}

	

}
