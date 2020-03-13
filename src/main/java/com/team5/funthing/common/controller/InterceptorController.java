package com.team5.funthing.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

	@RequestMapping("needLogin.udo")
	public String needLogin() {
		return "needLogin";
	}
	
	@RequestMapping("adminNeedLogin.ado")
	public String adminLoginPage() {
		System.out.println("페이지 이동 전입니다.");
		return "adminNeedLoginPage";
	}
	
}
