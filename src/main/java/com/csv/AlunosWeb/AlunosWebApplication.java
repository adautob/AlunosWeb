package com.csv.AlunosWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.csv.AlunosWeb.dao.Banco;

@SpringBootApplication
public class AlunosWebApplication {

	public static void main(String[] args) {
		Banco.inicia();
		SpringApplication.run(AlunosWebApplication.class, args);
	}

}
