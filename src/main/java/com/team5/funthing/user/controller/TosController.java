package com.team5.funthing.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.admin.model.vo.AdminPersonalInfoProcessingVO;
import com.team5.funthing.user.model.vo.TosVO;
import com.team5.funthing.user.service.TosService.GetTosListService;
import com.team5.funthing.user.service.personalInfoProcessingService.GetPersonalInfoProcessingListService;

@Controller
public class TosController {

	@Autowired
	private GetTosListService getTosListService;
	@Autowired
	private GetPersonalInfoProcessingListService getPersonalInfoProcessingListService;
	
	@RequestMapping("getRegisterTos.udo")
	public void getTosListInRegister() {
		
	}
	
	@RequestMapping(value="getServiceTos.udo", method=RequestMethod.POST)
	public String getServiceTosListInRegister(TosVO vo, Model model) {
		
		List<TosVO> getTosList = getTosListService.getTosList(vo);
		model.addAttribute("TosList", getTosList);
		
		return "/ajax/getTosListInRegister";
	}
	
	@RequestMapping(value="getPersonalInfo.udo", method=RequestMethod.POST)
	public String getPersonalInfoListInRegister(AdminPersonalInfoProcessingVO vo, Model model) {
		
		List<AdminPersonalInfoProcessingVO> getPersonalInfoList = getPersonalInfoProcessingListService.getPersonalInfoProcessingList(vo);
		System.out.println(getPersonalInfoList.toString());
		model.addAttribute("ProcessingList", getPersonalInfoList);
		
		return "/ajax/getProcessingListInRegister";
	}
	
}
