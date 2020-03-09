package com.team5.funthing.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.admin.model.vo.AdminMemberVO;
import com.team5.funthing.admin.service.adminLoginService.GetAdminPasswordService;
import com.team5.funthing.user.model.vo.AlarmVO;
import com.team5.funthing.user.service.AlarmService.GetNewestAlarmListService;

@Controller
public class AdminLoginController {

	@Autowired
	private GetAdminPasswordService getAdminPasswordService;
	@Autowired
	private GetNewestAlarmListService getNewestAlarmListService;
	
	@RequestMapping("adminLogin.ado")
	public String showLoginPage() {
		return "f-login";
	}
	
	@RequestMapping("LoginCheck.ado")
	public String LoginCheck(AdminMemberVO vo,HttpSession session,Model model) {
		String getPassword = null;
		System.out.println("로그인 시작");
		if(getAdminPasswordService.getAdminPassword(vo)==null) {
			model.addAttribute("loginResult", "등록되지 않은 회원입니다.");
		}else {
			getPassword = getAdminPasswordService.getAdminPassword(vo);
			if(getPassword.equals(vo.getAdminPassword())) {
				session.setAttribute("adminSessionEmail", vo.getAdminId());
				return "p-index";
			}else {
				model.addAttribute("loginResult", "비밀번호가 일치하지 않습니다.");
			}
		}
		
		System.out.println("입력한 admin 정보 : " + vo.toString());
		System.out.println("얻어온 admin 비밀번호 : " + getPassword);
		System.out.println(model.getAttribute("loginResult"));
		System.out.println("로그인 한 아이디 : " + session.getAttribute("adminSessionEmail"));
		return "forward:adminLogin.ado";
	}
	
	@RequestMapping("Logout.ado")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "f-login";
	}
	
}
