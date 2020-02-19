package com.team5.funthing.admin.impl.adminNoticeBoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminNoticeBoardDAO;
import com.team5.funthing.admin.model.vo.AdminNoticeBoardVO;
import com.team5.funthing.admin.service.adminNoticeBoardService.DeleteAdminNoticeBoardService;

@Service
public class DeleteAdminNoticeBoardServiceImpl implements DeleteAdminNoticeBoardService {
	
	@Autowired
	private AdminNoticeBoardDAO adminNoticeBoardDAO;
	
	@Override
	public int deleteNoticeBoard(AdminNoticeBoardVO vo) {
		return adminNoticeBoardDAO.deleteNoticeBoard(vo);
	}

}
