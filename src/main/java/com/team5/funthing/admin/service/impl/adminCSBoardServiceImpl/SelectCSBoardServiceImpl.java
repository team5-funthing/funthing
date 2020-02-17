package com.team5.funthing.admin.service.impl.adminCSBoardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminCSBoardDAO;
import com.team5.funthing.admin.service.adminCSBoardService.SelectCSBoardService;
import com.team5.funthing.user.model.vo.CSBoardVO;

@Service
public class SelectCSBoardServiceImpl implements SelectCSBoardService {

	@Autowired
	private AdminCSBoardDAO adminCSBoardDAO;

	@Override
	public CSBoardVO selectCSBoard(CSBoardVO vo) {
		
		return adminCSBoardDAO.selectCSBoard(vo);
	}
	
	

}
