package com.oracle_alura.scream_match.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String titulo,@JsonAlias("Episode") Integer numero,@JsonAlias("imdbRating") String avaliacoes,@JsonAlias("Released") String dataLancamento) {
    
}
