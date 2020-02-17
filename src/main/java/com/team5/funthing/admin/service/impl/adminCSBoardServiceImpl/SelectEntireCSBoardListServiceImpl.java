package com.team5.funthing.admin.service.impl.adminCSBoardServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminCSBoardDAO;
import com.team5.funthing.admin.service.adminCSBoardService.selectEntireCSBoardListService;
import com.team5.funthing.user.model.vo.CSBoardVO;

@Service
public class SelectEntireCSBoardListServiceImpl implements selectEntireCSBoardListService{
	
	@Autowired
	private AdminCSBoardDAO adminCSBoardDAO;

	@Override
	public List<CSBoardVO> selectEntireCSBoardList(CSBoardVO vo) {
		
		return adminCSBoardDAO.selectEntireCSBoardList(vo); 
	}

	
	
	
	
	
	
}
