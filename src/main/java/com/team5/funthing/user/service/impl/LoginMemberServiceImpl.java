package com.team5.funthing.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.LoginMemberService;

@Service
public class LoginMemberServiceImpl implements LoginMemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public MemberVO loginMember(MemberVO vo) {
		
		return memberDAO.loginMember(vo);
	}

}
