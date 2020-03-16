package com.team5.funthing.admin.statistics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.statistics.dao.StatisticsDAO;
import com.team5.funthing.admin.statistics.vo.StatisticsDateVO;
import com.team5.funthing.admin.statistics.vo.SupportStatisticsVO;

@Service
public class GetSupportStatisticsServiceImpl implements GetSupportStatisticsService {

	@Autowired
	private StatisticsDAO statisticsDAO;
	
	@Override
	public List<SupportStatisticsVO> getSupportStatistics(StatisticsDateVO vo) {
		return statisticsDAO.getSupportStatistics(vo);
	}

}
