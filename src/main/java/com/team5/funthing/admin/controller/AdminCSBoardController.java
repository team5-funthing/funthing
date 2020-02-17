package com.team5.funthing.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team5.funthing.admin.model.vo.AdminCSBoardVO;
import com.team5.funthing.admin.service.adminCSBoardService.InsertAdminCSBoardService;
import com.team5.funthing.admin.service.adminCSBoardService.SelectCSBoardService;
import com.team5.funthing.admin.service.adminCSBoardService.SelectEntireCSBoardListService;
import com.team5.funthing.admin.service.adminCSBoardService.UpdateReplyCheckCSBoardService;
import com.team5.funthing.user.memberService.CertificationEmailService;
import com.team5.funthing.user.model.vo.CSBoardVO;
import com.team5.funthing.user.model.vo.MemberVO;

@Controller
public class AdminCSBoardController {

	@Autowired
	private SelectEntireCSBoardListService  selectEntireAdminCSBoardListService;
	@Autowired
	private InsertAdminCSBoardService insertAdminCSBoardService;
	@Autowired
	private UpdateReplyCheckCSBoardService updateReplyCheckCSBoardService;
	@Autowired
	private SelectCSBoardService selectCSBoardService;
	@Autowired
	private CertificationEmailService certificationEmailService;
	@Autowired
	private JavaMailSender jms;
	
	private List<CSBoardVO> entireCSBoardList;
	private CSBoardVO selectCSBoard;
	
	
	@RequestMapping("selectEntireAdminCSBoardList.ado")
	public ModelAndView selectEntireAdminCSBoardList(CSBoardVO vo){
		//��ü ���
		entireCSBoardList = selectEntireAdminCSBoardListService.selectEntireCSBoardList(vo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("entireCSBoardList",entireCSBoardList);
		mav.setViewName("");
		return mav; 
	}
	
	@RequestMapping("insertAdminCSBoard.ado")
	public String insertAdminCSBoard(AdminCSBoardVO avo,CSBoardVO cvo){
		
		insertAdminCSBoardService.insertAdminCSBoard(avo);
		updateReplyCheckCSBoardService.updateReplyCheckCSBoard(cvo);

		
		return ""; 
	}
	
	@RequestMapping("selectCSBoard.ado")
	public ModelAndView selectCSBoard(CSBoardVO vo){
		
		selectCSBoard = selectCSBoardService.selectCSBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("selectCSBoard",selectCSBoard);
		mav.setViewName("");
		return mav; 
	}
	
	
	
	
}
