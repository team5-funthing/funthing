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
	
	
	public void insertProjectAskContents(ProjectAskMessageVO vo) { //�ݵ������� -> ����Ŀ���� ���ǳ��� �Է� 
		projectAskMessageSqlSessionTemplate.insert("projectAskMessageDAO.insertProjectAskContents", vo);
		System.out.println("����Ŀ���� ���ǳ��� �Է�");
	}
	
	public void updateProjectAskReplyContentsStatus(ProjectAskMessageVO vo) {
		projectAskMessageSqlSessionTemplate.update("projectAskMessageDAO.updateProjectAskReplyContentsStatus", vo);
		System.out.println("�亯�۵�� ���ÿ� �亯���µ� ����");
	}

	public List<ProjectAskMessageVO> getEntireProjectAskMessageList(ProjectAskMessageVO vo) {
		
	
		System.out.println("�׾��̵� �´� ��ü ���Ǳ� ��������");
		List<ProjectAskMessageVO> getEntireProjectAskMessageList = projectAskMessageSqlSessionTemplate.selectList("projectAskMessageDAO.getEntireProjectAskMessageList",vo);
		
		return getEntireProjectAskMessageList;

	}
	
	public ProjectAskMessageVO getChoiceProjectAskMessage(ProjectAskMessageVO vo) {
		
		System.out.println("������ ���Ǳ� �������� ");
		return projectAskMessageSqlSessionTemplate.selectOne("projectAskMessageDAO.getChoiceProjectAskMessage",vo);
		
	}

	public MemberVO getMakerMemberCreator(MemberVO vo) {
		System.out.println("������̺�� �����Ͽ� ����Ŀ���� Ȯ���ϱ�");
		return projectAskMessageSqlSessionTemplate.selectOne("projectAskMessageDAO.getMakerMemberCreator", vo);
	}

	public List<ProjectAskMessageVO> getEntireProjectMakerAskMessageList(ProjectAskMessageVO vo) {
		System.out.println("�ش���̵� creator ��ü ���Ǳ� ��������");
		List<ProjectAskMessageVO> getEntireProjectMakerAskMessageList = projectAskMessageSqlSessionTemplate.selectList("projectAskMessageDAO.getEntireProjectMakerAskMessageList",vo);
		
		return getEntireProjectMakerAskMessageList;
	}

	public List<ProjectAskMessageVO> getProjectAskMessage(ProjectAskMessageVO vo) {
		System.out.println("where������ ���� projectAskMessage���̺� ��ΰ�������");
		return projectAskMessageSqlSessionTemplate.selectList("projectAskMessageDAO.getProjectAskMessage",vo);
	}



	
	
	

}
