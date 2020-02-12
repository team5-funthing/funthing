package com.team5.funthing.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.GetMemberService;

@Controller
@SessionAttributes("member")
public class MemberController {
	
	@Autowired
	private GetMemberService getMemberService;
	
	@RequestMapping("/getmember.udo")
	public String getMember(MemberVO vo, Model model) {
		
		getMemberService.getMember(vo);
		
		return "#";
	}
	
	@RequestMapping("/*.udo")
	public String showindex() {
		return "p-index";
	}
	
	
	
}
