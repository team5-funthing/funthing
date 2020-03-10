package com.team5.funthing.admin.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.admin.model.vo.AdminStatisticsVO;
import com.team5.funthing.admin.service.adminStatisticsService.GetFundingMoneyPerMonthService;
import com.team5.funthing.admin.service.adminStatisticsService.GetProjectSuccessRatioPerMonthService;
import com.team5.funthing.admin.service.adminStatisticsService.GetProjectSuccessRatioPerYearService;

@Controller
public class AdminStatisticsController {

	@Autowired
	GetProjectSuccessRatioPerMonthService perMonth;
	@Autowired
	GetProjectSuccessRatioPerYearService perYear;
	@Autowired
	GetFundingMoneyPerMonthService fmpm;
	
	
	@RequestMapping(value ="statisticsManagement.ado",method=RequestMethod.GET)
	public String showStatisticsManagement(AdminStatisticsVO vo,Model model) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR)-2000;
		String parse = Integer.toString(year);
		vo.setYearr(parse);
		model.addAttribute("fundingMoneyPerMonth",fmpm.getFundingMoneyPerMonth(vo));
		
		model.addAttribute("successRatio",perYear.getProjectSuccessRatioPerYear(vo));
	
		model.addAttribute("successRatioMonth",perMonth.getProjectSuccessRatioPerMonth(vo));

		return "p-statistics";
	}

	
	@RequestMapping(value ="statisticsManagement.ado",method=RequestMethod.POST)
	public String showStatisticsManagement2(AdminStatisticsVO vo,Model model,String year) {
		System.out.println(year);
	    vo.setYearr(year);
	    model.addAttribute("fundingMoneyPerMonth",fmpm.getFundingMoneyPerMonth(vo));
	    model.addAttribute("successRatio",perYear.getProjectSuccessRatioPerYear(vo));
	    model.addAttribute("successRatioMonth",perMonth.getProjectSuccessRatioPerMonth(vo));
		return "p-statistics";
	}
	
	@RequestMapping("t1.ado")
	public String t1() {
		return "/sample/index";
	}
	
	@RequestMapping("t2.ado")
	public String t2() {
		return "sample/info_processing_input";
	}
}
