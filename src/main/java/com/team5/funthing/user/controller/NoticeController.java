package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team5.funthing.user.model.vo.NoticeVO;
import com.team5.funthing.user.service.impl.noticeServiceImpl.NoticeServiceImpl;

@Controller
public class NoticeController {

	@Autowired
	private NoticeServiceImpl noticeServiceImpl;

	private List<NoticeVO> EntireNoticeList;//전체목록
	private List<NoticeVO> noticeList;//전체목록
	private List<NoticeVO> EventNoticeList;//전체목록
	
	@RequestMapping("selectNoticeList.udo")
	public ModelAndView selectNoticeList(NoticeVO vo) {
		
		EntireNoticeList = noticeServiceImpl.selectEntireNoticeList(vo);
		ModelAndView mav = new ModelAndView();
		
		vo.setNoticeCategory("이벤트");
		EventNoticeList = noticeServiceImpl.selectEventNoticeList(vo);
		vo.setNoticeCategory("공지");
		noticeList = noticeServiceImpl.selectNoticeList(vo);		
		
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

}
