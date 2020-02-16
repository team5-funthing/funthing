package com.team5.funthing.user.memberService;

import com.team5.funthing.user.model.vo.MemberVO;

public interface InsertMemberService {


	public void insertSocialMember(MemberVO vo);

	public void insertMember(MemberVO vo);

	public void saveImage(MemberVO vo);
}
