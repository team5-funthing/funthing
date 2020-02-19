package com.team5.funthing.user.service.projectAccountInformationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectAccountInformationDAO;
import com.team5.funthing.user.model.vo.ProjectAccountInformationVO;
import com.team5.funthing.user.service.projectAccountInformationService.DeleteProjectAccountInformationService;

@Service
public class DeleteProjectAccountInformationServiceImpl implements DeleteProjectAccountInformationService {

	@Autowired
	ProjectAccountInformationDAO projectAccountInformationDAO;
	@Override
	public void deleteProjectAccountInformation(ProjectAccountInformationVO vo) {
		projectAccountInformationDAO.deleteProjectAccountInformation(vo);
		
	}

}
