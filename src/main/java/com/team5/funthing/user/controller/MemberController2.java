package com.team5.funthing.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.memberService.DeleteMemberService;
import com.team5.funthing.user.service.memberService.UpdateMemberService;

@Controller
public class MemberController2 {

	@Autowired
	UpdateMemberService updateMemberService;
	@Autowired
	DeleteMemberService deleteMemberService;
	
	@RequestMapping(value = "updateMember.udo",method= RequestMethod.GET)
		public String updateProfile(MemberVO vo,HttpSession session) {
		vo.setEmail((String)session.getAttribute("memberSessionEmail"));
		updateMemberService.updateMember(vo);
		return "p-index";
	}
	
	
	@RequestMapping(value="deleteCheckMember.udo",method=RequestMethod.GET)
	public String deleteMember(MemberVO vo,HttpSession session) {
		
		return "삭제 확인(아이디 패스워드입력요구) 페이지로 이동.";
	}
	
	
	
}
