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
	public String LoginCheck(AlarmVO avo, AdminMemberVO vo,HttpSession session,Model model) {
		String getPassword = null;
		System.out.println("�α��� ����");
		if(getAdminPasswordService.getAdminPassword(vo)==null) {
			model.addAttribute("loginResult", "��ϵ��� ���� ȸ���Դϴ�.");
		}else {
			getPassword = getAdminPasswordService.getAdminPassword(vo);
			if(getPassword.equals(vo.getAdminPassword())) {
				session.setAttribute("adminSessionEmail", vo.getAdminId());
				
				avo.setReadConfirm('n');
				avo.setReceiveId(vo.getAdminId());
				if(getNewestAlarmListService.getNewestAlarmList(avo).isEmpty()) {
					System.out.println(getNewestAlarmListService.getNewestAlarmList(avo));
					System.out.println("Aaaaaa");
					session.setAttribute("alarmContain", "�˶� ����");
				}else {
					System.out.println("bbbbb");
					session.setAttribute("alarmContain", "�˶� ����");
				}
//				System.out.println(getNewestAlarmListService.getNewestAlarmList(avo));
				return "redirect:adminIndex.ado";
			}else {
				model.addAttribute("loginResult", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
		}
		
		System.out.println("�Է��� admin ���� : " + vo.toString());
		System.out.println("���� admin ��й�ȣ : " + getPassword);
		System.out.println(model.getAttribute("loginResult"));
		System.out.println("�α��� �� ���̵� : " + session.getAttribute("adminSessionEmail"));
		return "forward:adminLogin.ado";
	}
	
	@RequestMapping("Logout.ado")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "f-login";
	}
	
}
