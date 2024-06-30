package com.javatechie;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjectApplication implements CommandLineRunner {

	@PostConstruct
	public void preInitialize() {
		System.out.println("firstly postconstruct will execute");
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstProjectApplication.class, args);
		System.out.println("thirdly sprinboot's run() method will run");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("secondly command line runner is executing");
	}
}
