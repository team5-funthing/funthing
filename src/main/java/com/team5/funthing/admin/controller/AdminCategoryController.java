package com.team5.funthing.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.admin.model.vo.AdminCategoryVO;
import com.team5.funthing.admin.service.adminCategoryService.DeleteCategoryService;
import com.team5.funthing.admin.service.adminCategoryService.GetCategoryListService;
import com.team5.funthing.admin.service.adminCategoryService.InsertCategoryService;

@Controller
public class AdminCategoryController {

	@Autowired
	GetCategoryListService getCategoryListService;
	@Autowired
	DeleteCategoryService deleteCategoryService;
	@Autowired
	InsertCategoryService insertCategoryService;
	
	
	@RequestMapping(value="insertCategory.ado", method=RequestMethod.POST)
	public String insertCategory(AdminCategoryVO vo) {
		
		insertCategoryService.insertCategory(vo);
		
		return "redirect:projectCategoryManagement.ado";
	}
	
	@RequestMapping("deleteCategory.ado")
	public String deleteCategory(AdminCategoryVO vo) {
		
		deleteCategoryService.deleteCategory(vo);
		
		return "redirect:projectCategoryManagement.ado";
	}
	
}
