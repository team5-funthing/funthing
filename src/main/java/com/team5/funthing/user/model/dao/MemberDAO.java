package com.team5.funthing.user.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberVO getMember(MemberVO vo) {
		System.out.println("getMember ½ÇÇà");
		return sqlSessionTemplate.selectOne("MemberDAO.getMember", vo);
	}
	
	
}
