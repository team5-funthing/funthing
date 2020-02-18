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
		System.out.println("������ ��ü�� ��� ������");
		return adminCSBoardSqlSessionTemplate.selectList("AdminCSBoardDAO.selectEntireCSBoardList",vo);
	}
	
	public CSBoardVO selectCSBoard(CSBoardVO vo) {
		System.out.println("������ �� �󼼺��� ");
		return adminCSBoardSqlSessionTemplate.selectOne("AdminCSBoardDAO.selectCSBoard",vo);
	}
	
	public void insertAdminCSBoard(AdminCSBoardVO vo) {
		System.out.println("�亯 �Է� ���� ����");
		adminCSBoardSqlSessionTemplate.insert("AdminCSBoardDAO.insertAdminCSBoard",vo);
	}
	
	public void updateReplyCheckCSBoard(CSBoardVO vo) {
		System.out.println("�亯���¿��� �Ϸ� ó��");
		adminCSBoardSqlSessionTemplate.update("CSBoardDAO.updateReplyCheckCSBoard",vo);
	}
	
}
