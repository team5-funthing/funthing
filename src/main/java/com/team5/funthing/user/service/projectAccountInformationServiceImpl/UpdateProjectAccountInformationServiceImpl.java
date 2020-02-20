package com.team5.funthing.user.service.projectAccountInformationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectAccountInformationDAO;
import com.team5.funthing.user.model.vo.ProjectAccountInformationVO;
import com.team5.funthing.user.service.projectAccountInformationService.UpdateProjectAccountInformationService;

@Service
public class UpdateProjectAccountInformationServiceImpl implements UpdateProjectAccountInformationService {

	@Autowired
	ProjectAccountInformationDAO projectAccountInformationDAO;
	@Override
	public void updateProjectAccountInformation(ProjectAccountInformationVO vo) {
		projectAccountInformationDAO.updateProjectAccountInformation(vo);
	}

}
