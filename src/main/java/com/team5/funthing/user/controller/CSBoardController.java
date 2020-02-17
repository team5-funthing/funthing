package com.team5.funthing.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.user.model.vo.CSBoardVO;
import com.team5.funthing.user.service.csboardService.InsertCSBoardService;

@Controller
public class CSBoardController {
	
	@Autowired
	private InsertCSBoardService insertCSBoardService;
	
	@RequestMapping("/insertCSBoard.udo")
	public String insertCSBoard(CSBoardVO vo) {
		System.out.println("컨트롤러 고객문의 인서트");
		
		insertCSBoardService.insertCSBoard(vo);
		
	    return "";
	}
	
}
