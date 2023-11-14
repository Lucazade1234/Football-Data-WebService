package com.example.demo;

import com.example.demo.Repositories.CountryRepository;
import com.example.demo.Services.CountryService;
import com.example.demo.models.Country;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FootballDataWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballDataWebServiceApplication.class, args);
	}

}
