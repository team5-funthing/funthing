package com.team5.funthing.user.service.impl.paymentReserveServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.PaymentReserveDAO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.service.paymentReserveService.GetPaymentReserveListByEmailService;

@Service
public class GetPaymentReserveListByEmailServiceImpl implements GetPaymentReserveListByEmailService {

	@Autowired
	private PaymentReserveDAO paymentReserveDAO;
	
	@Override
	public List<PaymentReserveVO> getPaymentReserveListByEmail(PaymentReserveVO vo) {
		return paymentReserveDAO.getPaymentReserveListByEmail(vo);
	}

}
