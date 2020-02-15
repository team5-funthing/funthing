package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.BoardVO;
import com.team5.funthing.user.model.vo.NoticeVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int selectBoardCount() {
		return sqlSessionTemplate.selectOne("BoardDAO.selectBoardCount");
	}
	
	public List<NoticeVO> selectBoardEachPage(BoardVO vo){
		return sqlSessionTemplate.selectList("BoardDAO.selectBoardEachPage",vo);
	}
	
}
