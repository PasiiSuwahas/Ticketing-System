package com.example.demo22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Demo22Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo22Application.class, args);
	}

}
