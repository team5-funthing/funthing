package com.team5.funthing.admin.statistics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.statistics.dao.StatisticsDAO;
import com.team5.funthing.admin.statistics.vo.ProjectRegStatisticsVO;
import com.team5.funthing.admin.statistics.vo.StatisticsDateVO;

@Service
public class GetProjectRegStatisticsServiceImpl implements GetProjectRegStatisticsService {

	@Autowired
	private StatisticsDAO statisticsDAO;
	
	@Override
	public List<ProjectRegStatisticsVO> getProjectRegStatistics(StatisticsDateVO vo) {
		return statisticsDAO.getProjectRegStatistics(vo);
	}

}
