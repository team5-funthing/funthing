package com.team5.funthing.admin.service.impl.userMainImageChangeServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminUserMainImageChangeDAO;
import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.service.userMainImageChangeService.GetUserMainImageListService;

@Service
public class GetUserMainImageListServiceImpl implements GetUserMainImageListService {

	private
	AdminUserMainImageChangeDAO adminUserMainImageChangeDAO;
	
	@Override
	public List<AdminUserMainImageChangeVO> getUserMainImageList() {
		
		return adminUserMainImageChangeDAO.getUserMainImageChange();
	}

}
