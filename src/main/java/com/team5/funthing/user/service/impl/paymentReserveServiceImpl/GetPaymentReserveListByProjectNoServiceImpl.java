package com.team5.funthing.user.service.impl.paymentReserveServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.PaymentReserveDAO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.service.paymentReserveService.GetPaymentReserveListByProjectNoService;

@Service
public class GetPaymentReserveListByProjectNoServiceImpl implements GetPaymentReserveListByProjectNoService {

	@Autowired
	private PaymentReserveDAO paymentReserveDAO;

	@Override
	public List<PaymentReserveVO> getPaymentReserveListByProjectNo(PaymentReserveVO vo) {
		
		List<PaymentReserveVO> paymentReserveList = paymentReserveDAO.getPaymentReserveListByProjectNo(vo);


		return paymentReserveList;
	}

}
