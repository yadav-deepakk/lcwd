package spring.mvc.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/hello")
	public String hello(Model model){
		model.addAttribute("user", "Deepak"); 
		return "hello"; 
	}
}
