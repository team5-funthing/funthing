package com.team5.funthing.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.BoardVO;
import com.team5.funthing.user.model.vo.NoticeBoardVO;
import com.team5.funthing.user.service.boardService.GetBoardCountService;
import com.team5.funthing.user.service.boardService.GetBoardEachPageListService;
import com.team5.funthing.user.service.noticeBoardService.GetNoticeBoardListService;
import com.team5.funthing.user.service.noticeBoardService.GetNoticeBoardService;
import com.team5.funthing.user.service.noticeBoardService.GetRealNoticeBoardListService;
import com.team5.funthing.user.service.noticeBoardService.GetSearchNoticeBoardListService;

@Controller
public class NoticeBoardController {

	@Autowired
	private GetNoticeBoardService getNoticeBoardService;
	@Autowired
	private GetNoticeBoardListService getNoticeBoardListService;
	@Autowired
	private GetRealNoticeBoardListService getRealNoticeBoardListService;
	@Autowired
	private GetSearchNoticeBoardListService getSearchNoticeBoardListService;
	@Autowired
	private GetBoardCountService getBoardCountService;
	@Autowired
	private GetBoardEachPageListService getBoardEachPageListService;
	
	//ó�� ������ ��û�ÿ� ��ü �������� �޾ƿ��� �޼���
	@RequestMapping("getNoticeBoardList.udo")					
	public String getNoticeBoardList(NoticeBoardVO vo, BoardVO bvo, Model model) {	
				
		//=========================����¡ ó��(�� ������ ��)==========================
		bvo.setStartPage(1);
		bvo.setLastPage(bvo.getStartPage() + 5 - 1);
		System.out.println(bvo.getLastPage());
		
		model.addAttribute("startPageCount", bvo.getStartPage());
		model.addAttribute("endPageCount", bvo.getLastPage());
		
		//=======================����¡ ó��(�� �������� ������ �� ���)========================
		bvo.setCurrentPage(1);
		bvo.setNoticeStartRow((bvo.getCurrentPage()-1)*5 + 1);
		bvo.setNoticeEndRow(bvo.getCurrentPage() * 5);
		
		List<NoticeBoardVO> selectedBoardList = getBoardEachPageListService.getBoardEachPageList(bvo);
		System.out.println(selectedBoardList);
		model.addAttribute("getNoticeList", selectedBoardList);
		
		return "b-notice";
	}
	
	//������ ���� �󼼱��� ���� �޼���
	@RequestMapping("getNoticeBoard.udo")						
	public String getNoticeBoard(NoticeBoardVO vo, Model model) {
		NoticeBoardVO notice = getNoticeBoardService.getNoticeBoard(vo);
		model.addAttribute("NoticeDetail",notice);
		return "b-notice-detail";
	}
	
	//��ü���� ���� �������� ��ü ���� �� ����� �ҷ����� �޼���(ajax)
	@RequestMapping(value="/getAllNoticeBoardList.udo", method=RequestMethod.POST)			
	public String getAllNoticeBoardList(NoticeBoardVO vo, Model model) {
		List<NoticeBoardVO> NoticeBoardList = getNoticeBoardListService.getNoticeBoardList(vo);		//��� ���������� ���� ���� ����Ʈ
		model.addAttribute("getNoticeList", NoticeBoardList);
		
		return "/ajax/NoticeBoardList";
	}
	
	//���� ���� �������� ������ ��ϸ��� �ҷ����� �޼���(ajax)
	@RequestMapping(value="/getRealNoticeBoardList.udo", method=RequestMethod.POST)
	public String getRealNoticeBoardList(String category, Model model) {
		List<NoticeBoardVO> realNoticeBoardList = getRealNoticeBoardListService.getRealNoticeBoardList(category);
		model.addAttribute("realNoticeList", realNoticeBoardList);
		
		return "/ajax/realNoticeBoardList";
	}
	
	//�̺�Ʈ ���� �������� �̺�Ʈ �� ��ϸ��� �ҷ����� �޼���(ajax)
	@RequestMapping(value="/getEventNoticeBoardList.udo", method=RequestMethod.POST)
	public String getEventNoticeBoardList(String category, BoardVO bvo, Model model) {
		List<NoticeBoardVO> eventNoticeBoardList = getRealNoticeBoardListService.getRealNoticeBoardList(category);
		int totalBoard = getBoardCountService.GetBoardCount();
		model.addAttribute("eventNoticeList", eventNoticeBoardList);
		model.addAttribute("totalBoard", totalBoard);
		
		return "/ajax/eventNoticeBoardList";
	}
	
	//�˻����
	@RequestMapping(value="/getSearchTitleBoardList.udo", method=RequestMethod.POST)
	public String getSearchTitleBoardList(NoticeBoardVO vo, Model model) {
		
		List<NoticeBoardVO> searchNoticeBoardList = getSearchNoticeBoardListService.getSearchNoticeBoardList(vo);
		System.out.println(searchNoticeBoardList);
		
		model.addAttribute("getNoticeList", searchNoticeBoardList);
		return "b-notice";
	}
	
	//������ ��ư�� �������� ����¡ó���ϴ� �޼���
	@RequestMapping("getNoticeBoardEachPageList.udo")
	public String getNoticeBoardEachPageList(BoardVO vo,Model model) {
		
		if(vo.getCurrentPage()<0) {
			vo.setCurrentPage(1);
		}
		//=======================����¡ ó��(�ش� �������� �ҷ��� �� ���)================
		vo.setNoticeStartRow((vo.getCurrentPage()-1)*5 + 1);
		vo.setNoticeEndRow(vo.getCurrentPage() * 5);
		
		List<NoticeBoardVO> selectedBoardList = getBoardEachPageListService.getBoardEachPageList(vo);
		System.out.println(selectedBoardList);
		model.addAttribute("getNoticeList", selectedBoardList);
		
		//=========================����¡ ó��(�� ������ ��)==========================
		
		vo.setStartPage(((vo.getCurrentPage()-1)/5) * 5 + 1);
		vo.setLastPage(vo.getStartPage() + 5 - 1);
		System.out.println(vo.getLastPage());
		
		int boardTotal = getBoardCountService.GetBoardCount();
		int totalPage = boardTotal / 5 + (boardTotal % 5 == 0 ? 0 : 1);
		System.out.println(totalPage);
		
		if(vo.getLastPage()>totalPage) {
			vo.setLastPage(totalPage);
		}
		
		model.addAttribute("startPageCount", vo.getStartPage());
		model.addAttribute("endPageCount", vo.getLastPage());
		
		return "b-notice";
	}

}
