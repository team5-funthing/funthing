package com.team5.funthing.user.service.impl.paymentReserveServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.PaymentReserveDAO;
import com.team5.funthing.user.model.dao.ProjectDAO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.paymentReserveService.GetPaymentReserveListByEmailService;

@Service
public class GetPaymentReserveListByEmailServiceImpl implements GetPaymentReserveListByEmailService {

	@Autowired
	private PaymentReserveDAO paymentReserveDAO;
	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private ProjectVO projectVO;

	@Override
	public List<PaymentReserveVO> getPaymentReserveListByEmail(PaymentReserveVO vo) {
		
		List<PaymentReserveVO> paymentReserveList = paymentReserveDAO.getPaymentReserveListByEmail(vo);

//		if(!paymentReserveList.isEmpty()) {
//
//			for(PaymentReserveVO paymentReserve : paymentReserveList) {
//				ProjectVO pvo = projectVO;
//				
//				if(paymentReserve != null) {
//					pvo.setProjectNo(paymentReserve.getProjectNo());
//					pvo = projectDAO.getProject(pvo);
//					if(pvo != null) {
//						paymentReserve.setProjectMainImage(pvo.getProjectMainImage());
//					}
//				}
//			}
//		}

		return paymentReserveList;
		
	}
	
	
	
}
