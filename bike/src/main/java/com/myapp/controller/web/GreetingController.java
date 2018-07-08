package com.myapp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import com.myapp.models.web.Greeting;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

	@GetMapping
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/form")
	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "greetingform";
	}

	@PostMapping("/form")
	public String greetingSubmit(@ModelAttribute Greeting greeting) {
		greeting.setContent(greeting.getContent() + " modified ");
		return "result";
	}

}
