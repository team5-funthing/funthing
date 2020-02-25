package com.team5.funthing.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.user.model.vo.CSBoardVO;
import com.team5.funthing.user.service.csboardService.InsertCSBoardService;

@Controller
public class CSBoardController {
	
	@Autowired
	private InsertCSBoardService insertCSBoardService;
		
	@RequestMapping("cstest.udo")
	public String cstest() {
		//입력 폼으로 이동하는 메소드
	    return "p-csboard-input";
	}
	
	
	@RequestMapping("insertCSBoard.udo")
	public String insertCSBoard(CSBoardVO vo) {
		//폼에 입력한 값 DB에 넣은 후 다시 폼으로 이동
		insertCSBoardService.insertCSBoard(vo);
	    return "p-csboard-input";
	}
	
	
	
}
