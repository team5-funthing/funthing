package com.team5.funthing.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team5.funthing.admin.model.vo.AdminCSBoardVO;
import com.team5.funthing.admin.service.impl.adminCSBoardServiceImpl.InsertAdminCSBoardServiceImpl;
import com.team5.funthing.admin.service.impl.adminCSBoardServiceImpl.SelectCSBoardServiceImpl;
import com.team5.funthing.admin.service.impl.adminCSBoardServiceImpl.SelectEntireCSBoardListServiceImpl;
import com.team5.funthing.admin.service.impl.adminCSBoardServiceImpl.UpdateReplyCheckCSBoardServiceImpl;
import com.team5.funthing.user.model.vo.CSBoardVO;

@Controller
public class AdminCSBoardController {

	@Autowired
	private SelectEntireCSBoardListServiceImpl  selectEntireAdminCSBoardListServiceImpl;
	@Autowired
	private InsertAdminCSBoardServiceImpl insertAdminCSBoardServiceImpl;
	@Autowired
	private UpdateReplyCheckCSBoardServiceImpl updateReplyCheckCSBoardServiceImpl;
	@Autowired
	private SelectCSBoardServiceImpl selectCSBoardServiceImpl;
	
	private List<CSBoardVO> entireCSBoardList;
	private CSBoardVO selectCSBoard;
	
	@RequestMapping("selectEntireAdminCSBoardList.ado")
	public ModelAndView selectEntireAdminCSBoardList(CSBoardVO vo){
		//전체 목록
		entireCSBoardList = selectEntireAdminCSBoardListServiceImpl.selectEntireCSBoardList(vo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("entireCSBoardList",entireCSBoardList);
		mav.setViewName("");
		return mav; 
	}
	
	@RequestMapping("updateReplyCheckCSBoard.ado")
	public String updateReplyCheckCSBoard(CSBoardVO vo){
		
		updateReplyCheckCSBoardServiceImpl.updateReplyCheckCSBoard(vo);
		
		return "";
	}
	
	@RequestMapping("insertAdminCSBoard.ado")
	public String insertAdminCSBoard(AdminCSBoardVO vo){
		
		insertAdminCSBoardServiceImpl.insertAdminCSBoard(vo);
		
		return ""; 
	}
	
	@RequestMapping("selectCSBoard.ado")
	public ModelAndView selectCSBoard(CSBoardVO vo){
		
		selectCSBoard = selectCSBoardServiceImpl.selectCSBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("selectCSBoard",selectCSBoard);
		mav.setViewName("");
		return mav; 
	}
	
	
	
	
}
