package com.example.RandomMagic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RandomMagicApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomMagicApplication.class, args);
	}
// Root
	@GetMapping("/")
	public String apiRoot() {
		return "Text on the page";
	}

}
