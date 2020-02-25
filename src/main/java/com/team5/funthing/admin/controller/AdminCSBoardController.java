package com.team5.funthing.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team5.funthing.admin.model.vo.AdminCSBoardVO;
import com.team5.funthing.admin.service.adminCSBoardService.InsertAdminCSBoardService;
import com.team5.funthing.admin.service.adminCSBoardService.GetCSBoardService;
import com.team5.funthing.admin.service.adminCSBoardService.GetCSBoardListService;
import com.team5.funthing.admin.service.adminCSBoardService.UpdateReplyCheckCSBoardService;
import com.team5.funthing.common.utils.SendMailUtil;
import com.team5.funthing.user.model.vo.CSBoardVO;

@Controller
public class AdminCSBoardController {

	@Autowired
	private GetCSBoardListService  getAdminCSBoardListService;
	@Autowired
	private InsertAdminCSBoardService insertAdminCSBoardService;
	@Autowired
	private UpdateReplyCheckCSBoardService updateReplyCheckCSBoardService;
	@Autowired
	private GetCSBoardService getCSBoardService;

	@Autowired
	private SendMailUtil sendMailUtil;

	private List<CSBoardVO> csBoardList;
	private CSBoardVO getCSBoard;
	
	
	@RequestMapping("getAdminCSBoardList.ado")
	public ModelAndView selectEntireAdminCSBoardList(CSBoardVO vo){

		csBoardList = getAdminCSBoardListService.getCSBoardList(vo);
	

		ModelAndView mav = new ModelAndView();
		mav.addObject("csBoardList",csBoardList);
		mav.setViewName("b-customerService");
		return mav; 
	}
  
	@RequestMapping("insertAdminCSBoard.ado")
	public String insertAdminCSBoard(AdminCSBoardVO avo,CSBoardVO cvo) throws UnsupportedEncodingException, MessagingException{
		
		avo.setAdminCSTitle("[���Ǵ亯]re:"+cvo.getCsTitle());	
		avo.setAdminID("admin");
		
		insertAdminCSBoardService.insertAdminCSBoard(avo);
		updateReplyCheckCSBoardService.updateReplyCheckCSBoard(cvo);

		sendMailUtil.sendMail(avo.getAdminCSTitle(), avo.getAdminCSContent(),cvo.getEmail());

		
		return "redirect:getAdminCSBoardList.ado"; 
	}

	
	@RequestMapping("getCSBoard.ado")
	public ModelAndView selectCSBoard(CSBoardVO vo,HttpServletRequest request){
		int CSID=Integer.parseInt(request.getParameter("CSID"));
		vo.setCSID(CSID);

		
		getCSBoard = getCSBoardService.getCSBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("getCSBoard",getCSBoard);
		mav.setViewName("p-customerService-detail");
		return mav; 
	}
	
	
	
	
}
