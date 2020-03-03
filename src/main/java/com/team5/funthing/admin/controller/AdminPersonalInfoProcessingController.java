package com.team5.funthing.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.admin.model.vo.AdminPersonalInfoProcessingVO;
import com.team5.funthing.user.service.personalInfoProcessingService.DeletePersonalInfoProcessingService;
import com.team5.funthing.user.service.personalInfoProcessingService.GetPersonalInfoProcessingListService;
import com.team5.funthing.user.service.personalInfoProcessingService.GetPersonalInfoProcessingService;
import com.team5.funthing.user.service.personalInfoProcessingService.InsertPersonalInfoProcessingService;
import com.team5.funthing.user.service.personalInfoProcessingService.UpdatePersonalInfoProcessingService;

@Controller
public class AdminPersonalInfoProcessingController {

	@Autowired
	private GetPersonalInfoProcessingListService getPersonalInfoProcessingListService;
	@Autowired
	private GetPersonalInfoProcessingService getPersonalInfoProcessingService;
	@Autowired
	private UpdatePersonalInfoProcessingService updatePersonalInfoProcessingService;
	@Autowired
	private InsertPersonalInfoProcessingService insertPersonalInfoProcessingService;
	@Autowired
	private DeletePersonalInfoProcessingService deletePersonalInfoProcessingService;
	
	@RequestMapping("inputPersonalInfoProcessing.ado")
	public String inputPersonalInfoProcessing() {
		return "f-info-processing-input";
	}
	
	@RequestMapping("getPersonalInfoProcessing.ado")
	public String getPersonalInfoProcessing(AdminPersonalInfoProcessingVO vo, Model model) {
		
		model.addAttribute("personalInfoProcessing", getPersonalInfoProcessingService.getPersonalInfoProcessing(vo));
		
		return "f-info-processing-input";
	}
	
	@RequestMapping("insertPersonalInfoProcessing.ado")
	public String insertPersonalInfoProcessing(AdminPersonalInfoProcessingVO vo, Model model, HttpServletRequest request) {
		
		vo.setInfoContent(request.getParameter("editor1"));
		System.out.println(vo.toString());
		insertPersonalInfoProcessingService.insertPersonalInfoProcessing(vo);
		
		model.addAttribute("PersonalInfoProcessing", getPersonalInfoProcessingListService.getPersonalInfoProcessingList(vo));
		return "b-personalInfoProcessing-list";
	}
	
	@RequestMapping("updatePersonalInfoProcessing.ado")
	public String updatePersonalInfoProcessing(AdminPersonalInfoProcessingVO vo, Model model, HttpServletRequest request) {
		
		vo.setInfoContent(request.getParameter("editor1"));
		vo.setInfoNo(Integer.parseInt(request.getParameter("no")));
		updatePersonalInfoProcessingService.updatePersonalInfoProcessing(vo);
		
		model.addAttribute("PersonalInfoProcessing", getPersonalInfoProcessingListService.getPersonalInfoProcessingList(vo));
		return "b-personalInfoProcessing-list";
	}
	
	@RequestMapping("deletePersonalInfoProcessing.ado")
	public String deletePersonalInfoProcessing(AdminPersonalInfoProcessingVO vo, Model model) {
		
		deletePersonalInfoProcessingService.deletePersonalInfoProcessing(vo);
		
		model.addAttribute("PersonalInfoProcessing", getPersonalInfoProcessingListService.getPersonalInfoProcessingList(vo));
		return "b-personalInfoProcessing-list";
	}
	
}
