package com.team5.funthing.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.user.model.vo.ReportVO;
import com.team5.funthing.user.service.reportService.InsertReportService;

@Controller
public class ReportController {
	
	@Autowired
	private InsertReportService insertReportService;
	
	@RequestMapping("insertReportForm.udo")
	public String insertReportForm() {
		
		return "report";
	}
	
	@RequestMapping("insertReport.udo")
	public String insertReport(ReportVO vo) {
		insertReportService.insertReport(vo);
		return "p-report-input";
	}
	
	
	
}
