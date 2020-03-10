package com.team5.funthing.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminMainViewVO;
import com.team5.funthing.user.model.vo.ProjectVO;

@Repository
public class AdminMainViewDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<ProjectVO> getMainViewProjectStatusList(AdminMainViewVO vo){
		return sqlSessionTemplate.selectList("AdminMainViewDAO.getMainViewProjectStatusList",vo);
	}
	
	public List<ProjectVO> getMainViewProjectFundingList(AdminMainViewVO vo){
		return sqlSessionTemplate.selectList("AdminMainViewDAO.getMainViewProjectFundingList",vo);
	}
	
}
