package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team5.funthing.user.model.vo.BoardVO;
import com.team5.funthing.user.model.vo.NoticeVO;
import com.team5.funthing.user.service.impl.boardServiceImpl.BoardServiceImpl;
import com.team5.funthing.user.service.impl.noticeServiceImpl.NoticeServiceImpl;

@Controller
public class NoticeController {

	@Autowired
	private NoticeServiceImpl noticeServiceImpl;
	@Autowired
	private BoardServiceImpl boardServiceImpl;

	private List<NoticeVO> EntireNoticeList;//��ü���
	private List<NoticeVO> noticeList;//��ü���
	private List<NoticeVO> EventNoticeList;//��ü���
	
	@RequestMapping("selectNoticeList.udo")
	public ModelAndView selectNoticeList(NoticeVO vo) {
		
		EntireNoticeList = noticeServiceImpl.selectEntireNoticeList(vo);
		
		vo.setNoticeCategory("�̺�Ʈ");
		EventNoticeList = noticeServiceImpl.selectEventNoticeList(vo);
		vo.setNoticeCategory("����");
		noticeList = noticeServiceImpl.selectNoticeList(vo);		
		
		int boardSelectCount = boardServiceImpl.selectBoardCount(); //boardSelectCount ��ü ���� ��
		int boardPageCount = boardServiceImpl.calculateTotalPage(boardSelectCount);// boardPageCount �������� ��ü ��
		
		BoardVO bvo = new BoardVO();
		bvo.setNoticeStartRow(1);
		bvo.setNoticeEndRow(5);
		EntireNoticeList = boardServiceImpl.selectBoardEachPage(bvo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("boardPageCount",boardPageCount);
		mav.addObject("noticeList", noticeList);
		mav.addObject("EventNoticeList",EventNoticeList);
		mav.addObject("EntireNoticeList",EntireNoticeList);
		mav.setViewName("b-notice");
		
		return mav;
	}
	
	@RequestMapping("selectNotice.udo")
	public ModelAndView SelectNotice(NoticeVO vo, HttpServletRequest request) {
		int noticeNo = Integer.parseInt(request.getParameter("no"));
		System.out.println(noticeNo);
		
		vo.setNoticeNo(noticeNo);
		ModelAndView mav = new ModelAndView();
		NoticeVO noticeDetail = noticeServiceImpl.selectNotice(vo);
		noticeDetail.toString();
		mav.addObject("NoticeDetail",noticeDetail );
		mav.setViewName("b-notice-detail");
		
		return mav;
	}
	
	@RequestMapping("selectSearchTitleNoticeList.udo")
	public ModelAndView selectSearchTitleNoticeList(NoticeVO vo, HttpServletRequest request) {
		
		String search = request.getParameter("search");
		String searchCondition = request.getParameter("searchCategory");
		
		vo.setNoticeSearchCondition(searchCondition);
		vo.setNoticeSearchContent(search);
		
		EntireNoticeList = noticeServiceImpl.selectSearchNoticeList(vo);
		
		int boardSelectCount = boardServiceImpl.selectBoardCount(); //boardSelectCount ��ü ���� ��
		int boardPageCount = boardServiceImpl.calculateTotalPage(boardSelectCount);// boardPageCount �������� ��ü ��
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardPageCount",boardPageCount);
		mav.addObject("EntireNoticeList", EntireNoticeList);
		mav.setViewName("b-notice");
		return mav;
	}
	
	@RequestMapping("selectSearchPageNumberNoticeList.udo")
	public ModelAndView selectSearchPageNumberNoticeList(BoardVO vo, HttpServletRequest request) {
		
		//-----------------------�� ��ȣ�� �Ѱܹ޾� ���� ������ �����ִ� �κ�-----------------------------
		int currentPageNum = Integer.parseInt(request.getParameter("no"));
		int startRow = boardServiceImpl.getStartRow(currentPageNum);
		int endRow = boardServiceImpl.getEndRow(currentPageNum);
		
		vo.setNoticeStartRow(startRow);
		vo.setNoticeEndRow(endRow);
		
		List<NoticeVO> selectedNoticeList = boardServiceImpl.selectBoardEachPage(vo);
		//�����ٰ� ������ ��ȣ�� �޾Ƽ� �ش����� �����ִ� �޼���
	
		//---------------------------------------������ �� ó��----------------------------------
		int boardSelectCount = boardServiceImpl.selectBoardCount(); 				//boardSelectCount ��ü ���� ��
		//int boardPageCount = boardServiceImpl.calculateTotalPage(boardSelectCount);	//boardPageCount �������� ��ü ��
		
		int startPage = boardServiceImpl.getStartPage(currentPageNum);				//ó�� �������� ���� ����		
		
		
		int endPage = boardServiceImpl.getEndPage(startPage);						//�� �������� ���� ����
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("startPageCount", startPage);
		mav.addObject("boardPageCount",endPage);
		mav.addObject("EntireNoticeList",selectedNoticeList);
		mav.setViewName("b-notice");
		return mav;
	}

}
