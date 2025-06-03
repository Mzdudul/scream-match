package com.oracle_alura.scream_match;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oracle_alura.scream_match.principal.Principal;

@SpringBootApplication
public class ScreamMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreamMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}

	

}
