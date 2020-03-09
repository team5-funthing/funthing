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


//ũ��������(=����Ŀ) ��� �ڷ� 
@Controller
public class CreatorStatisticsController { 
	
	@Autowired
	private GetAllProjectAndPaymentService getAllProjectAndPaymentService;
	@Autowired
	private GetProjectService getProjectService;
	@Autowired
	private GetFundingPaymentCountService getFundingPaymentCountService;
	

	
// ===================== �޼��� =======================	
	
	@RequestMapping(value="getSatistics.udo", method = RequestMethod.GET)
	public String getSatistics(@RequestParam int currentProjectNo,
											Model model, ProjectVO vo, PaymentReserveVO vo2 ) throws JsonProcessingException {
		
		vo.setProjectNo(currentProjectNo);
		model.addAttribute("currentProjectNo",currentProjectNo);
		//������Ʈ ������������ 
		ProjectVO projectInformation = getProjectService.getProject(vo);
		model.addAttribute("projectInformation",projectInformation);
		

		//�Ѱ����� ī��Ʈ ��������
		int count= getFundingPaymentCountService.getFundingPaymentCount(currentProjectNo);
		model.addAttribute("count", count);
		
		
		//��Ʈ�� ���� ������ �̾Ƴ��� 
		
		//���������������� 
		List<PaymentReserveVO> getAllProjectAndPayment = getAllProjectAndPaymentService.getAllProjectAndPayment(currentProjectNo);
		
		Gson gson = new Gson();
		JsonArray jArray = new JsonArray();
		
		Iterator<PaymentReserveVO> it = getAllProjectAndPayment.iterator();
		while(it.hasNext()) {
			PaymentReserveVO projectAndPayment = it.next();
			JsonObject object = new JsonObject();
			
			//getPaymentReserveDate DateŸ�� -> String���� ��ȯ �ϴ���
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
//		���������������� 
		List<PaymentReserveVO> getAllProjectAndPayment = getAllProjectAndPaymentService.getAllProjectAndPayment(currentProjectNo);
		model.addAttribute("getAllProjectAndPayment", getAllProjectAndPayment);
		
		int count= getFundingPaymentCountService.getFundingPaymentCount(currentProjectNo);
		model.addAttribute("count", count);
		
		return "p-test-statistics2";
	}
	
	
		

}
