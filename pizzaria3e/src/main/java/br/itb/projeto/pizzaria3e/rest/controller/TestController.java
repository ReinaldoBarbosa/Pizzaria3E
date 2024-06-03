package br.itb.projeto.pizzaria3e.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
	
	@GetMapping("test")
	public String getTest() {
		return "TEIGAAAA!";
	}
	
	// end point
	@GetMapping("message")
	public String getMessage() {
		return "hahahahaa";
	}
	
	@GetMapping("bom-dia")
	public String getOutra() {
		return "Bom dia\r\n"
				+ "O Sol já nasceu lá na fazendinha\r\n"
				+ "Acorda o bezerro e a vaquinha\r\n"
				+ "Que já cocoricou dona galinha\r\n"
				+ "Levanta\r\n"
				+ "Que o cavalinho já pulou da cama\r\n"
				+ "Que o pintinho tirou seu pijama\r\n"
				+ "E o porquinho já caiu na lama";
	}

}
