package com.team5.funthing.user.service.paymentReserveService;

import java.util.List;

import com.team5.funthing.user.model.vo.PaymentReserveVO;

public interface GetPaymentReserveListByProjectNoService {
	
	public List<PaymentReserveVO> getPaymentReserveListByProjectNo(PaymentReserveVO vo);
}
