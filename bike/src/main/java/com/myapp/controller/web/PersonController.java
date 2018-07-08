package com.myapp.controller.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

import com.myapp.models.web.Person;


@Controller
@RequestMapping("/person")
public class PersonController {

	@GetMapping
	public String person(Model model) {
		model.addAttribute("person", new Person());
		return "person";
	}

	@PostMapping
	public String personSubmit(@Valid @ModelAttribute Person person, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
            return "person";
        }

		return "person-result";
	}
}
