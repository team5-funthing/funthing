package com.team5.funthing.user.service.impl.projectAccountInformationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectAccountInformationDAO;
import com.team5.funthing.user.model.vo.ProjectAccountInformationVO;
import com.team5.funthing.user.service.projectAccountInformationService.InsertProjectAccountInformationService;

@Service
public class InsertProjectAccountInformationServiceImpl implements InsertProjectAccountInformationService {

	
	@Autowired
	ProjectAccountInformationDAO projectAccountInformationDAO;
	


	@Override
	public void insertProjectAccountInformation(ProjectAccountInformationVO vo) {
		projectAccountInformationDAO.getProjectAccountInformation(vo);
		
	}
}
