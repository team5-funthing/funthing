package com.team5.funthing.user.service.boardService;

import java.util.List;

import com.team5.funthing.user.model.vo.BoardVO;
import com.team5.funthing.user.model.vo.NoticeVO;

public interface BoardService {
	
	int selectBoardCount();
	int calculateTotalPage(int noticeCountTotal);
	List<NoticeVO> selectBoardEachPage(BoardVO vo);
	int getStartRow(int currentPageNum);
	int getEndRow(int currentPageNum);
	int getStartPage(int currentPageNum);
	int getEndPage(int startPageNum);
	
}
