package com.team5.funthing.admin.service.impl.adminStatisticsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminStatisticsDAO;
import com.team5.funthing.admin.model.vo.AdminStatisticsVO;
import com.team5.funthing.admin.service.adminStatisticsService.GetFundingMoneyPerMonthService;

@Service
public class GetFundingMoneyPerMonthServiceImpl implements GetFundingMoneyPerMonthService {

	
	@Autowired
	AdminStatisticsDAO dao;
	@Override
	public AdminStatisticsVO getFundingMoneyPerMonth(AdminStatisticsVO vo) {
		return dao.getFundingMoneyPerMonth(vo);
	}

}
