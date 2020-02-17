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
		System.out.println("��Ʈ�ѷ� ������ �μ�Ʈ");
		
		insertCSBoardService.insertCSBoard(vo);
		
	    return "";
	}
	
}
