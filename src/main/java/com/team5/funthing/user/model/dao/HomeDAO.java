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
		return sqlSessionTemplate.selectList("HomeDAO.getAttentionProjectList", vo);
	}
	
	// ========================2��° ������ ������Ʈ ========================
	public List<ProjectVO> getProjectProgressList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getProjectProgressList",vo);
	}
	public List<ProjectVO> getProjectProgressList2(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getProjectProgressList2",vo);
	}
	public List<ProjectVO> getProjectProgressList3(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getProjectProgressList3",vo);
	}

	// ========================3��° �α�������Ʈ ========================
	public List<ProjectVO> getLikeCountList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getLikeCountList",vo);
	}
	
	public List<ProjectVO> getLikeCountList2(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getLikeCountList2",vo);
	}
	
	public List<ProjectVO> getLikeCountList3(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getLikeCountList3",vo);
	}
	// ========================4��° �����ӹ� ������Ʈ ========================
	public List<ProjectVO> getMoneyPercentList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getMoneyPercentList",vo);
	}

	public List<ProjectVO> getMoneyPercentList2(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getMoneyPercentList2",vo);
	}

	public List<ProjectVO> getMoneyPercentList3(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getMoneyPercentList3",vo);
	}
	
	// ========================5��° �����ӹ� ������Ʈ ========================
	public List<ProjectVO> getDeadLineList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getDeadLineList",vo);
	}
	public List<ProjectVO> getDeadLineList2(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getDeadLineList2",vo);
	}
	public List<ProjectVO> getDeadLineList3(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getDeadLineList3",vo);
	}
	
	
	// =======================��ܹ� �α�������Ʈ Ŭ����============================

	public List<ProjectVO> getAllLikeCountList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getAllLikeCountList",vo);
	}

	
	// =======================��ܹ� �����ӹ� Ŭ����============================
	public List<ProjectVO> getAllDeadLineList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getAllDeadLineList",vo);
	}
	
	//	=======================��ܹ� �ֽ�������Ʈ Ŭ����============================

	public List<ProjectVO> getAllNewProjectList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getAllNewProjectList",vo);
	}

	
//	========================��ܹ� �����ӹ� ������ƮŬ���� =================================
	public List<ProjectVO> getAllMoneyPercentList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getAllMoneyPercentList",vo);
	}

	

	

	



	

	
	
	
}
