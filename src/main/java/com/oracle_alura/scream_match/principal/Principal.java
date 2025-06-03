package com.oracle_alura.scream_match.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.oracle_alura.scream_match.model.DadosSerie;
import com.oracle_alura.scream_match.model.DadosTemporada;
import com.oracle_alura.scream_match.service.ConsumoApi;
import com.oracle_alura.scream_match.service.ConverterDados;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverterDados conversor = new ConverterDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";
    public void exibeMenu(){
        System.out.println("Digite o nome da serié para busca:");

        var nomeSerie = scanner.nextLine();
		var json = consumo.obterDados(ENDERECO + nomeSerie.replaceAll(" ", "+") + API_KEY);
        
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i < dados.totalTemporadas(); i++) {
			json = consumo.obterDados(ENDERECO + nomeSerie.replaceAll(" ", "+") + "&season=" + i + API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);
    }
}
