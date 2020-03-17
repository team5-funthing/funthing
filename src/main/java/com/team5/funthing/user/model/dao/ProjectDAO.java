package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ProjectVO;

@Repository
public class ProjectDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public void createProject(ProjectVO vo) {
		
	}
	
	public ProjectVO insertProject(ProjectVO vo) {
		sqlSessionTemplate.insert("insertProject", vo);
		return vo;
	}
	
	public void updateProject(ProjectVO vo) {
		sqlSessionTemplate.update("updateProject", vo);
	}
	
	public void deleteProject(ProjectVO vo) {
		sqlSessionTemplate.delete("deleteProject", vo);
		
	}
	
	public ProjectVO getProject(ProjectVO vo) {
		return sqlSessionTemplate.selectOne("getProject", vo);
	}
	
	public void updateProjectFundingMoney(ProjectVO vo) {
		sqlSessionTemplate.selectOne("updateProjectFundingMoney", vo);
	}
	
	
	public List<ProjectVO> getProjectListByEmail(ProjectVO vo){
		return sqlSessionTemplate.selectList("getProjectListByEmail",vo);
	}
	
	public List<ProjectVO> getAllFundingProjectList(){
		return sqlSessionTemplate.selectList("getAllFundingProjectList");
	}

	public void updateProjectDeadline(){
		sqlSessionTemplate.update("updateProjectDeadline");
	}
	
	
	public List<ProjectVO> getTodayClosedProjectList() {
		return sqlSessionTemplate.selectList("getTodayClosedProjectList");
	}
	
	public void updateProjectAfterPaymentCancel(ProjectVO vo) {
		sqlSessionTemplate.update("updateProjectAfterPaymentCancel", vo);
	}
	
	
//===================================ī�װ� �˻�==========================================

	public List<ProjectVO> getShowCategorySubList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("getShowCategorySubList",vo);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
