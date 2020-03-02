package com.team5.funthing.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.admin.model.vo.AdminNoticeBoardVO;
import com.team5.funthing.admin.service.adminNoticeBoardService.GetAdminNoticeBoardListService;
import com.team5.funthing.admin.service.adminProjectCheckService.GetProjectCheckListService;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.TosVO;
import com.team5.funthing.user.service.TosService.GetTosListService;

@Controller
public class AdminHomeController {

	@Autowired
	GetAdminNoticeBoardListService getAdminNoticeBoardListService;
	@Autowired
	GetProjectCheckListService getProjectCheckListService;
	@Autowired
	GetTosListService getTosListService;
	
	@RequestMapping("adminIndex.ado")
	public String showIndex() {
		return "p-index";
	}
	
	@RequestMapping("projectManagement.ado")
	public String showProjectManagement() {
		return "b-project-list";
	}
	
	@RequestMapping("memberManagement.ado")
	public String showMemberManagement() {
		return "b-member-list";
	}
	
	@RequestMapping("statisticsManagement.ado")
	public String showStatisticsManagement() {
		return "p-statistics";
	}
	
	@RequestMapping("customerService.ado")
	public String showCustomerServiceBoard() {
		return "redirect:getAdminCSBoardList.ado";
	}
	
	@RequestMapping("termsOfService.ado")
	public String showTermsOfService(TosVO vo, Model model) {
		List<TosVO> getTosList = getTosListService.getTosList(vo);
		
		model.addAttribute("TosList", getTosList);
		return "b-tos-list";
	}
	
	@RequestMapping("adminNoticeInput.ado")
	public String showInputNotice(AdminNoticeBoardVO vo, Model model) {
		List<AdminNoticeBoardVO> entireBoardList = getAdminNoticeBoardListService.getNoticeBoardList(vo);
		
		model.addAttribute("entireBoardList", entireBoardList);
		return "b-notice-list";
	}
	
	@RequestMapping("infoProcessingInput.ado")
	public String showInputInfoProcessing() {
		return "f-info-processing-input";
	}

	@RequestMapping("getProjectCheckList.ado")
	public String getProjectCheckList(ProjectVO vo,Model model) {
		
		List<ProjectVO> projectCheckList = getProjectCheckListService.getProjectCheckList(vo);
		System.out.println(projectCheckList.toString());
		
		model.addAttribute("projectCheckList",projectCheckList);
		return "b-project-check-list";
	}
	
	
}
