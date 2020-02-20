package com.team5.funthing.admin.service.adminNoticeBoardService;

import java.util.List;

import com.team5.funthing.admin.model.vo.AdminNoticeBoardVO;

public interface GetAdminNoticeBoardListService {

	public List<AdminNoticeBoardVO> getNoticeBoardList(AdminNoticeBoardVO vo);
	
}
