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
	

	
// ===================== 메서드 =======================	
	
	@RequestMapping(value="getSatistics.udo", method = RequestMethod.GET)
	public String getSatistics(@RequestParam int currentProjectNo,
											Model model, ProjectVO vo, PaymentReserveVO vo2 ) throws JsonProcessingException {
		
		vo.setProjectNo(currentProjectNo);
		model.addAttribute("currentProjectNo",currentProjectNo);
		//프로젝트 정보가져오기 
		ProjectVO projectInformation = getProjectService.getProject(vo);
		model.addAttribute("projectInformation",projectInformation);
		

		//총결제된 카운트 가져오기
		int count= getFundingPaymentCountService.getFundingPaymentCount(currentProjectNo);
		model.addAttribute("count", count);
		
		
		//차트에 들어가는 데이터 뽑아내기 
		
		//결제정보가져오기 
		List<PaymentReserveVO> getAllProjectAndPayment = getAllProjectAndPaymentService.getAllProjectAndPayment(currentProjectNo);
		
		Gson gson = new Gson();
		JsonArray jArray = new JsonArray();
		
		Iterator<PaymentReserveVO> it = getAllProjectAndPayment.iterator();
		while(it.hasNext()) {
			PaymentReserveVO projectAndPayment = it.next();
			JsonObject object = new JsonObject();
			
			//getPaymentReserveDate Date타입 -> String으로 변환 하는중
			Date from = projectAndPayment.getPaymentReserveDate();
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			String to = transFormat.format(from);
			
			//getFundingMoney 
			int Data = projectAndPayment.getFundingMoney();
			
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
