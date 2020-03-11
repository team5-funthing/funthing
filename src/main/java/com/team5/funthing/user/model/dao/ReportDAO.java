package com.team5.funthing.user.model.dao;

import java.util.List;

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
	
	public List<ReportVO> getReportList(ReportVO vo) {
		return sqlSessionTemplate.selectList("ReportDAO.getReportList", vo);
	}
	
	public ReportVO getReport(ReportVO vo) {
		return sqlSessionTemplate.selectOne("ReportDAO.getReport", vo);
	}
	
}
