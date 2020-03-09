package com.team5.funthing.user.service.projectIntroduceImageService;

import java.util.List;

import com.team5.funthing.user.model.vo.ProjectIntroduceImageVO;

public interface DeleteProjectIntroduceImageService {
	
	public void deleteProjectIntroduceImage(ProjectIntroduceImageVO vo, List<Integer> toRemoveImageNoList);

}
