package com.team5.funthing.user.memberServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.memberService.UpdateMemberService;
import com.team5.funthing.user.model.dao.MemberDAO;

@Service
public class UpdateMemberServiceImpl implements UpdateMemberService{
	@Autowired
	MemberDAO memberDAO;
}
