package com.team5.funthing.admin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminStatisticsVO;
import com.team5.funthing.user.model.vo.ProjectVO;

@Repository
public class AdminStatisticsDAO {

	@Autowired
	SqlSessionTemplate st;

	public AdminStatisticsVO getProjectSuccessRatioPerMonth(ProjectVO vo) {
		System.out.println("프로젝트 성공   월    실행");
		return st.selectOne("AdminStatisticsDAO.getProjectSuccessRatioPerMonth",vo);
	}
	
	public AdminStatisticsVO getProjectSuccessRatioPerYear(ProjectVO vo) {
		System.out.println("프로젝트성공율  연  실행");
		return st.selectOne("AdminStatisticsDAO.getProjectSuccessRatioPerYear",vo);
	}
}
