package com.team5.funthing.admin.statistics.service;

import java.util.List;

import com.team5.funthing.admin.statistics.vo.StatisticsDateVO;
import com.team5.funthing.admin.statistics.vo.SupportStatisticsVO;

public interface GetSupportStatisticsService {

	public List<SupportStatisticsVO> getSupportStatistics(StatisticsDateVO vo);
	
}
