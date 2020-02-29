package com.team5.funthing.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ProjectVO;

@Repository
public class AdminProjectCheckDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<ProjectVO> getProjectCheckList(ProjectVO vo){
		return sqlSessionTemplate.selectList("AdminProjectCheckDAO.getProjectCheckList",vo);
	}
	
	public ProjectVO getProjectCheck(ProjectVO vo) {
		return sqlSessionTemplate.selectOne("AdminProjectCheckDAO.getProjectCheck",vo);
	}
	
	public void updateProjectCheckApproval(ProjectVO vo) {
		sqlSessionTemplate.update("AdminProjectCheckDAO.updateProjectCheckApproval",vo);
	}
	
	public void updateProjectCheckDeny(ProjectVO vo) {
		sqlSessionTemplate.update("AdminProjectCheckDAO.updateProjectCheckDeny",vo);
	}
	
	public void updateProjectCheckDefer(ProjectVO vo) {
		sqlSessionTemplate.update("AdminProjectCheckDAO.updateProjectCheckDefer",vo);
	}
	
	public void updateStatusReplyMessage(ProjectVO vo) {
		sqlSessionTemplate.update("AdminProjectCheckDAO.updateStatusReplyMessage",vo);
	}
	
}
