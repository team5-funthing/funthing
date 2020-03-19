package com.team5.funthing.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.admin.model.vo.AdminCategoryVO;
import com.team5.funthing.admin.service.adminCategoryService.DeleteCategoryService;
import com.team5.funthing.admin.service.adminCategoryService.GetCategoryListService;
import com.team5.funthing.admin.service.adminCategoryService.GetCategoryService;
import com.team5.funthing.admin.service.adminCategoryService.InsertCategoryService;

@Controller
public class AdminCategoryController {

	@Autowired
	GetCategoryListService getCategoryListService;
	@Autowired
	GetCategoryService getCategoryService;
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
	
	@RequestMapping("checkDuplicateCategory.ado")
	public String checkDuplicateCategory(AdminCategoryVO vo ,Model model ,String inputCategory) {
		
		vo.setCategoryName(inputCategory);
		AdminCategoryVO category = getCategoryService.getCategory(vo);
		
		if(category==null) {
			model.addAttribute("listResult", "입력가능한 카테고리 입니다.");
			System.out.println("중복없음");
		}else {
			model.addAttribute("listResult", "중복된 카테고리가 있습니다.");
			System.out.println("중복있음");
		}
		
		return "/ajax/checkCategory";
	}
}
