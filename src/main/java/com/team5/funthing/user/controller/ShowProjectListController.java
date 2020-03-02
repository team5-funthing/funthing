package com.team5.funthing.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.showProjectListService.GetAllDeadLineListService;
import com.team5.funthing.user.service.showProjectListService.GetAllLikeCountListService;
import com.team5.funthing.user.service.showProjectListService.GetAllNewProjectListService;
import com.team5.funthing.user.service.showProjectListService.GetShowCategorySubListService;

@Controller
public class ShowProjectListController {
	

	@Autowired
	private GetShowCategorySubListService getShowCategorySubListService;
	@Autowired
	private GetAllLikeCountListService getAllLikeCountListService;
	@Autowired
	private GetAllDeadLineListService getAllDeadLineListService;
	@Autowired
	private GetAllNewProjectListService getAllNewProjectListService;

	
//	=======================================카테고리 선택시 보여주는 리스트=========================================
	
	@RequestMapping(value="getShowCategoryList.udo", method = RequestMethod.GET)
	public String getShowCategoryList(ProjectVO vo, Model model) {
		
		System.out.println(vo.toString());
		
	
			System.out.println("카테고리 기본값 아무것도 설정안했을때 보여주기 ");
			List<ProjectVO> getAllFundingProjectList = getShowCategorySubListService.getShowCategorySubList(vo);
			model.addAttribute("getAllFundingProjectList", getAllFundingProjectList);
			
		
		
		
		return "p-project-list";
	}
	

	
//	=======================================상단 팝업창 인기프로젝트 선택시 보여주는 리스트=========================================	
	
	@RequestMapping(value="getAllLikeCountList.udo", method = RequestMethod.GET)
	public String getAllLikeCountList(ProjectVO vo, Model model) {
		
		List<ProjectVO> getAllFundingProjectList = getAllLikeCountListService.getAllLikeCountList(vo);
		model.addAttribute("getAllFundingProjectList",getAllFundingProjectList);
		
		return "p-project-list";
		
		
	}
	
//	=======================================상단 팝업창 마감임박프로젝트 선택시 보여주는 리스트=========================================
	
	@RequestMapping(value="getDeadLineList.udo", method = RequestMethod.GET)
	public String getDeadLineList(ProjectVO vo, Model model) {
		
		List<ProjectVO> getAllFundingProjectList = getAllDeadLineListService.getAllDeadLineList(vo);
		model.addAttribute("getAllFundingProjectList",getAllFundingProjectList);
		
		return "p-project-list";
		
		
	}
	
//	=======================================상단 팝업창 신규프로젝트 선택시 보여주는 리스트=========================================
	
	@RequestMapping(value="getAllNewProjectList.udo", method = RequestMethod.GET)
	public String getAllNewProjectList(ProjectVO vo, Model model) {
		
		List<ProjectVO> getAllFundingProjectList = getAllNewProjectListService.getAllNewProjectList(vo);
		model.addAttribute("getAllFundingProjectList",getAllFundingProjectList);
		
		return "p-project-list";
		
		
	}
	
	

}
