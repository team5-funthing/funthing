package com.team5.funthing.admin.service.impl.adminUserMainProjectServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminUserMainProjectDAO;
import com.team5.funthing.admin.model.vo.AdminUserMainProjectVO;
import com.team5.funthing.user.model.vo.ProjectVO;
@Service
public class GetUserMainProjectListServiceImpl
		implements com.team5.funthing.admin.service.adminUserMainProjectService.GetUserMainProjectListService {

	@Autowired
	AdminUserMainProjectDAO adminUserMainProjectDAO;
	
	@Override
	public List<ProjectVO> getUserMainProjectList(AdminUserMainProjectVO vo) {
		
		return adminUserMainProjectDAO.getUserMainProjectList(vo);
	}

}
