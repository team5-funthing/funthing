package com.team5.funthing.admin.service.adminMainViewService;

import java.util.List;

import com.team5.funthing.admin.model.vo.AdminMainViewVO;
import com.team5.funthing.user.model.vo.ProjectVO;

public interface GetMainViewProjectFundingListService {
	List<ProjectVO> getMainViewProjectFundingList(AdminMainViewVO vo);
}
