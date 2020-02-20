package com.team5.funthing.admin.service.impl.adminNoticeBoardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminNoticeBoardDAO;
import com.team5.funthing.admin.model.vo.AdminNoticeBoardVO;
import com.team5.funthing.admin.service.adminNoticeBoardService.UpdateAdminNoticeBoardService;

@Service
public class UpdateAdminNoticeBoardServiceImpl implements UpdateAdminNoticeBoardService {

	@Autowired
	private AdminNoticeBoardDAO adminNoticeBoardDAO;
	
	@Override
	public int updateNoticeBoard(AdminNoticeBoardVO vo) {
		return adminNoticeBoardDAO.updateNoticeBoard(vo);
	}

}
