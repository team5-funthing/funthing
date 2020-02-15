package com.team5.funthing.user.service.impl.boardServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.BoardDAO;
import com.team5.funthing.user.model.vo.BoardVO;
import com.team5.funthing.user.model.vo.NoticeVO;
import com.team5.funthing.user.service.boardService.boardService;

@Service
public class BoardServiceImpl implements boardService{
	
	@Autowired
	private BoardDAO boardDao;

	@Override
	public int selectBoardCount() {
		
		return boardDao.selectBoardCount();
	}

	@Override
	public int calculateTotalPage(int noticeCountTotal) {
		int totalPage = noticeCountTotal / 5 + (noticeCountTotal%5==0 ? 0 : 1);
		return totalPage;
	}

	@Override
	public List<NoticeVO> selectBoardEachPage(BoardVO vo) {
		return boardDao.selectBoardEachPage(vo);
	}
	
	@Override
	public int getStartRow(int currentPageNum) {
		return (currentPageNum-1) * 5 + 1;
	}
	
	@Override
	public int getEndRow(int currentPageNum) {
		return currentPageNum * 5;
	}

	@Override
	public int getStartPage(int currentPageNum) {
		int startPage = (currentPageNum-1) / 5 * 5 + 1;
		return startPage;
	}

	@Override
	public int getEndPage(int startPageNum) {
		int endPage = startPageNum + 5 -1;
		return endPage;
	}

	
	
}
