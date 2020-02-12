package com.team5.funthing.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.GetMemberService;

@Controller
@SessionAttributes("member")
public class MemberController {
	
	@Autowired
	private GetMemberService getMemberService;
	
	@RequestMapping("/getMember.udo")
	public String getMember(MemberVO vo, Model model) {
		System.out.println("MemberController ===> getMember 메서드 수행");
		
		vo.setEmail("test@naver.com");
		
		MemberVO test = getMemberService.getMember(vo);
		
		System.out.println(test.toString());
		
		return "p-index";
	}
	
	@RequestMapping("/*.udo")
	public String showindex() {
		return "p-index";
	}
	
	
	
}
