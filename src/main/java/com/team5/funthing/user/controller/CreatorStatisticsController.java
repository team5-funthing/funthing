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


//ũ��������(=����Ŀ) ��� �ڷ� 
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

	
// ===================== �޼��� =======================	
	
	@RequestMapping(value="getSatistics.udo", method = RequestMethod.GET)
	public String getSatistics(@RequestParam int currentProjectNo,
											Model model, ProjectVO vo, PaymentReserveVO vo2) throws JsonProcessingException {
		
		vo.setProjectNo(currentProjectNo);
		model.addAttribute("currentProjectNo",currentProjectNo);
		
		//�Ѱ����� ī��Ʈ ��������
		int count= getFundingPaymentCountService.getFundingPaymentCount(currentProjectNo);
		model.addAttribute("count", count);
		
		
		//�������� ������ JSON����
				Gson gson = new Gson();
				JsonArray jArray = new JsonArray();
//				Gson gson2 = new Gson();
//				JsonArray jArray2 = new JsonArray();
//				Gson gson3 = new Gson();
//				JsonArray jArray3 = new JsonArray();
				
		
				
		//������Ʈ ������������ 
		ProjectVO projectInformation = getProjectService.getProject(vo);
		model.addAttribute("projectInformation",projectInformation);
		
//		JsonObject object3 = new JsonObject();
		
	
		
		//�����Ǹűݾ� �������� 
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
		

		//���������������� 
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
//		���������������� 
		List<PaymentReserveVO> getAllProjectAndPayment = getAllProjectAndPaymentService.getAllProjectAndPayment(currentProjectNo);
		model.addAttribute("getAllProjectAndPayment", getAllProjectAndPayment);
		
		int count= getFundingPaymentCountService.getFundingPaymentCount(currentProjectNo);
		model.addAttribute("count", count);
		
		return "p-test-statistics2";
	}
	
	
		

}
