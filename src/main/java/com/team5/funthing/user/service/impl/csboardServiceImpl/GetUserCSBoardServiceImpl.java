package com.team5.funthing.user.service.impl.csboardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.CSBoardDAO;
import com.team5.funthing.user.model.vo.CSBoardVO;
import com.team5.funthing.user.service.csboardService.GetUserCSBoardService;

@Service
public class GetUserCSBoardServiceImpl implements GetUserCSBoardService {

	@Autowired
	CSBoardDAO dao;
	@Override
	public CSBoardVO getCSBoard(CSBoardVO vo) {
		return dao.getCSBoard(vo);
	}

}
