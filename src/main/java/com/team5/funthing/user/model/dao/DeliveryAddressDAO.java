package com.team5.funthing.user.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.DeliveryAddressVO;

@Repository
public class DeliveryAddressDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public DeliveryAddressVO insertDeleveryAddress(DeliveryAddressVO vo) {
		sqlSessionTemplate.insert("DeliveryAddressDAO.insertDeliveryAddress",vo);
		return vo;
	}
	
	public void updateDeliveryAddress(DeliveryAddressVO vo) {
		sqlSessionTemplate.update("DeliveryAddressDAO.updateDeliveryAddress",vo);
	}
	
	public DeliveryAddressVO getDeliveryAddress(DeliveryAddressVO vo) {
		return sqlSessionTemplate.selectOne("getDeliveryAddress", vo);
	}
}
