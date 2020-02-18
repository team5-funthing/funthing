package com.team5.funthing.user.service.impl.memberServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.service.memberService.DeleteMemberService;

@Service
public class DeleteMemberServiceImpl implements DeleteMemberService {

	@Autowired
	MemberDAO memberDAO;
}
