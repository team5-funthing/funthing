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
		System.out.println("getMember 角青");
		return sqlSessionTemplate.selectOne("MemberDAO.getMember", vo);
	}
	
	
	public void insertMember (MemberVO vo) {
		System.out.println("insertMember 角青");
		sqlSessionTemplate.insert("MemberDAO.insertMember", vo);
	}
	
	public MemberVO loginMember(MemberVO vo) {
		System.out.println("loginMember 角青");
		return sqlSessionTemplate.selectOne("MemberDAO.loginMember", vo);
		
	}
	
	public MemberVO loginCheck(MemberVO vo) {
		System.out.println("loginCheck 角青");
		return sqlSessionTemplate.selectOne("MemberDAO.loginCheck", vo);
	}


	public int regEmailCheck(String email) {
		System.out.println("regEmailCheck 角青");
		return 0;
	}


	
	
	
}
