package com.team5.funthing.admin.service.impl.adminCategoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminCategoryDAO;
import com.team5.funthing.admin.model.vo.AdminCategoryVO;
import com.team5.funthing.admin.service.adminCategoryService.DeleteCategoryService;

@Service
public class DeleteCategoryServiceImpl implements DeleteCategoryService {

	@Autowired
	private AdminCategoryDAO categoryDAO;
	
	@Override
	public int deleteCategory(AdminCategoryVO vo) {
		return categoryDAO.deleteCategory(vo);
	}

}
