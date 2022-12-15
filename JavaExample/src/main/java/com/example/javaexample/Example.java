package com.example.javaexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {
	
	@GetMapping("/info")
	public String getInfo() {
		return "HelloWorld";
	}
	
}
