package com.team5.funthing.admin.service.adminUserMainProjectService;

import java.util.List;

import com.team5.funthing.admin.model.vo.AdminUserMainProjectVO;
import com.team5.funthing.user.model.vo.ProjectVO;

public interface GetFocusProjectListService {
	
	List<AdminUserMainProjectVO> getFocusProjectList(ProjectVO vo);
	
}
