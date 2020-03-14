package com.team5.funthing.user.controller;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("date.udo")
	public void getDate(){
		
		Date date = java.sql.Date.valueOf("2020-03-14");
		System.out.println(date.toString());
	}
	
}
