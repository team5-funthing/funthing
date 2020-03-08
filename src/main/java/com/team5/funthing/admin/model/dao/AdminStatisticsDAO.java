package com.team5.funthing.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminStatisticsVO;

@Repository
public class AdminStatisticsDAO {

	@Autowired
	SqlSessionTemplate st;

	public AdminStatisticsVO getProjectSuccessRatioPerMonth(AdminStatisticsVO vo) {
		System.out.println("������Ʈ ����   ��    ����");
		return st.selectOne("AdminStatisticsDAO.getProjectSuccessRatioPerMonth",vo);
	}
	
	public List<AdminStatisticsVO> getProjectSuccessRatioPerYear(AdminStatisticsVO vo) {
		System.out.println("������Ʈ������  ��  ����");
		System.out.println(vo);
		return st.selectList("AdminStatisticsDAO.getProjectSuccessRatioPerYear",vo);
	}
}
