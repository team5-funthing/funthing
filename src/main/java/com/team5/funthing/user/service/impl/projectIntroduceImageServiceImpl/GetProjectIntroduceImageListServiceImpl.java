package com.team5.funthing.user.service.impl.projectIntroduceImageServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectIntroduceImageDAO;
import com.team5.funthing.user.model.vo.ProjectIntroduceImageVO;
import com.team5.funthing.user.service.projectIntroduceImageService.GetProjectIntroduceImageListService;

@Service
public class GetProjectIntroduceImageListServiceImpl implements GetProjectIntroduceImageListService {

	@Autowired
	private ProjectIntroduceImageDAO projectIntroduceImageDAO;
	
	@Override
	public List<ProjectIntroduceImageVO> getProjectIntroduceImageList(ProjectIntroduceImageVO vo) {
		return projectIntroduceImageDAO.getProjectIntroduceImageList(vo);
	}

}
