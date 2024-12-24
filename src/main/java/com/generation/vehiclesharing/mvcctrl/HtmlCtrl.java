package com.generation.vehiclesharing.mvcctrl;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlCtrl {

	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/prova")
	public String prova() {
		return "prova";
		
	}
	
	@GetMapping("/veicoli")
	public String veicoli() {
		return "veicolo";
		
	}
	
	@GetMapping("/prova2")
	public String prova2() {
		return "prova2";
	}
	
	
	
	
	
}
