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
		System.out.println("공지사항 공지글 목록 얻어오기");
		return noticeSqlSessionTemplate.selectList("NoticeDAO.selectNoticeList", vo);
	}
	
	public List<NoticeVO> selectEntireNoticeList(NoticeVO vo){
		System.out.println("공지사항 전체글 목록 얻어오기");
		return noticeSqlSessionTemplate.selectList("NoticeDAO.selectEntireNoticeList",vo);
	}
	
	public List<NoticeVO> selectEventNoticeList(NoticeVO vo){
		System.out.println("공지사항 이벤트글 목록 얻어오기");
		return noticeSqlSessionTemplate.selectList("NoticeDAO.selectEventNoticeList",vo);
	}

	public NoticeVO selectNotice(NoticeVO vo) {
		System.out.println("공지사항 상세 글 얻어오기");
		return noticeSqlSessionTemplate.selectOne("NoticeDAO.selectNotice", vo);
	}
}
