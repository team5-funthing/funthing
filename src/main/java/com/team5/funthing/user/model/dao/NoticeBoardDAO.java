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
		System.out.println("�������� �Խ��ǿ� �� �Է�");
		return noticeSqlSessionTemplate.insert("NoticeBoardDAO.insertNoticeBoard", vo);
	}
	
	public int updateNoticeBoard(NoticeBoardVO vo) {
		System.out.println("�������� �Խ��ǿ� �� ����");
		return noticeSqlSessionTemplate.update("NoticeBoardDAO.updateNoticeBoard", vo);
	}
	
	public int deleteNoticeBoard(NoticeBoardVO vo) {
		System.out.println("�������� �Խ����� �� ����");
		return noticeSqlSessionTemplate.delete("NoticeBoardDAO.deleteNoticeBoard", vo);
	}
	
	public List<NoticeBoardVO> getNoticeBoardList(NoticeBoardVO vo){
		System.out.println("�������� ������ ��� ������");
		return noticeSqlSessionTemplate.selectList("NoticeBoardDAO.getNoticeBoardList", vo);
	}
	
	public List<NoticeBoardVO> getRealNoticeBoardList(String category){
		System.out.println("�����۸� �ҷ�����");
		return noticeSqlSessionTemplate.selectList("NoticeBoardDAO.getRealNoticeBoardList",category);
	}

	public NoticeBoardVO getNoticeBoard(NoticeBoardVO vo) {
		System.out.println("�������� �� �� ������");
		return noticeSqlSessionTemplate.selectOne("NoticeBoardDAO.getNoticeBoard", vo);
	}
	
	public List<NoticeBoardVO> getSearchNoticeBoardList(NoticeBoardVO vo){
		System.out.println("�������� �˻��Ͽ� ��� ������");
		return noticeSqlSessionTemplate.selectList("NoticeBoardDAO.getSearchNoticeBoardList", vo);
	}
	
//	public int selectNoticeCount(NoticeVO vo) {
//		return noticeSqlSessionTemplate.selectOne("NoticeDAO.selectNoticeCount",vo);
//	}
}
