package com.team5.funthing.admin.statistics.service;

import java.util.List;

import com.team5.funthing.admin.statistics.vo.ProjectRegCategryStatisticsVO;
import com.team5.funthing.admin.statistics.vo.StatisticsDateVO;

public interface GetProjectRegCategryStatisticsService {
	
	public List<ProjectRegCategryStatisticsVO> getProjectRegCategryStatistics(StatisticsDateVO vo);
		

}
