package com.team5.funthing.user.service.impl.paymentReserveServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.PaymentReserveDAO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.service.paymentReserveService.UpdateShipmentCompleteService;

@Service
public class UpdateShipmentCompleteServiceImpl implements UpdateShipmentCompleteService {

	@Autowired
	private PaymentReserveDAO paymentReserveDAO;
	
	@Override
	public void updateShipmentComplete(PaymentReserveVO vo) {
		paymentReserveDAO.updateShipmentComplete(vo);
	}

}
