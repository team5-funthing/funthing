package com.team5.funthing.user.service.impl.deliveryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.DeliveryAddressDAO;
import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.service.deliveryService.InsertDeliveryAddressService;

@Service
public class InsertDeliveryAddressServiceImpl implements InsertDeliveryAddressService {

	@Autowired
	private DeliveryAddressDAO deliveryAddressDAO;
	
	@Override
	public DeliveryAddressVO insertDeliveryAddress(DeliveryAddressVO vo) {
		return deliveryAddressDAO.insertDeleveryAddress(vo);

	}

}
