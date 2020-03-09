package com.team5.funthing.admin.service.impl.adminCategoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminCategoryDAO;
import com.team5.funthing.admin.model.vo.AdminCategoryVO;
import com.team5.funthing.admin.service.adminCategoryService.InsertCategoryService;

@Service
public class InsertCategoryServiceImpl implements InsertCategoryService {

	@Autowired
	private AdminCategoryDAO categoryDAO;
	
	@Override
	public int insertCategory(AdminCategoryVO vo) {
		return categoryDAO.insertCategory(vo);
	}

}
