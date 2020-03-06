package com.team5.funthing.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminStatisticsController {

	
	@RequestMapping("test.ado")
	public String testing() {
		return "test";
	}
}
