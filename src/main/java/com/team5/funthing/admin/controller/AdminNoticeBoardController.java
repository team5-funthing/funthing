package com.team5.funthing.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team5.funthing.admin.model.vo.AdminNoticeBoardVO;
import com.team5.funthing.admin.service.adminNoticeBoardService.DeleteAdminNoticeBoardService;
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
	UpdateAdminNoticeBoardService updateAdminNoticeBoardService;
	@Autowired
	DeleteAdminNoticeBoardService deleteAdminNoticeBoardService;
	
	@RequestMapping("insertAdminBoard.ado")
	public String insertAdminBoardList() {
		return "f-notice-input";
	}
	
	@RequestMapping("insertAdminNoticeBoard.ado")
	public String insertAdminNoticeBoard(AdminNoticeBoardVO vo, HttpServletRequest request) {
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeCategory = request.getParameter("noticeCategory");
		String noticeContents = request.getParameter("editor1");
		
		vo.setAdminId("admin@funthing.com");//세션으로 들어오는 아이디값으로 바꿔줄것
		vo.setNoticeTitle(noticeTitle);
		vo.setNoticeCategory(noticeCategory);
		vo.setNoticeContents(noticeContents);
		
		insertAdminNoticeBoardService.insertNoticeBoard(vo);
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
	public String updateAdminNoticeBoard(AdminNoticeBoardVO vo, Model model,@RequestParam("editor1")String str) {

		vo.setNoticeContents(str);
		updateAdminNoticeBoardService.updateNoticeBoard(vo);
		
		return "b-notice-list";
	}
	
	@RequestMapping("deleteAdminNoticeBoard.ado")
	public String deleteAdminNoticeBoard(AdminNoticeBoardVO vo) {
		
		deleteAdminNoticeBoardService.deleteNoticeBoard(vo);
		
		return "forward:adminNoticeInput.ado";
	}
	
}
