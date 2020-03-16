package com.team5.funthing.admin.statistics.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team5.funthing.admin.statistics.service.GetProjectRegCategryStatisticsService;
import com.team5.funthing.admin.statistics.service.GetProjectRegStatisticsService;
import com.team5.funthing.admin.statistics.service.GetSupportCategoryStatisticsService;
import com.team5.funthing.admin.statistics.service.GetSupportStatisticsService;
import com.team5.funthing.admin.statistics.vo.ProjectRegCategryStatisticsVO;
import com.team5.funthing.admin.statistics.vo.ProjectRegStatisticsVO;
import com.team5.funthing.admin.statistics.vo.StatisticsDateVO;
import com.team5.funthing.admin.statistics.vo.SupportCategoryStatisticsVO;
import com.team5.funthing.admin.statistics.vo.SupportStatisticsVO;

@Controller
public class AdminStatisticsController {

	@Autowired
	private GetProjectRegStatisticsService getProjectRegStatisticsService;
	@Autowired
	private GetProjectRegCategryStatisticsService getProjectRegCategryStatisticsService;
	@Autowired
	private GetSupportStatisticsService getSupportStatisticsService;
	@Autowired
	private GetSupportCategoryStatisticsService getSupportCategoryStatisticsService;
	
	
	@RequestMapping(value = "showStatisticsPage.ado")
	public String showStatisticsPage() {
		
		return "p-statistics";
	}
	
	
	
	@RequestMapping(value = "searchProjectStatistics.ado", method= RequestMethod.POST, produces ="application/text; charset=utf8")
	@ResponseBody
	public String searchProjectStatistics(@RequestBody StatisticsDateVO sdvo) throws JsonProcessingException {
		
		Map<String, Object> data = new HashMap<String, Object>();

		
		List<ProjectRegStatisticsVO> projectRegStatistics = getProjectRegStatisticsService.getProjectRegStatistics(sdvo);
		List<ProjectRegCategryStatisticsVO> projectRegCategryStatistics = getProjectRegCategryStatisticsService.getProjectRegCategryStatistics(sdvo);
		
		if(!projectRegStatistics.isEmpty()) {
			data.put("projectRegStatistics", projectRegStatistics);
		}
		
		if(!projectRegCategryStatistics.isEmpty()) {
			data.put("projectRegCategryStatistics", projectRegCategryStatistics);
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
		String selectedCreatorToJSON = mapper.writeValueAsString(data);
		return selectedCreatorToJSON;
	}
	
	
	@RequestMapping(value = "searchSupportStatistics.ado", method= RequestMethod.POST, produces ="application/text; charset=utf8")
	@ResponseBody
	public String searchSupportStatistics(@RequestBody StatisticsDateVO sdvo) throws JsonProcessingException {
		
		Map<String, Object> data = new HashMap<String, Object>();

		
		List<SupportStatisticsVO> supportStatisticsList = getSupportStatisticsService.getSupportStatistics(sdvo);
		List<SupportCategoryStatisticsVO> getSupportCategoryStatisticsList = getSupportCategoryStatisticsService.getSupportCategoryStatistics(sdvo);
		
		if(!supportStatisticsList.isEmpty()) {
			
			data.put("supportStatisticsList", supportStatisticsList);
		}
		
		if(!getSupportCategoryStatisticsList.isEmpty()) {
			data.put("getSupportCategoryStatisticsList", getSupportCategoryStatisticsList);
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
		String selectedCreatorToJSON = mapper.writeValueAsString(data);
		return selectedCreatorToJSON;
	}

}



















