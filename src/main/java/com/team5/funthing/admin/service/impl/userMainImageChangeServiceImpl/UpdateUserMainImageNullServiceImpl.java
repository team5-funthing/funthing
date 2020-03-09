package com.team5.funthing.admin.service.impl.userMainImageChangeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminUserMainImageChangeDAO;
import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.service.userMainImageChangeService.UpdateUserMainImageNullService;

@Service
public class UpdateUserMainImageNullServiceImpl implements UpdateUserMainImageNullService{

	@Autowired
	AdminUserMainImageChangeDAO adminUserMainImageChangeDAO;
	
	@Override
	public void updateUserMainImageNull(AdminUserMainImageChangeVO vo) {
		adminUserMainImageChangeDAO.updateUserMainImageNull(vo);
		
	}

}
