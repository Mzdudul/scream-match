package com.oracle_alura.scream_match.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
