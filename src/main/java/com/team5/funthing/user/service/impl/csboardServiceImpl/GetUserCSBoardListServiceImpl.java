package com.team5.funthing.user.service.impl.csboardServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.CSBoardDAO;
import com.team5.funthing.user.model.vo.CSBoardVO;
import com.team5.funthing.user.service.csboardService.GetUserCSBoardListService;

@Service
public class GetUserCSBoardListServiceImpl implements GetUserCSBoardListService {

	@Autowired
	CSBoardDAO dao;
	
	@Override
	public List<CSBoardVO> getCSBoardList(CSBoardVO vo) {
		return dao.getCSBoardList(vo);
	}

}
