package com.library.DigitalLibrary.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/")
	public String welcomePage() {
		
		return "Welcome";
		
	}
	
	@GetMapping("/login")
	public String loginPage() {
		
		return "Login";
	}
	
	@GetMapping("/registration")
	public String registartionPage() {
		
		return "Registration";
		
	}

}
