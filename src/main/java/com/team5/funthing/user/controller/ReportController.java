package com.team5.funthing.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.ReportVO;
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
	
	@RequestMapping("insertReport.udo")
	public String insertReport(RedirectAttributes redirectAttribute, ReportVO vo, Model model) {
		insertReportService.insertReport(vo);
		
		ProjectVO pvo = new ProjectVO();
		pvo.setProjectNo(vo.getProjectNo());
		pvo = getProjectService.getProject(pvo);
		
		redirectAttribute.addAttribute("projectNo", vo.getProjectNo());
		return "redirect:projectDetails.udo";
	}
	
	@RequestMapping("getReport.ado")
	public String getReport(ReportVO vo, ProjectVO pvo, Model model) {
		
		ReportVO report = getReportService.getReport(vo);

		pvo.setProjectNo(report.getProjectNo());
		ProjectVO project = getProjectService.getProject(pvo);
	
		model.addAttribute("projectTitle", project.getProjectTitle());
		model.addAttribute("report", report);
		return "p-report-detail";
	}
	
	
	
}
