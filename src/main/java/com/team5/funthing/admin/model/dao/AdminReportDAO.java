package com.team5.funthing.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ReportVO;

@Repository
public class AdminReportDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public List<ReportVO> selectEntireReportList(ReportVO vo){
		
		return sqlSessionTemplate.selectList("AdminReportDAO.selectEntireReportList", vo);
	}
	
	
	
}
