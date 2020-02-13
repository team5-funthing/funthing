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
		System.out.println("공지사항 게시판에 글 입력");
		noticeSqlSessionTemplate.insert("NoticeDAO.insertNotice", vo);
	}
	
	public void updateNotice(NoticeVO vo) {
		System.out.println("공지사항 게시판에 글 수정");
		noticeSqlSessionTemplate.update("NoticeDAO.updateNotice", vo);
	}
	
	public void deleteNotice(NoticeVO vo) {
		System.out.println("공지사항 게시판의 글 삭제");
		noticeSqlSessionTemplate.delete("NoticeDAO.deleteNotice", vo);
	}
	
	public List<NoticeVO> selectNoticeList(NoticeVO vo){
		System.out.println("공지사항 글 목록 얻어오기");
		return noticeSqlSessionTemplate.selectList("NoticeDAO.selectEntireNoticeList", vo);
	}
	
}
