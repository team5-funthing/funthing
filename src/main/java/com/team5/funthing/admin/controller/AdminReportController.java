package com.team5.funthing.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team5.funthing.admin.service.adminReportService.GetReportListService;
import com.team5.funthing.admin.service.adminReportService.GetReportService;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.ReportVO;
import com.team5.funthing.user.service.projectService.GetProjectService;

@Controller
public class AdminReportController {
	
	@Autowired
	private GetReportListService getReportListService;
	@Autowired
	private GetReportService getReportService;
	@Autowired
	private GetProjectService getProjectService;
	
	private List<ReportVO> reportList;
	private ReportVO report;
	
	private ProjectVO project;
	
	private ProjectVO projectVO;
	
	
	@RequestMapping("getReportList.ado")
	public ModelAndView getReportList(ReportVO vo){
		
		reportList = getReportListService.getReportList(vo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("reportList",reportList);
		mav.setViewName("b-report-list");
		return mav; 
	}
	
	@RequestMapping("getReport.ado")
	public ModelAndView getReport(ReportVO vo){
		
		report = getReportService.getReport(vo);
		
		project = new ProjectVO();
		project.setProjectNo(report.getProjectNo());
		projectVO = new ProjectVO();
		projectVO=getProjectService.getProject(project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("report",report);
		mav.addObject("projectVO",projectVO);
		mav.setViewName("p-report-detail");
		return mav; 
	}
	
}
