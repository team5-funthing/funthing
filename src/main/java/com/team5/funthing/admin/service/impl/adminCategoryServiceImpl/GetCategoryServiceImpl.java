package com.team5.funthing.admin.service.impl.adminCategoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminCategoryDAO;
import com.team5.funthing.admin.model.vo.AdminCategoryVO;
import com.team5.funthing.admin.service.adminCategoryService.GetCategoryService;

@Service
public class GetCategoryServiceImpl implements GetCategoryService {

	@Autowired
	private AdminCategoryDAO adminCategoryDAO;
	
	@Override
	public AdminCategoryVO getCategory(AdminCategoryVO vo) {
		return adminCategoryDAO.getCategory(vo);
	}

}
