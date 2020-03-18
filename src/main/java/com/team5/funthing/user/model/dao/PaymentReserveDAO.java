package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.model.vo.ProjectVO;

@Repository
public class PaymentReserveDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public PaymentReserveVO insertPaymentReserve(PaymentReserveVO vo) {
		sqlSessionTemplate.insert("insertPaymentReserve", vo);
		return vo;
	}
	
	public PaymentReserveVO getPaymentReserve(PaymentReserveVO vo) {
		return sqlSessionTemplate.selectOne("getPaymentReserve", vo);
	}
	
	public List<PaymentReserveVO> getPaymentReserveListByEmail(PaymentReserveVO vo) {
		return sqlSessionTemplate.selectList("getPaymentReserveListByEmail", vo);
	}
	
	public void updatePaymentComplete(int projectNo) {
		
		System.out.println("펀딩 성공으로 후원 확정");
		sqlSessionTemplate.update("updatePaymentComplete", projectNo);
	}
	
	public void updatePaymentCancel(int projectNo) {
		System.out.println("펀딩 실패로 후원 취소");
		sqlSessionTemplate.update("updatePaymentCancel", projectNo);
	}
	
	public void updateKakaoPayResultSet(PaymentReserveVO vo) {
		sqlSessionTemplate.update("updateKakaoPayResultSet", vo);
	}
	
	public void updateKaKaoPayCancelResult(PaymentReserveVO vo) {
		sqlSessionTemplate.update("updateKaKaoPayCancelResult", vo);
	}
	
	public List<PaymentReserveVO> getPaymentReserveListByProjectNo(PaymentReserveVO vo) {
		return sqlSessionTemplate.selectList("getPaymentReserveListByProjectNo", vo);
	}
	
	public void updateShipmentComplete(PaymentReserveVO vo) {
		sqlSessionTemplate.update("updateShipmentComplete", vo);
	}
	
	public List<PaymentReserveVO> getToCancelOrderList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("getToCancelOrderList", vo);
	}
	
}
