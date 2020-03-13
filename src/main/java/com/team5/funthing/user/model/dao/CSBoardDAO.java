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
		sqlSessionTemplate.insert("CSBoardDAO.insertCSBoard", vo);
	}
	
	public List<CSBoardVO> getCSBoardList(CSBoardVO vo) {
		return sqlSessionTemplate.selectList("CSBoardDAO.getUserCSBoardList", vo);
	}
	
	public CSBoardVO getCSBoard(CSBoardVO vo) {
		return sqlSessionTemplate.selectOne("CSBoardDAO.getUserCSBoard", vo);
	}
}
