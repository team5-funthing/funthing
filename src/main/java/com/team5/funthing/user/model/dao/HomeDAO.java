package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.model.vo.ProjectVO;


@Repository
public class HomeDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	// ========================1��° �ָ��� ������Ʈ ========================
	public List<ProjectBoardVO> getAttentionProjectList(ProjectBoardVO vo) {
		System.out.println("�ָ��� ������Ʈ ��������(����:����̸�����)");
		return sqlSessionTemplate.selectList("HomeDAO.getAttentionProjectList", vo);
	}
	
	// ========================2��° ������ ������Ʈ ========================
	public List<ProjectVO> getProjectProgressList(ProjectVO vo) {
		System.out.println("������ ������Ʈ ��������(����:status = 'y' ������ n ������)");
		return sqlSessionTemplate.selectList("HomeDAO.getProjectProgressList",vo);
	}
	public List<ProjectVO> getProjectProgressList2(ProjectVO vo) {
		System.out.println("������ ������Ʈ 2��°��������(����:status = 'y' ������ n ������)");
		return sqlSessionTemplate.selectList("HomeDAO.getProjectProgressList2",vo);
	}
	public List<ProjectVO> getProjectProgressList3(ProjectVO vo) {
		System.out.println("������ ������Ʈ 3��°��������(����:status = 'y' ������ n ������)");
		return sqlSessionTemplate.selectList("HomeDAO.getProjectProgressList3",vo);
	}

	// ========================3��° �α�������Ʈ ========================
	public List<ProjectVO> getLikeCountList(ProjectVO vo) {
		System.out.println("�α� ������Ʈ ��������(����:likecount ����������)");
		return sqlSessionTemplate.selectList("HomeDAO.getLikeCountList",vo);
	}
	
	public List<ProjectVO> getLikeCountList2(ProjectVO vo) {
		System.out.println("�α� ������Ʈ ��������2��°(����:likecount ����������)");
		return sqlSessionTemplate.selectList("HomeDAO.getLikeCountList2",vo);
	}
	
	public List<ProjectVO> getLikeCountList3(ProjectVO vo) {
		System.out.println("�α� ������Ʈ ��������3��°(����:likecount ����������)");
		return sqlSessionTemplate.selectList("HomeDAO.getLikeCountList3",vo);
	}
	// ========================4��° �����ӹ� ������Ʈ ========================
	public List<ProjectVO> getMoneyPercentList(ProjectVO vo) {
		System.out.println("�����ӹ� ������Ʈ ��������(����:%����������)");
		return sqlSessionTemplate.selectList("HomeDAO.getMoneyPercentList",vo);
	}

	public List<ProjectVO> getMoneyPercentList2(ProjectVO vo) {
		System.out.println("�����ӹ� ������Ʈ ��������2��°(����:%����������)");
		return sqlSessionTemplate.selectList("HomeDAO.getMoneyPercentList2",vo);
	}

	public List<ProjectVO> getMoneyPercentList3(ProjectVO vo) {
		System.out.println("�����ӹ� ������Ʈ ��������3��°(����:%����������)");
		return sqlSessionTemplate.selectList("HomeDAO.getMoneyPercentList3",vo);
	}



	

	
	
	
}
