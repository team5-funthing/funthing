package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.PaymentReserveVO;

@Repository
public class PaymentReserveDAO {
	
	@Autowired
	private SqlSessionTemplate sqlsessionTemplate;
	
	public PaymentReserveVO insertPaymentReserve(PaymentReserveVO vo) {
		sqlsessionTemplate.insert("insertPaymentReserve", vo);
		return vo;
	}
	
	public PaymentReserveVO getPaymentReserve(PaymentReserveVO vo) {
		return sqlsessionTemplate.selectOne("getPaymentReserve", vo);
	}
	
	public List<PaymentReserveVO> getPaymentReserveListByEmail(PaymentReserveVO vo) {
		return sqlsessionTemplate.selectList("getPaymentReserveListByEmail", vo);
	}
	
}
