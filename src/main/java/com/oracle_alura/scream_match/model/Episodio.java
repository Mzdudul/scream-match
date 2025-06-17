package com.oracle_alura.scream_match.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Episodio {
    private Integer temporada; 
    private String titulo;
    private Integer numeroEpisodio;
    private Double avaliacao;
    private LocalDate dataLancamento;

    

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio){
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodio.titulo();
        this.numeroEpisodio = dadosEpisodio.numero();
        try{
        this.avaliacao = Double.valueOf(dadosEpisodio.avaliacoes());
        }catch(NumberFormatException e){
            this.avaliacao = 0.0;
        }
        try{
            this.dataLancamento = LocalDate.parse(dadosEpisodio.dataLancamento()); 
        }catch(DateTimeParseException e){
            this.dataLancamento = null;
        }
    }

        public String toString(){
           return "{ temporada: " + temporada + " titulo: " + titulo + " numeroEpisodios: " + numeroEpisodio + " avaliacao: " + " dataLancamento: " + dataLancamento + " }";
            
        }
}
