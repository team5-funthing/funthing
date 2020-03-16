package com.team5.funthing.admin.statistics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.statistics.dao.StatisticsDAO;
import com.team5.funthing.admin.statistics.vo.ProjectRegCategryStatisticsVO;
import com.team5.funthing.admin.statistics.vo.StatisticsDateVO;

@Service
public class GetProjectRegCategryStatisticsServiceImpl implements GetProjectRegCategryStatisticsService {

	@Autowired
	private StatisticsDAO statisticsDAO;
	
	@Override
	public List<ProjectRegCategryStatisticsVO> getProjectRegCategryStatistics(StatisticsDateVO vo) {
		return statisticsDAO.getProjectRegCategryStatistics(vo);
	}

}
