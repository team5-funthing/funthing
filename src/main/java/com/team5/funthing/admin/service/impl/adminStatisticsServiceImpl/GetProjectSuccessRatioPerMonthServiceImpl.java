package com.team5.funthing.admin.service.impl.adminStatisticsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminStatisticsDAO;
import com.team5.funthing.admin.model.vo.AdminStatisticsVO;
import com.team5.funthing.admin.service.adminStatisticsService.GetProjectSuccessRatioPerMonthService;
import com.team5.funthing.user.model.vo.ProjectVO;

@Service
public class GetProjectSuccessRatioPerMonthServiceImpl implements GetProjectSuccessRatioPerMonthService {
	
	@Autowired
	AdminStatisticsDAO dao;

	@Override
	public AdminStatisticsVO getProjectSuccessRatioPerMonth(AdminStatisticsVO vo) {
		
		return dao.getProjectSuccessRatioPerMonth(vo);
	}

}
