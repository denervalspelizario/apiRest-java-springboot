package br.com.denerplz.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Controladores
@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting") // rota
	
	public Greeting greeting(
			
			// parametro opicional name e valor default(padrão) será
			@RequestParam(value = "name", defaultValue = "PaPa Pizza") 
			String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}

