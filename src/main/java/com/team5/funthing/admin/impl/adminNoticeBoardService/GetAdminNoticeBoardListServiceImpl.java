package com.team5.funthing.admin.impl.adminNoticeBoardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminNoticeBoardDAO;
import com.team5.funthing.admin.model.vo.AdminNoticeBoardVO;
import com.team5.funthing.admin.service.adminNoticeBoardService.GetAdminNoticeBoardListService;

@Service
public class GetAdminNoticeBoardListServiceImpl implements GetAdminNoticeBoardListService {

	@Autowired
	private AdminNoticeBoardDAO adminNoticeBoardDAO;
	
	@Override
	public List<AdminNoticeBoardVO> getNoticeBoardList(AdminNoticeBoardVO vo) {
		return adminNoticeBoardDAO.getNoticeBoardList(vo);
	}
	
}
