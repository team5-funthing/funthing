package com.team5.funthing.admin.service.impl.adminCSBoardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminCSBoardDAO;
import com.team5.funthing.admin.service.adminCSBoardService.GetCSBoardService;
import com.team5.funthing.user.model.vo.CSBoardVO;

@Service
public class GetCSBoardServiceImpl implements GetCSBoardService {

	@Autowired
	private AdminCSBoardDAO adminCSBoardDAO;

	@Override
	public CSBoardVO getCSBoard(CSBoardVO vo) {
		
		return adminCSBoardDAO.getCSBoard(vo);
	}
	
	

}
