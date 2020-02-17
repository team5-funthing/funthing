package com.team5.funthing.user.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.CSBoardVO;

@Repository
public class CSBoardDAO {
	
	@Autowired
	private SqlSessionTemplate csboardSqlSessionTemplate;
	
	public void insertCSBoard(CSBoardVO vo) {
		System.out.println("고객문의 게시판에 글 입력");
		csboardSqlSessionTemplate.insert("CSBoardDAO.insertCSBoard", vo);
	}
	
	
	
}
