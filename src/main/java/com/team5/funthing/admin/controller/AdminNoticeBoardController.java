package com.team5.funthing.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team5.funthing.admin.model.vo.AdminNoticeBoardVO;
import com.team5.funthing.admin.service.adminNoticeBoardService.DeleteAdminNoticeBoardService;
import com.team5.funthing.admin.service.adminNoticeBoardService.GetAdminNoticeBoardListService;
import com.team5.funthing.admin.service.adminNoticeBoardService.GetAdminNoticeBoardService;
import com.team5.funthing.admin.service.adminNoticeBoardService.InsertAdminNoticeBoardService;
import com.team5.funthing.admin.service.adminNoticeBoardService.UpdateAdminNoticeBoardService;

@Controller
public class AdminNoticeBoardController {

	@Autowired
	InsertAdminNoticeBoardService insertAdminNoticeBoardService;
	@Autowired
	GetAdminNoticeBoardService getAdminNoticeBoardService;
	@Autowired
	GetAdminNoticeBoardListService getAdminNoticeBoardListService;
	@Autowired
	UpdateAdminNoticeBoardService updateAdminNoticeBoardService;
	@Autowired
	DeleteAdminNoticeBoardService deleteAdminNoticeBoardService;
	
	@RequestMapping("insertAdminBoard.ado")
	public String insertAdminBoardList() {
		return "f-notice-input";
	}
	
	@RequestMapping("insertAdminNoticeBoard.ado")
	public String insertAdminNoticeBoard(AdminNoticeBoardVO vo, Model model, 
										HttpServletRequest request,HttpSession session) {
		String noticeContents = request.getParameter("editor1");
		
		vo.setAdminId((String)session.getAttribute("adminSessionEmail"));//세션으로 들어오는 아이디값으로 바꿔줄것
		vo.setNoticeContents(noticeContents);
		
		insertAdminNoticeBoardService.insertNoticeBoard(vo);
		model.addAttribute("entireBoardList", getAdminNoticeBoardListService.getNoticeBoardList(vo));
		return "b-notice-list";
	}
	
	@RequestMapping("getAdminNoticeBoard.ado")
	public String getAdminNoticeBoard(HttpServletRequest request, Model model,AdminNoticeBoardVO vo) {
		
		int no = Integer.parseInt(request.getParameter("no"));
		vo.setNoticeNo(no);
		
		vo = getAdminNoticeBoardService.getNoticeBoard(vo);
		model.addAttribute("vo",vo);
		return "f-notice-input";
	}
	
	@RequestMapping("updateAdminNoticeBoard.ado")
	public String updateAdminNoticeBoard(HttpServletRequest request, AdminNoticeBoardVO vo, Model model,@RequestParam("editor1")String str) {

		int no = Integer.parseInt(request.getParameter("no"));
		vo.setNoticeNo(no);
		
		vo.setNoticeContents(str);
		updateAdminNoticeBoardService.updateNoticeBoard(vo);
		model.addAttribute("entireBoardList", getAdminNoticeBoardListService.getNoticeBoardList(vo));
		return "b-notice-list";
	}
	
	@RequestMapping("deleteAdminNoticeBoard.ado")
	public String deleteAdminNoticeBoard(HttpServletRequest request, AdminNoticeBoardVO vo) {
		int no = Integer.parseInt(request.getParameter("no"));
		vo.setNoticeNo(no);
		deleteAdminNoticeBoardService.deleteNoticeBoard(vo);
		
		return "forward:adminNoticeInput.ado";
	}
	
}
