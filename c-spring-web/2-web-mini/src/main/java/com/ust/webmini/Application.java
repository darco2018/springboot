package com.ust.webmini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	// if Idea cant see spring dependencies -> deleting the auto-generated .iml file under classpath.
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
