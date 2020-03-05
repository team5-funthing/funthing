package com.team5.funthing.user.service.paymentReserveService;

import java.util.List;

import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;

public interface InsertPaymentReserveService {
	
	public PaymentReserveVO insertPaymentReserve(PaymentReserveVO prvo, DeliveryAddressVO davo, List<RewardSelectionVO> selectedRewardList);
	
}
