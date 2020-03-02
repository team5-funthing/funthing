package com.team5.funthing.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.TosVO;
import com.team5.funthing.user.service.TosService.DeleteTosService;
import com.team5.funthing.user.service.TosService.GetTosListService;
import com.team5.funthing.user.service.TosService.GetTosService;
import com.team5.funthing.user.service.TosService.InsertTosService;
import com.team5.funthing.user.service.TosService.UpdateTosService;

@Controller
public class AdminTosController {

	@Autowired
	UpdateTosService updateTosService;
	@Autowired
	DeleteTosService deleteTosService;
	@Autowired
	InsertTosService insertTosService;
	@Autowired
	GetTosListService getTosListService;
	@Autowired
	GetTosService getTosService;
	
	@RequestMapping("inputTos.ado")
	public String showInputTos() {
		return "f-clause-input";
	}
	
	@RequestMapping(value="getTos.ado", method=RequestMethod.GET)
	public String getTos(TosVO vo, Model model) {
		
		TosVO getTos = getTosService.getTos(vo);
		model.addAttribute("tos", getTos);
		
		return "f-clause-input";
	}
	
	@RequestMapping("updateTos.ado")
	public String updateTos(TosVO vo, Model model, HttpServletRequest request) {
		
		int tosNo = Integer.parseInt(request.getParameter("no"));
		String tosContent = request.getParameter("editor1");
		vo.setTosNo(tosNo);
		vo.setTosContent(tosContent);
		
		updateTosService.updateTos(vo);
		model.addAttribute("TosList", getTosListService.getTosList(vo));
		
		return "b-tos-list";
	}
	
	@RequestMapping("insertTos.ado")
	public String insertTos(TosVO vo, Model model, HttpServletRequest request) {
		
		String tosContent = request.getParameter("editor1");
		vo.setTosContent(tosContent);
		
		insertTosService.InsertTos(vo);
		
		model.addAttribute("TosList", getTosListService.getTosList(vo));
		
		return "b-tos-list";
	}
	
	@RequestMapping("deleteTos.ado")
	public String deleteTos(TosVO vo, Model model, HttpServletRequest request) {
		int tosNo = Integer.parseInt(request.getParameter("no"));
		vo.setTosNo(tosNo);
		deleteTosService.DeleteTos(vo);
		model.addAttribute("TosList", getTosListService.getTosList(vo));
		return "b-tos-list";
	}
	
}
