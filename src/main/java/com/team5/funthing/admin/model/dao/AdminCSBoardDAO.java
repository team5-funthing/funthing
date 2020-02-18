package com.team5.funthing.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminCSBoardVO;
import com.team5.funthing.user.model.vo.CSBoardVO;

@Repository
public class AdminCSBoardDAO {

	@Autowired
	private SqlSessionTemplate adminCSBoardSqlSessionTemplate;
	
	public List<CSBoardVO> selectEntireCSBoardList(CSBoardVO vo){	
		System.out.println("고객문의 전체글 목록 얻어오기");
		return adminCSBoardSqlSessionTemplate.selectList("AdminCSBoardDAO.selectEntireCSBoardList",vo);
	}
	
	public CSBoardVO selectCSBoard(CSBoardVO vo) {
		System.out.println("고객문의 글 상세보기 ");
		return adminCSBoardSqlSessionTemplate.selectOne("AdminCSBoardDAO.selectCSBoard",vo);
	}
	
	public void insertAdminCSBoard(AdminCSBoardVO vo) {
		System.out.println("답변 입력 내용 저장");
		adminCSBoardSqlSessionTemplate.insert("AdminCSBoardDAO.insertAdminCSBoard",vo);
	}
	
	public void updateReplyCheckCSBoard(CSBoardVO vo) {
		System.out.println("답변상태여부 완료 처리");
		adminCSBoardSqlSessionTemplate.update("CSBoardDAO.updateReplyCheckCSBoard",vo);
	}
	
}
