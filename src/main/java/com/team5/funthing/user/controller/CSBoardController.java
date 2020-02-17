package com.team5.funthing.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team5.funthing.user.model.vo.CSBoardVO;
import com.team5.funthing.user.model.vo.NoticeVO;
import com.team5.funthing.user.service.impl.csboardServiceImpl.insertCSBoardServiceImpl;

@Controller
public class CSBoardController {
	
	@Autowired
	private insertCSBoardServiceImpl insertCSBoardServiceImpl;
	
	
	@RequestMapping("/insertCSBoardForm.udo")
	public String insertCSBoardForm() {
		
	    return "b-csboard2";
	}
	
	@RequestMapping("/insertCSBoard.udo")
	public String insertCSBoard(CSBoardVO vo) {
		System.out.println("컨트롤러 고객문의 인서트");
		
		insertCSBoardServiceImpl.insertCSBoard(vo);
		
	    return "p-index";
	}
	
}
