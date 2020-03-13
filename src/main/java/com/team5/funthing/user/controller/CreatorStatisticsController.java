package com.team5.funthing.user.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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


//크리에이터(=메이커) 통계 자료 
@Controller
public class CreatorStatisticsController { 
	
	@Autowired
	private GetAllProjectAndPaymentService getAllProjectAndPaymentService;
	@Autowired
	private GetProjectService getProjectService;
	@Autowired
	private GetFundingPaymentCountService getFundingPaymentCountService;
	@Autowired
	private GetTodayFundingMoneyService getTodayFundingMoneyService;

	
// ===================== 메서드 =======================	
	
	@RequestMapping(value="getSatistics.udo", method = RequestMethod.GET)
	public String getSatistics(@RequestParam int currentProjectNo,
											Model model, ProjectVO vo, PaymentReserveVO vo2) throws JsonProcessingException {
		
		vo.setProjectNo(currentProjectNo);
		model.addAttribute("currentProjectNo",currentProjectNo);
		
		//총결제된 카운트 가져오기
		int count= getFundingPaymentCountService.getFundingPaymentCount(currentProjectNo);
		model.addAttribute("count", count);
		
		
		//결제정보 보내기 JSON으로
				Gson gson = new Gson();
				JsonArray jArray = new JsonArray();
//				Gson gson2 = new Gson();
//				JsonArray jArray2 = new JsonArray();
//				Gson gson3 = new Gson();
//				JsonArray jArray3 = new JsonArray();
				
		
				
		//프로젝트 정보가져오기 
		ProjectVO projectInformation = getProjectService.getProject(vo);
		model.addAttribute("projectInformation",projectInformation);
		
//		JsonObject object3 = new JsonObject();
		
	
		
		//금일판매금액 가져오기 
		List<PaymentReserveVO> getTodayFundingMoney = getTodayFundingMoneyService.getTodayFundingMoney(currentProjectNo);
		
//		Iterator<PaymentReserveVO> it2 = getTodayFundingMoney.iterator();
//		while(it2.hasNext()) {
//			PaymentReserveVO todayFundingMoney = it2.next();
//			JsonObject object2 = new JsonObject();
//			
//			String today = todayFundingMoney.getTodayDate();
//			int Data2 = todayFundingMoney.getSumFundingMoney();
//			
//			object2.addProperty("labelTodayDate", today);
//			object2.addProperty("dataFundingMoney2", Data2);
//			jArray2.add(object2);
//		}
//		
//		String json2 = gson.toJson(jArray2);
//		model.addAttribute("json2", json2);
		

		//결제정보가져오기 
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

		
		return "p-test-statistics";
	}
	
	
	
	
	@RequestMapping(value="getAllProjectAndPayment.udo", method = RequestMethod.GET)
	public String getAllProjectAndPayment(@RequestParam int currentProjectNo,
											Model model, ProjectVO vo, PaymentReserveVO vo2 ) {
		vo.setProjectNo(currentProjectNo);
//		결제정보가져오기 
		List<PaymentReserveVO> getAllProjectAndPayment = getAllProjectAndPaymentService.getAllProjectAndPayment(currentProjectNo);
		model.addAttribute("getAllProjectAndPayment", getAllProjectAndPayment);
		
		int count= getFundingPaymentCountService.getFundingPaymentCount(currentProjectNo);
		model.addAttribute("count", count);
		
		return "p-test-statistics2";
	}
	
	
		

}
