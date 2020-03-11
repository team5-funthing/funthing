package com.team5.funthing.user.service.impl.creatorStatisticsServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.CreatorStatisticsDAO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.service.creatorStatisticsService.GetTodayFundingMoneyService;

@Service
public class GetTodayFundingMoneyServiceImpl implements GetTodayFundingMoneyService {
	
	@Autowired
	private CreatorStatisticsDAO CreatorStatisticsDAO;
	
	@Override
	public List<PaymentReserveVO> getTodayFundingMoney(int currentProjectNo) {
		return CreatorStatisticsDAO.getTodayFundingMoney(currentProjectNo);
		
	}

}
