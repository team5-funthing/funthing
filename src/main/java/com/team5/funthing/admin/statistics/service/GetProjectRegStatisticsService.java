package com.team5.funthing.admin.statistics.service;

import java.util.List;

import com.team5.funthing.admin.statistics.vo.ProjectRegStatisticsVO;
import com.team5.funthing.admin.statistics.vo.StatisticsDateVO;

public interface GetProjectRegStatisticsService {
	
	public List<ProjectRegStatisticsVO> getProjectRegStatistics(StatisticsDateVO vo);
}
