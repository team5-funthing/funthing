package com.team5.funthing.user.service.deliveryService;

import java.util.List;

import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.model.vo.MemberVO;

public interface GetDeliveryAddressListByEmailService {
	
	public List<DeliveryAddressVO> getDeliveryAddressListByEmail(MemberVO vo);

}
