package com.team5.funthing.admin.service.impl.adminMemberManagementServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminMemberManagementDAO;
import com.team5.funthing.admin.service.adminMemberManagementService.GetMemberListService;
import com.team5.funthing.user.model.vo.MemberVO;
@Service
public class GetMemberListServiceImpl implements GetMemberListService{

	@Autowired
	private AdminMemberManagementDAO adminMemberManagementDAO;
	
	@Override
	public List<MemberVO> getMemberList(MemberVO vo) {
		
		return adminMemberManagementDAO.getMemberList(vo);
	}

}
