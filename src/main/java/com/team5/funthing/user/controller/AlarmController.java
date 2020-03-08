package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team5.funthing.user.model.vo.AlarmVO;
import com.team5.funthing.user.service.AlarmService.GetNewestAlarmListService;
import com.team5.funthing.user.service.AlarmService.UpdateReadConfirmAlarmService;

@Controller
public class AlarmController {

	@Autowired
	UpdateReadConfirmAlarmService updateReadConfirmAlarmService;
	@Autowired
	GetNewestAlarmListService getNewestAlarmListService;
	
	
	@RequestMapping("alarmPaging.udo")
	public String alarmPaging(AlarmVO vo, HttpServletRequest request) {
		
		String requestUrl = null;
		vo.setReadConfirm('y');
		updateReadConfirmAlarmService.updateReadConfirmAlarm(vo);
		
		String AlarmType = vo.getAlarmType();
		System.out.println(AlarmType);
		
		if(AlarmType.contains("거부")) {
			requestUrl = "redirect:mypage.udo";
		}else if(AlarmType.contains("반려")) {
			requestUrl = "redirect:mypage.udo";
		}else if(AlarmType.contains("승인")) {
			requestUrl = "redirect:mypage.udo";
		}else if(AlarmType.contains("요청")) {
			requestUrl = "redirect:getProjectCheckList.ado";
		}else if(AlarmType.contains("결과")) {
			requestUrl = "redirect:mypage.udo";
		}
		
		return requestUrl;
	}
	
	@RequestMapping(value="getAdminAlarmList.ado", method=RequestMethod.POST)
	public String getAdminAlarmList(char status, String receiveId, AlarmVO vo, Model model) {
		
		System.out.println(status + " : " + receiveId);
		
		vo.setReadConfirm(status);
		vo.setReceiveId(receiveId);
		List<AlarmVO> AdminNewestAlarmList = getNewestAlarmListService.getNewestAlarmList(vo);
		
		System.out.println(AdminNewestAlarmList);
		
		model.addAttribute("AdminNewestAlarmList", AdminNewestAlarmList);
		
		return "/ajax/alarmList";
	}
	
	@RequestMapping(value="getUserAlarmList.udo", method=RequestMethod.POST)
	public String getUserAlarmList(String receiveId, char status, AlarmVO vo, Model model) {
		
		System.out.println(receiveId);
		System.out.println(status);
		
		vo.setReadConfirm(status);
		vo.setReceiveId(receiveId);
		List<AlarmVO> userNewestAlarmList = getNewestAlarmListService.getNewestAlarmList(vo);
		
		System.out.println(userNewestAlarmList);
		
		//ObjectMapper mapper = new ObjectMapper();
		//String listToJson = mapper.writeValueAsString(userNewestAlarmList);
		
		model.addAttribute("userNewestAlarmList", userNewestAlarmList);
		
		return "ajax/userAlarmList";
		
	}
	
	
	
}
