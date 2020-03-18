package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectAskMessageVO;

@Repository
public class ProjectAskMessageDAO {
	
	@Autowired
	private SqlSessionTemplate projectAskMessageSqlSessionTemplate;
	
	
	public void insertProjectAskContents(ProjectAskMessageVO vo) { 
		projectAskMessageSqlSessionTemplate.insert("projectAskMessageDAO.insertProjectAskContents", vo);
	}
	
	public void updateProjectAskReplyContentsStatus(ProjectAskMessageVO vo) {
		projectAskMessageSqlSessionTemplate.update("projectAskMessageDAO.updateProjectAskReplyContentsStatus", vo);
	}

	public List<ProjectAskMessageVO> getEntireProjectAskMessageList(ProjectAskMessageVO vo) {
		List<ProjectAskMessageVO> getEntireProjectAskMessageList = projectAskMessageSqlSessionTemplate.selectList("projectAskMessageDAO.getEntireProjectAskMessageList",vo);
		
		return getEntireProjectAskMessageList;

	}
	
	public ProjectAskMessageVO getChoiceProjectAskMessage(ProjectAskMessageVO vo) {
		return projectAskMessageSqlSessionTemplate.selectOne("projectAskMessageDAO.getChoiceProjectAskMessage",vo);
		
	}

	public MemberVO getMakerMemberCreator(MemberVO vo) {
		return projectAskMessageSqlSessionTemplate.selectOne("projectAskMessageDAO.getMakerMemberCreator", vo);
	}

//	public List<ProjectAskMessageVO> getEntireProjectMakerAskMessageList(ProjectAskMessageVO vo) {
//		List<ProjectAskMessageVO> getEntireProjectMakerAskMessageList = projectAskMessageSqlSessionTemplate.selectList("projectAskMessageDAO.getEntireProjectMakerAskMessageList",vo);
//		
//		return getEntireProjectMakerAskMessageList;
//	}

	public List<ProjectAskMessageVO> getProjectAskMessage(ProjectAskMessageVO vo) {
		return projectAskMessageSqlSessionTemplate.selectList("projectAskMessageDAO.getProjectAskMessage",vo);
	}



	
	
	

}
