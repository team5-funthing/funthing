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
      System.out.println("insertSocialMember 角青");
      System.out.println(vo.toString());
      sqlSessionTemplate.insert("MemberDAO.insertSocialMember",vo);
   }
   
      
      public void insertMember (MemberVO vo) {
            System.out.println("insertMember 角青");
            sqlSessionTemplate.insert("MemberDAO.insertMember", vo);
         }
   
      public void saveImage(MemberVO vo) {
         System.out.println("saveImage 角青");
         sqlSessionTemplate.insert("MemberDAO.saveImage",vo);
      }
      
      public void updateMember(MemberVO vo) {
    	  System.out.println("updateMember 角青 ");
    	  sqlSessionTemplate.update("MemberDAO.updateMember",vo);
      }
      
      public void deleteMember(MemberVO vo) {
    	  System.out.println("deleteMember 角青");
    	  sqlSessionTemplate.delete("MemberDAO.deleteMember", vo);
      }
}