package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.CreatorVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectAskMessageVO;
import com.team5.funthing.user.model.vo.ProjectBoardVO;

@Repository
public class ProjectAskMessageDAO {
	
	@Autowired
	private SqlSessionTemplate projectAskMessageSqlSessionTemplate;
	
	
	public void insertProjectAskContents(ProjectAskMessageVO vo) { //펀딩참여자 -> 메이커에게 문의내용 입력 
		projectAskMessageSqlSessionTemplate.insert("projectAskMessageDAO.insertProjectAskContents", vo);
		System.out.println("메이커에게 문의내용 입력");
	}
	
	public void updateProjectAskReplyContentsStatus(ProjectAskMessageVO vo) {
		projectAskMessageSqlSessionTemplate.update("projectAskMessageDAO.updateProjectAskReplyContentsStatus", vo);
		System.out.println("답변글등록 동시에 답변상태도 변경");
	}

	public List<ProjectAskMessageVO> getEntireProjectAskMessageList(ProjectAskMessageVO vo) {
		
	
		System.out.println("그아이디에 맞는 전체 문의글 가져오기");
		List<ProjectAskMessageVO> getEntireProjectAskMessageList = projectAskMessageSqlSessionTemplate.selectList("projectAskMessageDAO.getEntireProjectAskMessageList",vo);
		
		return getEntireProjectAskMessageList;

	}
	
	public ProjectAskMessageVO getChoiceProjectAskMessage(ProjectAskMessageVO vo) {
		
		System.out.println("선택한 문의글 가져오기 ");
		return projectAskMessageSqlSessionTemplate.selectOne("projectAskMessageDAO.getChoiceProjectAskMessage",vo);
		
	}

	public MemberVO getMakerMemberCreator(MemberVO vo) {
		System.out.println("멤버테이블과 조인하여 메이커인지 확인하기");
		return projectAskMessageSqlSessionTemplate.selectOne("projectAskMessageDAO.getMakerMemberCreator", vo);
	}

	public List<ProjectAskMessageVO> getEntireProjectMakerAskMessageList(ProjectAskMessageVO vo) {
		System.out.println("해당아이디 creator 전체 문의글 가져오기");
		List<ProjectAskMessageVO> getEntireProjectMakerAskMessageList = projectAskMessageSqlSessionTemplate.selectList("projectAskMessageDAO.getEntireProjectMakerAskMessageList",vo);
		
		return getEntireProjectMakerAskMessageList;
	}

	public List<ProjectAskMessageVO> getProjectAskMessage(ProjectAskMessageVO vo) {
		System.out.println("where조건절 없이 projectAskMessage테이블 모두가져오기");
		return projectAskMessageSqlSessionTemplate.selectList("projectAskMessageDAO.getProjectAskMessage",vo);
	}



	
	
	

}
