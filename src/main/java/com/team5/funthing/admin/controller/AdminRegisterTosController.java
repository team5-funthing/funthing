package com.team5.funthing.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.admin.model.vo.AdminRegisterTosVO;
import com.team5.funthing.admin.service.adminRegisterTosService.DeleteRegisterTosService;
import com.team5.funthing.admin.service.adminRegisterTosService.GetRegisterTosListService;
import com.team5.funthing.admin.service.adminRegisterTosService.GetRegisterTosService;
import com.team5.funthing.admin.service.adminRegisterTosService.InsertRegisterTosSerivce;
import com.team5.funthing.admin.service.adminRegisterTosService.UpdateRegisterTosService;

@Controller
public class AdminRegisterTosController {

	@Autowired
	private GetRegisterTosService getRegisterTosService;
	@Autowired
	private UpdateRegisterTosService updateRegisterTosService;
	@Autowired
	private GetRegisterTosListService getRegisterTosListService;
	@Autowired
	private InsertRegisterTosSerivce insertRegisterTosService;
	@Autowired
	private DeleteRegisterTosService deleteRegisterTosService;
	
	@RequestMapping("inputRegiTos.ado")
	public String showRegitosInputPage() {
		
		return "f-regitos-input";
	}
	
	@RequestMapping("getRegisterTos.ado")
	public String getRegisterTos(AdminRegisterTosVO vo, Model model) {
		
		model.addAttribute("RegisterTos", getRegisterTosService.getRegisterTos(vo));
		
		return "f-regitos-input";
	}
	
	@RequestMapping(value="updateRegisterTos.ado", method=RequestMethod.POST)
	public String updateRegisterTos(AdminRegisterTosVO vo, Model model, HttpServletRequest request) {
		
		vo.setRegisterNo(Integer.parseInt(request.getParameter("no")));
		vo.setRegisterTosContent(request.getParameter("editor1"));
		updateRegisterTosService.updateRegisterTos(vo);
		
		model.addAttribute("RegisterTosList", getRegisterTosListService.getRegisterTosList(vo));
		return "b-regitos-list";
	}
	
	@RequestMapping(value="insertRegisterTos.ado", method=RequestMethod.POST)
	public String insertRegisterTos(AdminRegisterTosVO vo, Model model, HttpServletRequest request) {
		
		vo.setRegisterTosContent(request.getParameter("editor1"));
		insertRegisterTosService.InsertRegisterTos(vo);
		
		model.addAttribute("RegisterTosList", getRegisterTosListService.getRegisterTosList(vo));
		return "b-regitos-list";
	}
	
	@RequestMapping(value="deleteRegisterTos.ado", method=RequestMethod.POST)
	public String deleteRegisterTos(AdminRegisterTosVO vo, Model model, HttpServletRequest request) {
		
		vo.setRegisterNo(Integer.parseInt(request.getParameter("no")));
		deleteRegisterTosService.DeleteRegisterTos(vo);
		
		model.addAttribute("RegisterTosList", getRegisterTosListService.getRegisterTosList(vo));
		return "b-regitos-list";
	}
}
