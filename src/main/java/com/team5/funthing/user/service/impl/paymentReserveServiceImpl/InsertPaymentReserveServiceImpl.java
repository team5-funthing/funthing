package com.team5.funthing.user.service.impl.paymentReserveServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team5.funthing.user.model.dao.DeliveryAddressDAO;
import com.team5.funthing.user.model.dao.PaymentReserveDAO;
import com.team5.funthing.user.model.dao.RewardSelectionDAO;
import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;
import com.team5.funthing.user.service.paymentReserveService.InsertPaymentReserveService;

@Service
public class InsertPaymentReserveServiceImpl implements InsertPaymentReserveService {

	@Autowired
	private DeliveryAddressDAO deliveryAddressDAO;
	@Autowired
	private PaymentReserveDAO paymentReserveDAO;
	@Autowired
	private RewardSelectionDAO rewardSelectionDAO;
	
	@Override
	@Transactional
	public PaymentReserveVO insertPaymentReserve(PaymentReserveVO prvo, DeliveryAddressVO davo , List<RewardSelectionVO> selectedRewardList) {
		
		davo = deliveryAddressDAO.insertDeleveryAddress(davo);
		prvo.setDeliveryAddressNo(davo.getDeliveryAddressNo());
		
		prvo = paymentReserveDAO.insertPaymentReserve(prvo);
		int orderNo = prvo.getOrderNo();
		
		for(RewardSelectionVO rs : selectedRewardList) {
			rs.setOrderNo(orderNo);
			rewardSelectionDAO.insertRewardSelection(rs);
		}
		
		
		return prvo;
	}

}
