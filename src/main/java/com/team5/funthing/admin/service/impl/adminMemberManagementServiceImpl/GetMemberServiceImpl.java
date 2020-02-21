package com.team5.funthing.admin.service.impl.adminMemberManagementServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminMemberManagementDAO;
import com.team5.funthing.admin.service.adminMemberManagementService.GetMemberService;
import com.team5.funthing.user.model.vo.MemberVO;

@Service
public class GetMemberServiceImpl implements GetMemberService{

	@Autowired
	private AdminMemberManagementDAO adminMemberManagementDAO;
	
	@Override
	public MemberVO getMember(MemberVO vo) {
		return adminMemberManagementDAO.getMember(vo);
	}
	
	

}
