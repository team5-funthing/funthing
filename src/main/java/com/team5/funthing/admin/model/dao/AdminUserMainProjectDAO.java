package com.team5.funthing.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminUserMainProjectVO;
import com.team5.funthing.user.model.vo.ProjectVO;

@Repository
public class AdminUserMainProjectDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertFocusProject(ProjectVO vo) {
		sqlSessionTemplate.insert("AdminUserMainProjectDAO.insertFocusProject",vo);
	}
	
	public List<AdminUserMainProjectVO> getFocusProjectList(ProjectVO vo){
		return sqlSessionTemplate.selectList("AdminUserMainProjectDAO.getFocusProjectList",vo);
	}
	
	public void deleteFocusProject(ProjectVO vo) {
		sqlSessionTemplate.delete("AdminUserMainProjectDAO.deleteFocusProject",vo);
	}
	
	public AdminUserMainProjectVO getFocusProject(ProjectVO vo) {
		return sqlSessionTemplate.selectOne("AdminUserMainProjectDAO.getFocusProject",vo);
	}
	
	public List<ProjectVO> getUserMainProjectList(AdminUserMainProjectVO vo){
		return sqlSessionTemplate.selectList("AdminUserMainProjectDAO.getUserMainProjectList",vo);
	}
	
}
