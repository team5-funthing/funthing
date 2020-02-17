package com.team5.funthing.admin.service.impl.adminCSBoardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminCSBoardDAO;
import com.team5.funthing.admin.service.adminCSBoardService.updateReplyCheckCSBoardService;
import com.team5.funthing.user.model.vo.CSBoardVO;

@Service
public class UpdateReplyCheckCSBoardServiceImpl implements updateReplyCheckCSBoardService {

	@Autowired
	private AdminCSBoardDAO adminCSBoardDAO;
	
	@Override
	public void updateReplyCheckCSBoard(CSBoardVO vo) {
		
		adminCSBoardDAO.updateReplyCheckCSBoard(vo);
	}

}
