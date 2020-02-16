package com.team5.funthing.user.memberServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.memberService.SelectMemberService;
import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.model.vo.MemberVO;

@Service
public class SelectMemberServiceImpl implements SelectMemberService{

	 @Autowired
	   private MemberDAO memberDAO;
	   
	   @Override
	   public MemberVO loginMember(MemberVO vo) {
	      
	      return memberDAO.loginMember(vo);
	   }

	@Override
	public MemberVO getMember(MemberVO vo) {
		
		return memberDAO.getMember(vo);
	}

}
