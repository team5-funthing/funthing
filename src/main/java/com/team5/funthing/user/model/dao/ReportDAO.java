package com.team5.funthing.user.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ReportVO;

@Repository
public class ReportDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertReport(ReportVO vo) {
		
		sqlSessionTemplate.insert("ReportDAO.insertReport",vo);
		
	}
	
	
}
