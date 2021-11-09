package br.com.dh.online.Primeiro.projeto.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Aula16SprintApplication {

	public static void main(String[] args) {
		SpringApplication.run(Aula16SprintApplication.class, args);
	}

	@GetMapping
	public String olaMundo(){
		return "Olá Mundo";
	}

}
