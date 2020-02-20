package com.team5.funthing.admin.service.impl.adminCSBoardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminCSBoardDAO;
import com.team5.funthing.admin.service.adminCSBoardService.UpdateReplyCheckCSBoardService;
import com.team5.funthing.user.model.vo.CSBoardVO;

@Service
public class UpdateReplyCheckCSBoardServiceImpl implements UpdateReplyCheckCSBoardService {

	@Autowired
	private AdminCSBoardDAO adminCSBoardDAO;
	
	@Override
	public void updateReplyCheckCSBoard(CSBoardVO vo) {
		System.out.println("임플에서 받은 vo");
		System.out.println(vo.toString());
		adminCSBoardDAO.updateReplyCheckCSBoard(vo);
	}

}
