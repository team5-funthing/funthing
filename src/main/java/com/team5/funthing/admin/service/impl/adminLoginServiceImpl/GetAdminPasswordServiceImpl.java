package com.team5.funthing.admin.service.impl.adminLoginServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminLoginDAO;
import com.team5.funthing.admin.model.vo.AdminMemberVO;
import com.team5.funthing.admin.service.adminLoginService.GetAdminPasswordService;

@Service
public class GetAdminPasswordServiceImpl implements GetAdminPasswordService {

	@Autowired
	private AdminLoginDAO adminLoginDAO;
	
	@Override
	public AdminMemberVO getAdminPassword(AdminMemberVO vo) {
		return adminLoginDAO.getAdminPassword(vo);
	}

}
