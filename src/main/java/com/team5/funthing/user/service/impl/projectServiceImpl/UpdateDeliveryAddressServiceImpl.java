package com.team5.funthing.user.service.impl.projectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.DeliveryAddressDAO;
import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.service.projectService.UpdateDeliveryAddressService;
@Service
public class UpdateDeliveryAddressServiceImpl implements UpdateDeliveryAddressService {

	@Autowired
	DeliveryAddressDAO deliveryAddressDAO;
	@Override
	public void updateDeliveryAddress(DeliveryAddressVO vo) {
		deliveryAddressDAO.updateDeliveryAddress(vo);

	}

}
