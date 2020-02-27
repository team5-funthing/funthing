package com.team5.funthing.admin.service.impl.adminProjectCheckServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminProjectCheckDAO;
import com.team5.funthing.admin.service.adminProjectCheckService.UpdateProjectCheckApprovalService;
import com.team5.funthing.user.model.vo.ProjectVO;

@Service
public class UpdateProjectCheckApprovalServiceImpl implements UpdateProjectCheckApprovalService {

	@Autowired
	private AdminProjectCheckDAO adminProjectCheckDAO;
	
	@Override
	public void updateProjectCheckApproval(ProjectVO vo) {
		adminProjectCheckDAO.updateProjectCheckApproval(vo);
	}

}
