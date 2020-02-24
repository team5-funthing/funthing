package com.team5.funthing.admin.service.impl.adminMemberManagementServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminMemberManagementDAO;
import com.team5.funthing.admin.service.adminMemberManagementService.GetMemberJoinMakerDetailService;
import com.team5.funthing.user.model.vo.MemberVO;


@Service
public class GetMemberJoinMakerDetailServiceImpl implements GetMemberJoinMakerDetailService {

	@Autowired
	private AdminMemberManagementDAO adminMemberManagementDAO;
	
	@Override
	public MemberVO GetMemberJoinMakerDetail(MemberVO vo) {
		
		return adminMemberManagementDAO.getMemberJoinMakerDetail(vo);
	}

}
