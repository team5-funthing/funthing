package com.team5.funthing.user.service.impl.deliveryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.DeliveryAddressDAO;
import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.service.deliveryService.InsertDeliveryAddressService;

@Service
public class InsertDeliveryAddressServiceImpl implements InsertDeliveryAddressService {

	@Autowired
	DeliveryAddressDAO deliveryAddressDAO;
	
	@Override
	public void insertDeliveryAddress(DeliveryAddressVO vo) {
		deliveryAddressDAO.insertDeleveryAddress(vo);

	}

}
