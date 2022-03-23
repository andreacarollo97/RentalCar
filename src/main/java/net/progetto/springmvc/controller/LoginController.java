package net.progetto.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController 
{
	@GetMapping("/login")
	public String getLogin(Model model)
	{
		return "login";
	}

	@GetMapping("/logout")
	public String getLogout(Model model)
	{
		return "login";
	}

}
