package com.team5.funthing.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.CSBoardVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.csboardService.GetUserCSBoardService;
import com.team5.funthing.user.service.csboardService.InsertCSBoardService;

@Controller
public class CSBoardController {

	@Autowired
	private InsertCSBoardService insertCSBoardService;

	@Autowired
	private GetUserCSBoardService getCSBoardService;


	@RequestMapping(value="CSWrite.udo")   
	public String userAskGo(HttpServletRequest request,Model model,CSBoardVO vo) {
		if(request.getParameter("csid")==null) {
			return "f-CSWrite";
			
		}else {
			int csid = Integer.parseInt(request.getParameter("csid"));
			vo.setCsid(csid);
			model.addAttribute("askForAdmin",getCSBoardService.getCSBoard(vo));
			
			return "f-CSWrite";
		}
		
	}

	@RequestMapping(value="insertCSBoard.udo",method=RequestMethod.POST)
	public String insertCSBoard(CSBoardVO vo,HttpSession session, Model model) {
	MemberVO vo2 =	(MemberVO)session.getAttribute("memberSession");
		vo.setEmail(vo2.getEmail());
		model.addAttribute("vo2",vo2);
		insertCSBoardService.insertCSBoard(vo);
		return "f-CSWrite";
	}


	


}
