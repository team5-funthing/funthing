package com.team5.funthing.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.admin.service.adminMemberManagementService.GetMemberJoinMakerDetailService;
import com.team5.funthing.admin.service.adminMemberManagementService.GetMemberJoinMakerService;
import com.team5.funthing.admin.service.adminMemberManagementService.UpdateMakerMemberGradeService;
import com.team5.funthing.user.model.vo.CreatorVO;
import com.team5.funthing.user.model.vo.MemberVO;

@Controller
public class AdminMemberManagementController {
	

	@Autowired
	private UpdateMakerMemberGradeService updateMakerMemberGradeService;
	@Autowired
	private GetMemberJoinMakerService getMemberJoinMakerService;
	@Autowired
	private GetMemberJoinMakerDetailService getMemberJoinMakerDetailService;
	
	private List<MemberVO> memberList;
	private MemberVO member;
	
	
	@RequestMapping("getMemberList.ado")
	public String getMemberList(MemberVO vo, Model model){

		memberList = getMemberJoinMakerService.getMemberJoinMaker(vo);
	
		model.addAttribute("memberList",memberList);
		return "b-member-list";
	}
	
	@RequestMapping("getMember.ado")
	public String getMember(MemberVO vo, Model model){
		

		member = getMemberJoinMakerDetailService.GetMemberJoinMakerDetail(vo);
		String lv = member.getCreator().getLv();
		
		model.addAttribute("member",member);
		model.addAttribute("lv",lv);
		return "p-member-detail";
	}
	
	@RequestMapping("updateMakerMemberGrade.ado")
	public String updateMakerMemberGrade(CreatorVO vo, Model model){
		
		if(vo.getLv() == null) {
			
		}
		if(vo.getLv() != null) {
			
			updateMakerMemberGradeService.UpdateMakerMemberGrade(vo);
		}
		return "redirect:getMemberList.ado";
	}
		
}
