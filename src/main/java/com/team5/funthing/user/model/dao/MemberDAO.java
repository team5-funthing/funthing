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
      return sqlSessionTemplate.selectOne("MemberDAO.getMember", vo);
   }
   
   public void insertSocialMember(MemberVO vo) {
      sqlSessionTemplate.insert("MemberDAO.insertSocialMember",vo);
   }
   
      
      public void insertMember (MemberVO vo) {
            sqlSessionTemplate.insert("MemberDAO.insertMember", vo);
         }
   
      public void saveImage(MemberVO vo) {
         sqlSessionTemplate.insert("MemberDAO.saveImage",vo);
      }
      
      public void updateMember(MemberVO vo) {
    	  sqlSessionTemplate.update("MemberDAO.updateMember",vo);
      }
      
      public void deleteMember(MemberVO vo) {
    	  sqlSessionTemplate.delete("MemberDAO.deleteMember", vo);
      }
      
      public void insertDeleteMember(MemberVO vo) {
    	  sqlSessionTemplate.insert("MemberDAO.insertabledeletemember",vo);
      }
      public MemberVO getDeleteMemberTableMember(MemberVO vo) {
    	  return sqlSessionTemplate.selectOne( "MemberDAO.getDeleteMember",vo);
      }
      
      public void deleteDeleteMemberTableMember() {
    	  sqlSessionTemplate.delete( "MemberDAO.deleteDeleteMemberTableMember");
      }
        
}