package com.team5.funthing.admin.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.admin.model.vo.AdminCategoryVO;
import com.team5.funthing.admin.model.vo.AdminMainViewVO;
import com.team5.funthing.admin.model.vo.AdminNoticeBoardVO;
import com.team5.funthing.admin.model.vo.AdminPersonalInfoProcessingVO;
import com.team5.funthing.admin.model.vo.AdminRegisterTosVO;
import com.team5.funthing.admin.model.vo.AdminStatisticsVO;
import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.service.adminCategoryService.GetCategoryListService;
import com.team5.funthing.admin.service.adminMainViewService.GetMainViewProjectFundingListService;
import com.team5.funthing.admin.service.adminMainViewService.GetMainViewProjectStatusListService;
import com.team5.funthing.admin.service.adminNoticeBoardService.GetAdminNoticeBoardListService;
import com.team5.funthing.admin.service.adminProjectCheckService.GetProjectCheckListService;
import com.team5.funthing.admin.service.adminRegisterTosService.GetRegisterTosListService;
import com.team5.funthing.admin.service.adminStatisticsService.GetFundingMoneyPerMonthService;
import com.team5.funthing.admin.service.adminStatisticsService.GetProjectSuccessRatioTotalYearService;
import com.team5.funthing.admin.service.userMainImageChangeService.GetUserMainImageListService;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.TosVO;
import com.team5.funthing.user.service.TosService.GetTosListService;
import com.team5.funthing.user.service.personalInfoProcessingService.GetPersonalInfoProcessingListService;
import com.team5.funthing.user.service.projectService.GetAllFundingProjectListService;
import com.team5.funthing.user.service.userMainImageChangeService.GetUserMainImageChangeListService;


@Controller
public class AdminHomeController {

	@Autowired
	GetAdminNoticeBoardListService getAdminNoticeBoardListService;
	@Autowired
	GetProjectCheckListService getProjectCheckListService;
  
	@Autowired 
	GetUserMainImageChangeListService getUserMainImageChangeListService;
	@Autowired
	GetAllFundingProjectListService getAllFundingProjectListService;
  
	@Autowired
	GetTosListService getTosListService;
	@Autowired
	GetPersonalInfoProcessingListService getPersonalInfoProcessingListService;
	@Autowired
	GetRegisterTosListService getRegisterTosListService;
	@Autowired
	GetCategoryListService getCategoryListService;

	@Autowired
	GetUserMainImageListService getUserMainImageListService;
	
	@Autowired
	GetMainViewProjectStatusListService getMainViewProjectStatusListService;
	@Autowired
	GetMainViewProjectFundingListService getMainViewProjectFundingListService;

	@Autowired
	GetProjectSuccessRatioTotalYearService getProjectSuccessRatioTotalYearService;
	@Autowired
	GetFundingMoneyPerMonthService getFundingMoneyPerMonthService;
	
	
	@RequestMapping("adminIndex.ado")
	public String showIndex(AdminStatisticsVO vo, AdminMainViewVO vo2,Model model) {
		model.addAttribute("totalSuccess",getProjectSuccessRatioTotalYearService.getProjectSuccessRatioTotalYear(vo));
		Calendar cal = Calendar.getInstance();// 횉철�챌 쩔짭쨉쨉 짹쨍횉횕짹창.
		int year = cal.get(cal.YEAR)-2000;
		String parse = Integer.toString(year);
		vo.setYearr(parse);
		model.addAttribute("fundingMoney",getFundingMoneyPerMonthService.getFundingMoneyPerMonth(vo));
		
		vo2.setStatus('w');
		List<ProjectVO> statusWList = getMainViewProjectStatusListService.getMainViewProjectStatusList(vo2);
		int statusWListCount = statusWList.size();
	
		vo2.setFunding("y");
		List<ProjectVO> fundingYList = getMainViewProjectFundingListService.getMainViewProjectFundingList(vo2);
		System.out.println("fundingYList:"+fundingYList);
		int fundingYListCount = fundingYList.size();
		System.out.println("fundingYListCount:"+fundingYListCount);
		
		model.addAttribute("fundingYListCount",fundingYListCount);
		model.addAttribute("statusWListCount",statusWListCount);
		
		return "p-index";

	}
	
	@RequestMapping("projectCategoryManagement.ado")
	public String showProjectCategoryManagement(AdminCategoryVO vo, Model model) {
		
		List<AdminCategoryVO> CategoryList = getCategoryListService.getCategoryList(vo);
		model.addAttribute("CategoryList", CategoryList);
		
		return "f-category-management";
	}
	
	@RequestMapping("memberManagement.ado")
	public String showMemberManagement() {
		return "b-member-list";
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
	public String showInputInfoProcessing(AdminPersonalInfoProcessingVO vo, Model model) {
		
		model.addAttribute("PersonalInfoProcessing", getPersonalInfoProcessingListService.getPersonalInfoProcessingList(vo));
		
		return "b-personalInfoProcessing-list";
	}
	
	@RequestMapping("registerTos.ado")
	public String showRegisterTos(AdminRegisterTosVO vo, Model model) {
		
		model.addAttribute("RegisterTosList", getRegisterTosListService.getRegisterTosList(vo));
		
		return "b-regitos-list";
	}

	@RequestMapping("getProjectCheckList.ado")
	public String getProjectCheckList(ProjectVO vo,Model model) {
		
		List<ProjectVO> projectCheckList = getProjectCheckListService.getProjectCheckList(vo);
		System.out.println(projectCheckList.toString());
		
		model.addAttribute("projectCheckList",projectCheckList);
		return "b-project-check-list";
	}
	
	@RequestMapping("userMainImageChangeForm.ado")
	public String userMainImageForm(AdminUserMainImageChangeVO vo, Model model) {
		List<AdminUserMainImageChangeVO> userMainImageList =getUserMainImageListService.getUserMainImageList();
		
		model.addAttribute("userMainImageList",userMainImageList);
		return "f-usermainimage-input";
	}
		
}
