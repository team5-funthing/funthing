package com.team5.funthing.admin.service.impl.adminUserMainProjectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminUserMainProjectDAO;
import com.team5.funthing.admin.service.adminUserMainProjectService.DeleteFocusProjectService;
import com.team5.funthing.user.model.vo.ProjectVO;
@Service
public class DeleteFocusProjectServiceImpl implements DeleteFocusProjectService {
	
	@Autowired
	AdminUserMainProjectDAO adminUserMainProjectDAO;
	
	@Override
	public void deleteFocusProject(ProjectVO vo) {
		
		adminUserMainProjectDAO.deleteFocusProject(vo);
	}

}
