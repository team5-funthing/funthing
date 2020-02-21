package com.team5.funthing.admin.service.impl.adminMemberManagementServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminMemberManagementDAO;
import com.team5.funthing.admin.service.adminMemberManagementService.UpdateMakerMemberGradeService;
import com.team5.funthing.user.model.vo.MakerMemberVO;

@Service
public class UpdateMakerMemberGradeServiceImpl implements UpdateMakerMemberGradeService{

	@Autowired
	private AdminMemberManagementDAO adminMemberManagementDAO;
	
	@Override
	public void UpdateMakerMemberGrade(MakerMemberVO vo) {
		adminMemberManagementDAO.updateMakerMemberGrade(vo);
	}
	
}
