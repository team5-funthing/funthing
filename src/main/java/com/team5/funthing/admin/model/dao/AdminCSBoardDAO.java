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
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<CSBoardVO> getCSBoardList(CSBoardVO vo){	
		System.out.println("고객문의 전체글 목록 얻어오기");
		return sqlSessionTemplate.selectList("AdminCSBoardDAO.getCSBoardList",vo);
	}
	
	public CSBoardVO getCSBoard(CSBoardVO vo) {
		System.out.println("고객문의 글 상세보기 ");
		return sqlSessionTemplate.selectOne("AdminCSBoardDAO.getCSBoard",vo);
	}
	
	public void insertAdminCSBoard(AdminCSBoardVO vo) {
		System.out.println("답변 입력 내용 저장");
		sqlSessionTemplate.insert("AdminCSBoardDAO.insertAdminCSBoard",vo);
	}
	
	public void updateReplyCheckCSBoard(CSBoardVO vo) {
		System.out.println("답변상태여부 완료 처리");
		sqlSessionTemplate.update("AdminCSBoardDAO.updateReplyCheckCSBoard",vo);
	}
	
}
