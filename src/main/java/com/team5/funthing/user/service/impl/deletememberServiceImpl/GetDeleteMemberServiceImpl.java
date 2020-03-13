package com.team5.funthing.user.service.impl.deletememberServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.deletememberService.GetDeleteMemberService;
@Service
public class GetDeleteMemberServiceImpl implements GetDeleteMemberService {

	

	@Autowired
	MemberDAO dao;
	public MemberVO getDeleteMemberTableMember(MemberVO vo) {
		
		return dao.getDeleteMemberTableMember(vo);
	}

}
