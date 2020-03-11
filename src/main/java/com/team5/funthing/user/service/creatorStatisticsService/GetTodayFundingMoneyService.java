package com.team5.funthing.user.service.creatorStatisticsService;

import java.util.List;

import com.team5.funthing.user.model.vo.PaymentReserveVO;

public interface GetTodayFundingMoneyService {
	
	public List<PaymentReserveVO> getTodayFundingMoney(int currentProjectNo);

}
