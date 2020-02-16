package com.team5.funthing.user.memberService;

import com.team5.funthing.user.model.vo.MemberVO;

public interface SelectMemberService {
	 
	
	public MemberVO loginMember(MemberVO vo);
		
	public MemberVO getMember(MemberVO vo);
}
