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
		//�Է� ������ �̵��ϴ� �޼ҵ�
	    return "p-csboard-input";
	}
	
	
	@RequestMapping("insertCSBoard.udo")
	public String insertCSBoard(CSBoardVO vo) {
		//���� �Է��� �� DB�� ���� �� �ٽ� ������ �̵�
		insertCSBoardService.insertCSBoard(vo);
	    return "p-csboard-input";
	}
	
	
	
}
