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
	
	// ========================1번째 주목할 프로젝트 ========================
	public List<ProjectBoardVO> getAttentionProjectList(ProjectBoardVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getAttentionProjectList", vo);
	}
	
	// ========================2번째 진행중 프로젝트 ========================
	public List<ProjectVO> getProjectProgressList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getProjectProgressList",vo);
	}
	public List<ProjectVO> getProjectProgressList2(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getProjectProgressList2",vo);
	}
	public List<ProjectVO> getProjectProgressList3(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getProjectProgressList3",vo);
	}

	// ========================3번째 인기프로젝트 ========================
	public List<ProjectVO> getLikeCountList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getLikeCountList",vo);
	}
	
	public List<ProjectVO> getLikeCountList2(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getLikeCountList2",vo);
	}
	
	public List<ProjectVO> getLikeCountList3(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getLikeCountList3",vo);
	}
	// ========================4번째 성공임박 프로젝트 ========================
	public List<ProjectVO> getMoneyPercentList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getMoneyPercentList",vo);
	}

	public List<ProjectVO> getMoneyPercentList2(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getMoneyPercentList2",vo);
	}

	public List<ProjectVO> getMoneyPercentList3(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getMoneyPercentList3",vo);
	}
	
	// ========================5번째 마감임박 프로젝트 ========================
	public List<ProjectVO> getDeadLineList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getDeadLineList",vo);
	}
	public List<ProjectVO> getDeadLineList2(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getDeadLineList2",vo);
	}
	public List<ProjectVO> getDeadLineList3(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getDeadLineList3",vo);
	}
	
	
	// =======================상단바 인기프로젝트 클릭시============================

	public List<ProjectVO> getAllLikeCountList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getAllLikeCountList",vo);
	}

	
	// =======================상단바 마감임박 클릭시============================
	public List<ProjectVO> getAllDeadLineList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getAllDeadLineList",vo);
	}
	
	//	=======================상단바 최신프로젝트 클릭시============================

	public List<ProjectVO> getAllNewProjectList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getAllNewProjectList",vo);
	}

	
//	========================상단바 성공임박 프로젝트클릭시 =================================
	public List<ProjectVO> getAllMoneyPercentList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("HomeDAO.getAllMoneyPercentList",vo);
	}

	

	

	



	

	
	
	
}
