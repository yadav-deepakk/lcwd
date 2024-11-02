package spring.mvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/hello")
	public String hello(Model model){
		model.addAttribute("user", "Deepak"); 
		return "hello"; 
	}
}
