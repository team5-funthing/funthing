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
		System.out.println("getMember ");
		return sqlSessionTemplate.selectOne("MemberDAO.getMember", vo);
	}
	
	public void insertSocialMember(MemberVO vo) {
		System.out.println("insertSocialMember 실행");
		System.out.println(vo.toString());
		sqlSessionTemplate.insert("MemberDAO.insertSocialMember",vo);
	}
	
	   public MemberVO loginMember(MemberVO vo) {
		      System.out.println("loginMember 실행");
		      return sqlSessionTemplate.selectOne("MemberDAO.loginMember", vo);
		      
		   }
	   
	   public void insertMember (MemberVO vo) {
		      System.out.println("insertMember 실행");
		      sqlSessionTemplate.insert("MemberDAO.insertMember", vo);
		   }
	
	   public void saveImage(MemberVO vo) {
		   System.out.println("saveImage 실행");
		   sqlSessionTemplate.insert("MemberDAO.saveImage",vo);
	   }
}
