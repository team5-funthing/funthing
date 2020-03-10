package com.team5.funthing.admin.service.impl.adminStatisticsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminStatisticsDAO;
import com.team5.funthing.admin.model.vo.AdminStatisticsVO;
import com.team5.funthing.admin.service.adminStatisticsService.GetProjectSuccessRatioTotalYearService;
@Service
public class GetProjectSuccessRatioTotalYearServiceImpl implements GetProjectSuccessRatioTotalYearService {

	
	@Autowired
	AdminStatisticsDAO dao;
	@Override
	public AdminStatisticsVO getProjectSuccessRatioTotalYear(AdminStatisticsVO vo) {
		
		return dao.getProjectSuccessRatioTotalYear(vo);
	}

}
