package com.team5.funthing.admin.service.adminCategoryService;

import java.util.List;

import com.team5.funthing.admin.model.vo.AdminCategoryVO;

public interface GetCategoryListService {

	public List<AdminCategoryVO> getCategoryList(AdminCategoryVO vo);
	
}
