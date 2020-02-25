package com.team5.funthing.user.service.impl.memberServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.memberService.GetMemberService;

@Service
public class GetMemberServiceImpl implements GetMemberService{

	@Autowired
	private MemberDAO memberDAO;
	   


	@Override
	public MemberVO getMember(MemberVO vo) {
		
		return memberDAO.getMember(vo);
	}




}
