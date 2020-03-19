package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String alarmPaging(AlarmVO avo, HttpServletRequest request, HttpSession session) {
		
		System.out.println(avo.toString());
		
		String requestUrl = null;
		
		String AlarmType = avo.getAlarmType();
		System.out.println(AlarmType);
		
		if(AlarmType.contains("�ź�")) {
			requestUrl = "redirect:mypage.udo";
		}else if(AlarmType.contains("�ݷ�")) {
			requestUrl = "redirect:mypage.udo";
		}else if(AlarmType.contains("����")) {
			requestUrl = "redirect:mypage.udo";
		}else if(AlarmType.contains("��û")) {
			requestUrl = "redirect:getProjectCheckList.ado";
		}else if(AlarmType.contains("���")) {
			requestUrl = "redirect:mypage.udo";
		}else if(AlarmType.contains("�Ű�")) {
			requestUrl = "redirect:projectReportCheck.ado";
		}
		
		avo.setReadConfirm('y');
		updateReadConfirmAlarmService.updateReadConfirmAlarm(avo);
		
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
