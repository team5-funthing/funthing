package com.team5.funthing.user.service.impl.projectIntroduceImageServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectIntroduceImageDAO;
import com.team5.funthing.user.model.vo.ProjectIntroduceImageVO;
import com.team5.funthing.user.service.projectIntroduceImageService.InsertProjectIntroduceImageService;

@Service
public class InsertProjectIntroduceImageServiceImpl implements InsertProjectIntroduceImageService {

	@Autowired
	private ProjectIntroduceImageDAO projectIntroduceImageDAO;
	
	@Override
	public void insertProjectIntroduceImage(ProjectIntroduceImageVO vo) {
	
		projectIntroduceImageDAO.insertProjectIntroduceImage(vo);
		
	}

}
