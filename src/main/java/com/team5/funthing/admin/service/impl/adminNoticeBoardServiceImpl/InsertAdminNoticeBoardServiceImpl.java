package com.team5.funthing.admin.service.impl.adminNoticeBoardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminNoticeBoardDAO;
import com.team5.funthing.admin.model.vo.AdminNoticeBoardVO;
import com.team5.funthing.admin.service.adminNoticeBoardService.InsertAdminNoticeBoardService;

@Service
public class InsertAdminNoticeBoardServiceImpl implements InsertAdminNoticeBoardService {

	@Autowired
	private AdminNoticeBoardDAO adminNoticeBoardDAO;
	
	@Override
	public int insertNoticeBoard(AdminNoticeBoardVO vo) {
		return adminNoticeBoardDAO.insertNoticeBoard(vo);
	}

}
