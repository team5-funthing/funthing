package com.team5.funthing.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.user.model.vo.AlarmVO;
import com.team5.funthing.user.service.AlarmService.UpdateReadConfirmAlarmService;

@Controller
public class AlarmController {

	@Autowired
	UpdateReadConfirmAlarmService updateReadConfirmAlarmService;
	
	@RequestMapping("alarmPaging.udo")
	public String alarmPaging(AlarmVO vo, HttpServletRequest request) {
		
		String requestUrl = null;
		vo.setReadConfirm('y');
		updateReadConfirmAlarmService.updateReadConfirmAlarm(vo);
		
		if(vo.getAlarmType().contains("½É»ç")) {
			requestUrl = "mypage.udo";
		}
		
		return requestUrl;
	}
	
}
