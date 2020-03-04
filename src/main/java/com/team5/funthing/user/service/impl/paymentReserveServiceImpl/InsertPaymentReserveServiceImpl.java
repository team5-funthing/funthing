package com.team5.funthing.user.service.impl.paymentReserveServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.PaymentReserveDAO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.service.paymentReserveService.InsertPaymentReserveService;

@Service
public class InsertPaymentReserveServiceImpl implements InsertPaymentReserveService {

	@Autowired
	private PaymentReserveDAO paymentReserveDAO;
	
	@Override
	public PaymentReserveVO insertPaymentReserve(PaymentReserveVO vo) {
		return paymentReserveDAO.insertPaymentReserve(vo);
	}

}
