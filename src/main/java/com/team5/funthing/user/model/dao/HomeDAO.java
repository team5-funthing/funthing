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
		System.out.println("주목할 프로젝트 가져오기(기준:댓글이많은거)");
		return sqlSessionTemplate.selectList("HomeDAO.getAttentionProjectList", vo);
	}
	
	// ========================2번째 진행중 프로젝트 ========================
	public List<ProjectVO> getProjectProgressList(ProjectVO vo) {
		System.out.println("진행중 프로젝트 가져오기(기준:status = 'y' 지금은 n 실험중)");
		return sqlSessionTemplate.selectList("HomeDAO.getProjectProgressList",vo);
	}
	public List<ProjectVO> getProjectProgressList2(ProjectVO vo) {
		System.out.println("진행중 프로젝트 2번째가져오기(기준:status = 'y' 지금은 n 실험중)");
		return sqlSessionTemplate.selectList("HomeDAO.getProjectProgressList2",vo);
	}
	public List<ProjectVO> getProjectProgressList3(ProjectVO vo) {
		System.out.println("진행중 프로젝트 3번째가져오기(기준:status = 'y' 지금은 n 실험중)");
		return sqlSessionTemplate.selectList("HomeDAO.getProjectProgressList3",vo);
	}

	// ========================3번째 인기프로젝트 ========================
	public List<ProjectVO> getLikeCountList(ProjectVO vo) {
		System.out.println("인기 프로젝트 가져오기(기준:likecount 많은순으로)");
		return sqlSessionTemplate.selectList("HomeDAO.getLikeCountList",vo);
	}
	
	public List<ProjectVO> getLikeCountList2(ProjectVO vo) {
		System.out.println("인기 프로젝트 가져오기2번째(기준:likecount 많은순으로)");
		return sqlSessionTemplate.selectList("HomeDAO.getLikeCountList2",vo);
	}
	
	public List<ProjectVO> getLikeCountList3(ProjectVO vo) {
		System.out.println("인기 프로젝트 가져오기3번째(기준:likecount 많은순으로)");
		return sqlSessionTemplate.selectList("HomeDAO.getLikeCountList3",vo);
	}
	// ========================4번째 성공임박 프로젝트 ========================
	public List<ProjectVO> getMoneyPercentList(ProjectVO vo) {
		System.out.println("성공임박 프로젝트 가져오기(기준:%높은순으로)");
		return sqlSessionTemplate.selectList("HomeDAO.getMoneyPercentList",vo);
	}

	public List<ProjectVO> getMoneyPercentList2(ProjectVO vo) {
		System.out.println("성공임박 프로젝트 가져오기2번째(기준:%높은순으로)");
		return sqlSessionTemplate.selectList("HomeDAO.getMoneyPercentList2",vo);
	}

	public List<ProjectVO> getMoneyPercentList3(ProjectVO vo) {
		System.out.println("성공임박 프로젝트 가져오기3번째(기준:%높은순으로)");
		return sqlSessionTemplate.selectList("HomeDAO.getMoneyPercentList3",vo);
	}
	
	// ========================5번째 마감임박 프로젝트 ========================
	public List<ProjectVO> getDeadLineList(ProjectVO vo) {
		System.out.println("마감임박 프로젝트 가져오기(기준:endDate 최신순으로)");
		return sqlSessionTemplate.selectList("HomeDAO.getDeadLineList",vo);
	}
	public List<ProjectVO> getDeadLineList2(ProjectVO vo) {
		System.out.println("마감임박 프로젝트 가져오기2번째(기준:endDate 최신순으로)");
		return sqlSessionTemplate.selectList("HomeDAO.getDeadLineList2",vo);
	}
	public List<ProjectVO> getDeadLineList3(ProjectVO vo) {
		System.out.println("마감임박 프로젝트 가져오기3번째(기준:endDate 최신순으로)");
		return sqlSessionTemplate.selectList("HomeDAO.getDeadLineList3",vo);
	}
	
	
	// =======================상단바 인기프로젝트 클릭시============================

	public List<ProjectVO> getAllLikeCountList(ProjectVO vo) {
		System.out.println("인기 프로젝트 가져오기(기준:likecount 많은순으로 20개 가져오기 )");
		return sqlSessionTemplate.selectList("HomeDAO.getAllLikeCountList",vo);
	}

	
	// =======================상단바 마감임박 클릭시============================
	public List<ProjectVO> getAllDeadLineList(ProjectVO vo) {
		System.out.println("마감임박 프로젝트 가져오기(기준:endDate 최신순으로 20개 가져오기)");
		return sqlSessionTemplate.selectList("HomeDAO.getAllDeadLineList",vo);
	}
	
	//	=======================상단바 최신프로젝트 클릭시============================

	public List<ProjectVO> getAllNewProjectList(ProjectVO vo) {
		System.out.println("최신 프로젝트 가져오기(기준:startDate 최신순으로 20개 가져오기)");
		return sqlSessionTemplate.selectList("HomeDAO.getAllNewProjectList",vo);
	}

	

	

	



	

	
	
	
}
