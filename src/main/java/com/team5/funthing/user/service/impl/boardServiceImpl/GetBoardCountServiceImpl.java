package com.team5.funthing.user.service.impl.boardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.BoardDAO;
import com.team5.funthing.user.service.boardService.GetBoardCountService;

@Service
public class GetBoardCountServiceImpl implements GetBoardCountService{

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public int GetBoardCount() {
		return boardDAO.getBoardCount();
	}

}
