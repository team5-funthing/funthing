package com.team5.funthing.user.service.impl.memberServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.memberService.InsertMemberService;

@Service
public class InsertMemberServiceImpl implements InsertMemberService {

	@Autowired
	MemberDAO memberDAO;

	
	
	@Override
	   public void insertMember(MemberVO vo) {
	      memberDAO.insertMember(vo);
	   }


}
