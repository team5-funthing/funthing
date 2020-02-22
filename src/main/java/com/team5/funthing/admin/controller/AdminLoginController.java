package com.team5.funthing.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.admin.model.vo.AdminMemberVO;
import com.team5.funthing.admin.service.adminLoginService.GetAdminPasswordService;

@Controller
public class AdminLoginController {

	@Autowired
	private GetAdminPasswordService getAdminPasswordService;
	
	@RequestMapping("adminLogin.ado")
	public String showLoginPage() {
		return "f-login";
	}
	
	@RequestMapping("LoginCheck.ado")
	public String LoginCheck(AdminMemberVO vo,HttpSession session,Model model) {
		
		AdminMemberVO aa = getAdminPasswordService.getAdminPassword(vo);
	   
		if(vo.getAdminPassword().equals(aa.getAdminPassword())) {
			session.setAttribute("adminSessionEmail", vo.getAdminId());
			return "forward:adminIndex.ado";
		}else {
			model.addAttribute("loginResult", "비밀번호가 일치하지 않습니다.");
			return "forward:adminLogin.ado";
		}
		
	}
	
	@RequestMapping("Logout.ado")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "f-login";
	}
	
}
