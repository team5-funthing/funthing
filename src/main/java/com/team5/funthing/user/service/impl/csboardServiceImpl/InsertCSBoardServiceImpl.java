package com.team5.funthing.user.service.impl.csboardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.CSBoardDAO;
import com.team5.funthing.user.model.vo.CSBoardVO;
import com.team5.funthing.user.service.csboardService.InsertCSBoardService;

@Service
public class InsertCSBoardServiceImpl implements InsertCSBoardService{
	
	@Autowired
	private CSBoardDAO csBoardDAO;

	@Override
	public void insertCSBoard(CSBoardVO vo) {
		csBoardDAO.insertCSBoard(vo);
		
	}

}
