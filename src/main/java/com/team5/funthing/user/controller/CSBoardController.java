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
		System.out.println(request.getParameter("csid"));
		///  게시판을 따로 만들지 않기로 해서,  관리자문의하기는  글쓰기 페이지에   집어넣음.
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
	public String insertCSBoard(CSBoardVO vo,HttpSession session) {
		System.out.println(vo);
	MemberVO vo2 =	(MemberVO)session.getAttribute("memberSession");
		vo.setEmail(vo2.getEmail());
		//폼에 입력한 값 DB에 넣은 후 다시 폼으로 이동
		insertCSBoardService.insertCSBoard(vo);
		return "f-CSWrite";
	}


	


}
