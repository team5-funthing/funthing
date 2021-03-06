package com.team5.funthing.user.service.impl.boardServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.BoardDAO;
import com.team5.funthing.user.model.vo.BoardVO;
import com.team5.funthing.user.model.vo.NoticeBoardVO;
import com.team5.funthing.user.service.boardService.GetBoardEachPageListService;

@Service
public class GetBoardEachPageListServiceImpl implements GetBoardEachPageListService{

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<NoticeBoardVO> getBoardEachPageList(BoardVO vo) {
		return boardDAO.getBoardEachPageList(vo);
	}

}
