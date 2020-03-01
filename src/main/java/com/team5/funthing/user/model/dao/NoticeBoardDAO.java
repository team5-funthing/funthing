package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.NoticeBoardVO;

@Repository
public class NoticeBoardDAO {
	
	@Autowired
	private SqlSessionTemplate noticeSqlSessionTemplate;
	
	public int insertNoticeBoard(NoticeBoardVO vo) {
		System.out.println("공지사항 게시판에 글 입력");
		return noticeSqlSessionTemplate.insert("NoticeBoardDAO.insertNoticeBoard", vo);
	}
	
	public int updateNoticeBoard(NoticeBoardVO vo) {
		System.out.println("공지사항 게시판에 글 수정");
		return noticeSqlSessionTemplate.update("NoticeBoardDAO.updateNoticeBoard", vo);
	}
	
	public int deleteNoticeBoard(NoticeBoardVO vo) {
		System.out.println("공지사항 게시판의 글 삭제");
		return noticeSqlSessionTemplate.delete("NoticeBoardDAO.deleteNoticeBoard", vo);
	}
	
	public List<NoticeBoardVO> getNoticeBoardList(NoticeBoardVO vo){
		System.out.println("공지사항 공지글 목록 얻어오기");
		return noticeSqlSessionTemplate.selectList("NoticeBoardDAO.getNoticeBoardList", vo);
	}
	
	public List<NoticeBoardVO> getRealNoticeBoardList(String category){
		System.out.println("공지글만 불러오기");
		return noticeSqlSessionTemplate.selectList("NoticeBoardDAO.getRealNoticeBoardList",category);
	}

	public NoticeBoardVO getNoticeBoard(NoticeBoardVO vo) {
		System.out.println("공지사항 상세 글 얻어오기");
		return noticeSqlSessionTemplate.selectOne("NoticeBoardDAO.getNoticeBoard", vo);
	}
	
	public List<NoticeBoardVO> getSearchNoticeBoardList(NoticeBoardVO vo){
		System.out.println("공지사항 검색하여 목록 얻어오기");
		return noticeSqlSessionTemplate.selectList("NoticeBoardDAO.getSearchNoticeBoardList", vo);
	}
	
//	public int selectNoticeCount(NoticeVO vo) {
//		return noticeSqlSessionTemplate.selectOne("NoticeDAO.selectNoticeCount",vo);
//	}
}
