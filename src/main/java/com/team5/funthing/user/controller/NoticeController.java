package com.team5.funthing.user.controller;

import java.util.List;

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
	private List<NoticeVO> noticeList;//전체목록

	
	@RequestMapping("notice.udo")
	public ModelAndView showNotice(NoticeVO vo) {
		
		noticeList = noticeServiceImpl.selectNoticeList(vo);
		System.out.println(noticeList.toString());
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("noticeList",noticeList);
		mav.setViewName("b-notice");
		
		return mav;
	}
	
}
