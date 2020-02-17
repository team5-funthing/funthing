package com.team5.funthing.user.service.impl.projectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.DeliveryAddressDAO;
import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.service.projectService.GetDeliveryAddressService;

@Service
public class GetDeliveryAddressServiceImpl implements GetDeliveryAddressService {

	@Autowired
	DeliveryAddressDAO deliveryAddressDAO;
	
	@Override
	public DeliveryAddressVO getDeliveryAddress(DeliveryAddressVO vo) {
		
		return deliveryAddressDAO.gettDeliveryAddress(vo);
	}

}
