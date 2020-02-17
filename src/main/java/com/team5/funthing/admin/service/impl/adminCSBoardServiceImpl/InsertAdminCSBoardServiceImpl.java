package com.team5.funthing.admin.service.impl.adminCSBoardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminCSBoardDAO;
import com.team5.funthing.admin.model.vo.AdminCSBoardVO;
import com.team5.funthing.admin.service.adminCSBoardService.insertAdminCSBoardService;

@Service
public class InsertAdminCSBoardServiceImpl implements insertAdminCSBoardService{

	@Autowired
	private AdminCSBoardDAO adminCSBoardDAO;
	
	@Override
	public void insertAdminCSBoard(AdminCSBoardVO vo) {
		
		adminCSBoardDAO.insertAdminCSBoard(vo);
	}

}
