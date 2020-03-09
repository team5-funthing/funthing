package com.team5.funthing.user.service.impl.creatorStatisticsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.CreatorStatisticsDAO;
import com.team5.funthing.user.service.creatorStatisticsService.GetFundingPaymentCountService;

@Service
public class GetFundingPaymentCountServiceImpl implements GetFundingPaymentCountService {
	
	@Autowired
	private CreatorStatisticsDAO CreatorStatisticsDAO;
	
	@Override
	public int getFundingPaymentCount(int currentProjectNo) {
		return CreatorStatisticsDAO.getFundingPaymentCount(currentProjectNo);
		
	}

}
