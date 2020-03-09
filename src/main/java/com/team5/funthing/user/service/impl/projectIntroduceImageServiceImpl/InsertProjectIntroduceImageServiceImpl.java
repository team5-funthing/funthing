package com.team5.funthing.user.service.impl.projectIntroduceImageServiceImpl;

import java.util.List;

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
	public void insertProjectIntroduceImage(ProjectIntroduceImageVO vo, List<String> toInsertImageList) {
		
		if(toInsertImageList != null) {
			
			for(String toInsertImage : toInsertImageList) {
				vo.setProjectIntroduceImage(toInsertImage);
				projectIntroduceImageDAO.insertProjectIntroduceImage(vo);
				
			} // 소개 이미지 경로 DB에 추가
		}
	}

}
