package com.team5.funthing.user.service.impl.deletememberServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.deletememberService.InsertDeleteMemberTableService;

@Service
public class InsertDeleteMemberTableServiceImpl implements InsertDeleteMemberTableService {

	@Autowired
	MemberDAO dao;
	@Override
	public void insertDeleteMemberTableService(MemberVO vo) {
		dao.insertDeleteMember(vo);
		
	}

}
