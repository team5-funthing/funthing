package com.team5.funthing.admin.statistics.service;

import java.util.List;

import com.team5.funthing.admin.statistics.vo.StatisticsDateVO;
import com.team5.funthing.admin.statistics.vo.SupportCategoryStatisticsVO;

public interface GetSupportCategoryStatisticsService {

	
	public List<SupportCategoryStatisticsVO> getSupportCategoryStatistics(StatisticsDateVO vo);
	
}
