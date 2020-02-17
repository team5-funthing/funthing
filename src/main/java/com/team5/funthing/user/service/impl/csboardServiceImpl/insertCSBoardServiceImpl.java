package com.team5.funthing.user.service.impl.csboardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.CSBoardDAO;
import com.team5.funthing.user.model.vo.CSBoardVO;
import com.team5.funthing.user.service.csboardService.CSBoardService;

@Service
public class insertCSBoardServiceImpl implements CSBoardService{
	
	@Autowired
	private CSBoardDAO csboardDao;

	@Override
	public void insertCSBoard(CSBoardVO vo) {
		csboardDao.insertCSBoard(vo);
		
	}

}
