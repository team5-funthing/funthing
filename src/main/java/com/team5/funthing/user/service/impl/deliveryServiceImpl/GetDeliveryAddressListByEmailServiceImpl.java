package com.team5.funthing.user.service.impl.deliveryServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.DeliveryAddressDAO;
import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.deliveryService.GetDeliveryAddressListByEmailService;

@Service
public class GetDeliveryAddressListByEmailServiceImpl implements GetDeliveryAddressListByEmailService {
	
	@Autowired
	private DeliveryAddressDAO deliveryAddressDAO;
	
	@Override
	public List<DeliveryAddressVO> getDeliveryAddressListByEmail(MemberVO vo) {
		return deliveryAddressDAO.getDeliveryAddressListByEmail(vo);
	}

}
