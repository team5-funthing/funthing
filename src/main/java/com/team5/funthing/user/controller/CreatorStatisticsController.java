package com.team5.funthing.user.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.creatorStatisticsService.GetAllProjectAndPaymentService;
import com.team5.funthing.user.service.creatorStatisticsService.GetFundingPaymentCountService;
import com.team5.funthing.user.service.creatorStatisticsService.GetTodayFundingMoneyService;
import com.team5.funthing.user.service.projectService.GetProjectService;

@Controller
public class CreatorStatisticsController { 
	
	@Autowired
	private GetAllProjectAndPaymentService getAllProjectAndPaymentService;
	@Autowired
	private GetProjectService getProjectService;
	@Autowired
	private GetFundingPaymentCountService getFundingPaymentCountService;

	
	
	@RequestMapping(value="getSatistics.udo", method = RequestMethod.GET)
	public String getSatistics(@RequestParam int currentProjectNo,
											Model model, ProjectVO vo, PaymentReserveVO vo2) throws JsonProcessingException {
		
		vo.setProjectNo(currentProjectNo);
		model.addAttribute("currentProjectNo",currentProjectNo);
		

		
		int count= getFundingPaymentCountService.getFundingPaymentCount(currentProjectNo);
		model.addAttribute("count", count);
		
				Gson gson = new Gson();
				JsonArray jArray = new JsonArray();
				
		
		ProjectVO projectInformation = getProjectService.getProject(vo);
		model.addAttribute("projectInformation",projectInformation);
		

		List<PaymentReserveVO> getSumProjectAndPayment = getAllProjectAndPaymentService.getSumProjectAndPayment(currentProjectNo);
			
		Iterator<PaymentReserveVO> it = getSumProjectAndPayment.iterator();
		while(it.hasNext()) {
			PaymentReserveVO projectAndPayment = it.next();
			JsonObject object = new JsonObject();
	

			//getFundingMoney 
			String to = projectAndPayment.getSumDate();
			int Data = projectAndPayment.getSumFundingMoney();
			
			object.addProperty("labelDate", to);
			object.addProperty("dataFundingMoney", Data);
			jArray.add(object);
		}
		
		
		
		String json = gson.toJson(jArray);
		model.addAttribute("json", json);

		
		return "p-statistics";
	}
	
	
		

}
