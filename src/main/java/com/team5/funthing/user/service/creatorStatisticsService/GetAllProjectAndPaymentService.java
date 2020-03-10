package com.team5.funthing.user.service.creatorStatisticsService;

import java.util.List;

import com.team5.funthing.user.model.vo.PaymentReserveVO;

public interface GetAllProjectAndPaymentService {
	
	public List<PaymentReserveVO> getAllProjectAndPayment(int currentProjectNo);
	public List<PaymentReserveVO> getSumProjectAndPayment(int currentProjectNo);

}
