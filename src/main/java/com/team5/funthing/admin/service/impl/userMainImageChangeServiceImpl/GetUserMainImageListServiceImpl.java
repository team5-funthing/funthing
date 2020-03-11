package com.team5.funthing.admin.service.impl.userMainImageChangeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminUserMainImageChangeDAO;
import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.service.userMainImageChangeService.GetUserMainImageListService;

@Service
public class GetUserMainImageListServiceImpl implements GetUserMainImageListService {

	@Autowired
	AdminUserMainImageChangeDAO adminUserMainImageChangeDAO;
	
	@Override
	public List<AdminUserMainImageChangeVO> getUserMainImageList() {
		
		return adminUserMainImageChangeDAO.getUserMainImageList();
	}

}
