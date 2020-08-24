package org.com.javasheets.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
	
	@RequestMapping("/")
	String home() {
		return "Hello World";
	}
}
