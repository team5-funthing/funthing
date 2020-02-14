package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.NoticeVO;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSessionTemplate noticeSqlSessionTemplate;
	
	public void insertNotice(NoticeVO vo) {
		System.out.println("�������� �Խ��ǿ� �� �Է�");
		noticeSqlSessionTemplate.insert("NoticeDAO.insertNotice", vo);
	}
	
	public void updateNotice(NoticeVO vo) {
		System.out.println("�������� �Խ��ǿ� �� ����");
		noticeSqlSessionTemplate.update("NoticeDAO.updateNotice", vo);
	}
	
	public void deleteNotice(NoticeVO vo) {
		System.out.println("�������� �Խ����� �� ����");
		noticeSqlSessionTemplate.delete("NoticeDAO.deleteNotice", vo);
	}
	
	public List<NoticeVO> selectNoticeList(NoticeVO vo){
		System.out.println("�������� ������ ��� ������");
		return noticeSqlSessionTemplate.selectList("NoticeDAO.selectNoticeList", vo);
	}
	
	public List<NoticeVO> selectEntireNoticeList(NoticeVO vo){
		System.out.println("�������� ��ü�� ��� ������");
		return noticeSqlSessionTemplate.selectList("NoticeDAO.selectEntireNoticeList",vo);
	}
	
	public List<NoticeVO> selectEventNoticeList(NoticeVO vo){
		System.out.println("�������� �̺�Ʈ�� ��� ������");
		return noticeSqlSessionTemplate.selectList("NoticeDAO.selectEventNoticeList",vo);
	}

	public NoticeVO selectNotice(NoticeVO vo) {
		System.out.println("�������� �� �� ������");
		return noticeSqlSessionTemplate.selectOne("NoticeDAO.selectNotice", vo);
	}
}
