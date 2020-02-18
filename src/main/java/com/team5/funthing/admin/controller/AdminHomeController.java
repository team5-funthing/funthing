package com.team5.funthing.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.admin.model.vo.AdminNoticeBoardVO;
import com.team5.funthing.admin.service.adminNoticeBoardService.GetAdminNoticeBoardListService;

@Controller
public class AdminHomeController {

	@Autowired
	GetAdminNoticeBoardListService getAdminNoticeBoardListService;
	
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
		return "b-customerService";
	}
	
	@RequestMapping("termsOfService.ado")
	public String showTermsOfService() {
		return "f-clause-input";
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

}
