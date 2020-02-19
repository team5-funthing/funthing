package com.team5.funthing.user.service.projectAccountInformationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectAccountInformationDAO;
import com.team5.funthing.user.model.vo.ProjectAccountInformationVO;
import com.team5.funthing.user.service.projectAccountInformationService.GetProjectAccountInformationService;

@Service
public class GetProjectAccountInformationServiceImpl implements GetProjectAccountInformationService {

	@Autowired
	ProjectAccountInformationDAO projectAccountInformationDAO;
	
	@Override
	public ProjectAccountInformationVO getProjectAccountInformation(ProjectAccountInformationVO vo) {
		
		return projectAccountInformationDAO.getProjectAccountInformation(vo);
	}

}
