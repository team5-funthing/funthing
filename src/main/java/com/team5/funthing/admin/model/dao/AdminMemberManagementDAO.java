package com.team5.funthing.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.MakerMemberVO;
import com.team5.funthing.user.model.vo.MemberVO;

@Repository
public class AdminMemberManagementDAO {
		
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<MemberVO> getMemberList(MemberVO vo){	
		return sqlSessionTemplate.selectList("AdminMemberManagementDAO.getMemberList", vo);
	}

	public MemberVO getMember(MemberVO vo) {
		return sqlSessionTemplate.selectOne("AdminMemberManagementDAO.getMember", vo);
	}
	
	public void updateMakerMemberGrade(MakerMemberVO vo) {
		sqlSessionTemplate.update("AdminMemberManagementDAO.updateMakerMemberGrade",vo);
	}
	
	public List<MemberVO> getMemberJoinMaker(MemberVO vo){
		return sqlSessionTemplate.selectList("AdminMemberManagementDAO.getMemberJoinMaker", vo);
	}
	
}
