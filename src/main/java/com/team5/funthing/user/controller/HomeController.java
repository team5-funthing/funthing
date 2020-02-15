package com.team5.funthing.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String startHome() {
		return "p-index";
	}
<<<<<<< HEAD
	
=======
>>>>>>> 193ce0181c850e546df0196c8f9f2b0411ccf7e0

}
