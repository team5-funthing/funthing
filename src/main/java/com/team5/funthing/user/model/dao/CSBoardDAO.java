package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.CSBoardVO;

@Repository
public class CSBoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertCSBoard(CSBoardVO vo) {
		System.out.println("고객문의 게시판에 글 입력");
		sqlSessionTemplate.insert("CSBoardDAO.insertCSBoard", vo);
	}
	
	public List<CSBoardVO> getCSBoardList(CSBoardVO vo) {
		System.out.println( "getCSBoardList");
		return sqlSessionTemplate.selectList("CSBoardDAO.getUserCSBoardList", vo);
	}
	
	public CSBoardVO getCSBoard(CSBoardVO vo) {
		System.out.println("getCSBoard");
		return sqlSessionTemplate.selectOne("CSBoardDAO.getUserCSBoard", vo);
	}
}
