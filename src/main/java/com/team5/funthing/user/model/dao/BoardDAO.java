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
		return sqlSessionTemplate.selectOne("BoardDAO.getBoardCount");
	}
	
	public List<NoticeBoardVO> getBoardEachPageList(BoardVO vo){
		return sqlSessionTemplate.selectList("BoardDAO.getBoardEachPageList",vo);
	}
	
}
