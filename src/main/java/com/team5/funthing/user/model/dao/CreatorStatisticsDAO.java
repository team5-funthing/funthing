package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.PaymentReserveVO;

@Repository
public class CreatorStatisticsDAO {
	
	@Autowired
	private SqlSessionTemplate SqlSessionTemplate;

	public List<PaymentReserveVO> getAllProjectAndPayment(int currentProjectNo) {
		return SqlSessionTemplate.selectList("CreatorStatisticsDAO.getAllProjectAndPayment", currentProjectNo);
	}

	public int getFundingPaymentCount(int currentProjectNo) {
		return SqlSessionTemplate.selectOne("CreatorStatisticsDAO.getFundingPaymentCount", currentProjectNo);
	}

	public List<PaymentReserveVO> getSumProjectAndPayment(int currentProjectNo) {
		return SqlSessionTemplate.selectList("CreatorStatisticsDAO.getSumProjectAndPayment", currentProjectNo);
	}

	public List<PaymentReserveVO> getTodayFundingMoney(int currentProjectNo) {
		return SqlSessionTemplate.selectList("CreatorStatisticsDAO.getTodayFundingMoney", currentProjectNo);
	}



}
