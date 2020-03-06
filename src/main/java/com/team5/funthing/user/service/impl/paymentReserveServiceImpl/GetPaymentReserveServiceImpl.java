package com.team5.funthing.user.service.impl.paymentReserveServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.PaymentReserveDAO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.service.paymentReserveService.GetPaymentReserveService;

@Service
public class GetPaymentReserveServiceImpl implements GetPaymentReserveService {

	@Autowired
	private PaymentReserveDAO paymentReserveDAO;
	
	@Override
	public PaymentReserveVO getPaymentReserve(PaymentReserveVO vo) {
		
		return paymentReserveDAO.getPaymentReserve(vo);
	}

}
