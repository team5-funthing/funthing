package com.team5.funthing.admin.statistics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.statistics.dao.StatisticsDAO;
import com.team5.funthing.admin.statistics.vo.StatisticsDateVO;
import com.team5.funthing.admin.statistics.vo.SupportCategoryStatisticsVO;

@Service
public class GetSupportCategoryStatisticsServiceImpl implements GetSupportCategoryStatisticsService {

	@Autowired
	private StatisticsDAO statisticsDAO;
	
	@Override
	public List<SupportCategoryStatisticsVO> getSupportCategoryStatistics(StatisticsDateVO vo) {
		return statisticsDAO.getSupportCategoryStatistics(vo);
	}

}
