package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.BoardVO;
import com.team5.funthing.user.model.vo.NoticeBoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int getBoardCount() {
		System.out.println("전체 글 갯수 받아오기");
		return sqlSessionTemplate.selectOne("BoardDAO.getBoardCount");
	}
	
	public List<NoticeBoardVO> getBoardEachPageList(BoardVO vo){
		System.out.println("시작글과 끝글의 목록 받아오기");
		return sqlSessionTemplate.selectList("BoardDAO.getBoardEachPageList",vo);
	}
	
}
