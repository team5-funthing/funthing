package com.team5.funthing.user.memberServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.memberService.InsertSocialMemberService;
import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.model.vo.MemberVO;

@Service
public class InsertSocialMemberServiceImpl implements InsertSocialMemberService{
	@Autowired
	MemberDAO memberDAO;

	@Override
	public void insertSocialMember(MemberVO vo) {
		memberDAO.insertSocialMember(vo);
	}
}
