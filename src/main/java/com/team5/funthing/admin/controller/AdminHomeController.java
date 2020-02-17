package com.team5.funthing.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminHomeController {

	@RequestMapping("admin.ado")
	public String showIndex() {
		System.out.println("메서드 실행");
		return "p-index";
	}
	
}
