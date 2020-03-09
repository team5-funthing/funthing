package com.team5.funthing.user.service.impl.projectIntroduceImageServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectIntroduceImageDAO;
import com.team5.funthing.user.model.vo.ProjectIntroduceImageVO;
import com.team5.funthing.user.service.projectIntroduceImageService.DeleteProjectIntroduceImageService;

@Service
public class DeleteProjectIntroduceImageServiceImpl implements DeleteProjectIntroduceImageService {

	@Autowired
	private ProjectIntroduceImageDAO projectIntroduceImageDAO;
	
	@Override
	public void deleteProjectIntroduceImage(ProjectIntroduceImageVO vo, List<Integer> toRemoveImageNoList) {
		
		if(toRemoveImageNoList != null) {
			for(int toRemoveImageNo : toRemoveImageNoList) {
				vo.setProjectIntroduceImageNo(toRemoveImageNo);
				projectIntroduceImageDAO.deleteProjectIntroduceImage(vo);
			}
			
		}
	}

}
