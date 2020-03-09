package com.team5.funthing.admin.service.impl.adminCategoryServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminCategoryDAO;
import com.team5.funthing.admin.model.vo.AdminCategoryVO;
import com.team5.funthing.admin.service.adminCategoryService.GetCategoryListService;

@Service
public class GetCategoryListServiceImpl implements GetCategoryListService {

	@Autowired
	private AdminCategoryDAO categoryDAO;
	
	@Override
	public List<AdminCategoryVO> getCategoryList(AdminCategoryVO vo) {
		return categoryDAO.getCategoryList(vo);
	}

}
