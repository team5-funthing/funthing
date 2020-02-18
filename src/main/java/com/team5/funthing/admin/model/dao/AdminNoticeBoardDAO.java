package com.team5.funthing.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminNoticeBoardVO;

@Repository
public class AdminNoticeBoardDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<AdminNoticeBoardVO> getNoticeBoardList(AdminNoticeBoardVO vo){
		return sqlSessionTemplate.selectList("AdminNoticeBoardDAO.getNoticeBoardList",vo);
	}
	
	public AdminNoticeBoardVO getNoticeBoard(AdminNoticeBoardVO vo) {
		return sqlSessionTemplate.selectOne("AdminNoticeBoardDAO.getNoticeBoard", vo);
	}
	
	public int insertNoticeBoard(AdminNoticeBoardVO vo) {
		return sqlSessionTemplate.insert("AdminNoticeBoardDAO.insertNoticeBoard",vo);
	}
	
	public int updateNoticeBoard(AdminNoticeBoardVO vo) {
		return sqlSessionTemplate.update("AdminNoticeBoardDAO.updateNoticeBoard",vo);
	}
	
	public int deleteNoticeBoard(AdminNoticeBoardVO vo) {
		return sqlSessionTemplate.delete("AdminNoticeBoardDAO.deleteNoticeBoard",vo);
	}
	
}
