package com.team5.funthing.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team5.funthing.user.model.vo.AlarmVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.ReportVO;
import com.team5.funthing.user.service.AlarmService.InsertProjectReportAlarmService;
import com.team5.funthing.user.service.projectService.GetProjectService;
import com.team5.funthing.user.service.reportService.GetReportService;
import com.team5.funthing.user.service.reportService.InsertReportService;

@Controller
public class ReportController {
	
	//report Service
	@Autowired
	private InsertReportService insertReportService;
	@Autowired
	private GetReportService getReportService;
	
	//project Service
	@Autowired
	private GetProjectService getProjectService;
	
	//alarm Service
	@Autowired
	private InsertProjectReportAlarmService insertProjectReportAlarmService;
	
	@RequestMapping("insertReport.udo")
	public String insertReport(RedirectAttributes redirectAttribute, AlarmVO avo, ReportVO vo, Model model) {
		insertReportService.insertReport(vo);
		
		ProjectVO pvo = new ProjectVO();
		pvo.setProjectNo(vo.getProjectNo());
		pvo = getProjectService.getProject(pvo);
		
		avo.setReadConfirm('n');
		avo.setProjectNo(pvo.getProjectNo());
		avo.setReceiveId("admin@funthing.com");
		avo.setDetailAlarmType("신고");
		avo.setAlarmType(pvo.getProjectTitle() + "프로젝트 신고");
		insertProjectReportAlarmService.insertProjectReportAlarm(avo);
		
		redirectAttribute.addAttribute("projectNo", vo.getProjectNo());
		return "redirect:projectDetails.udo";
	}
	
	@RequestMapping("getReport.ado")
	public String getReport(ReportVO vo, Model model) {

		model.addAttribute("report", getReportService.getReport(vo));
		return "p-report-detail";
	}
	
	
	
}
