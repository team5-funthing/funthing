package com.team5.funthing.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.admin.service.adminMemberManagementService.GetMemberJoinMakerService;
import com.team5.funthing.admin.service.adminMemberManagementService.GetMemberListService;
import com.team5.funthing.admin.service.adminMemberManagementService.UpdateMakerMemberGradeService;
import com.team5.funthing.user.model.vo.MemberVO;

@Controller
public class AdminMemberManagementController {
	
	@Autowired
	private GetMemberListService getMemberListService;
	@Autowired
	private UpdateMakerMemberGradeService updateMakerMemberGradeService;
	@Autowired
	private GetMemberJoinMakerService getMemberJoinMakerService;
	
//	private List<MemberVO> memberList;
	
	@RequestMapping("getMemberList.ado")
	public String getMemberList(MemberVO vo, Model model){
		//memberList = getMemberListService.getMemberList(vo);
		 List<MemberVO> memberList = getMemberJoinMakerService.getMemberJoinMaker(vo);
		
		model.addAttribute("memberList",memberList);
		return "b-member-list";
	}
		
}
