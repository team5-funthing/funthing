package com.team5.funthing.admin.service.impl.userMainImageChangeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminUserMainImageChangeDAO;
import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.service.userMainImageChangeService.UpdateUserMainImageContentNullService;

@Service
public class UpdateUserMainImageContentNullServiceImpl implements UpdateUserMainImageContentNullService{

	@Autowired
	AdminUserMainImageChangeDAO adminUserMainImageChangeDAO;
	
	@Override
	public void updateUserMainImageContentNullService(AdminUserMainImageChangeVO vo) {
		
		adminUserMainImageChangeDAO.updateUserMainImageContentNull(vo);
	}

}
