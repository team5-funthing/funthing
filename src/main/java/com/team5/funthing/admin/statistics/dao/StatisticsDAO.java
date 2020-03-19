package com.team5.funthing.admin.statistics.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.statistics.vo.ProjectRegCategryStatisticsVO;
import com.team5.funthing.admin.statistics.vo.ProjectRegStatisticsVO;
import com.team5.funthing.admin.statistics.vo.StatisticsDateVO;
import com.team5.funthing.admin.statistics.vo.SupportCategoryStatisticsVO;
import com.team5.funthing.admin.statistics.vo.SupportStatisticsVO;

@Repository
public class StatisticsDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<ProjectRegStatisticsVO> getProjectRegStatistics(StatisticsDateVO vo) {
		System.out.println(vo.toString());
		return sqlSessionTemplate.selectList("getProjectRegStatistics", vo);
		
	}
	
	public List<ProjectRegCategryStatisticsVO> getProjectRegCategryStatistics(StatisticsDateVO vo) {
	return sqlSessionTemplate.selectList("getProjectRegCategryStatistics", vo);
	}
	
	
	public List<SupportStatisticsVO> getSupportStatistics(StatisticsDateVO vo){
		System.out.println(vo.toString());
		return sqlSessionTemplate.selectList("getSupportStatistics", vo);
	}
	
	public List<SupportCategoryStatisticsVO> getSupportCategoryStatistics(StatisticsDateVO vo){
		System.out.println(vo.toString());
		return sqlSessionTemplate.selectList("getSupportCategoryStatistics", vo);
	}
	

}
