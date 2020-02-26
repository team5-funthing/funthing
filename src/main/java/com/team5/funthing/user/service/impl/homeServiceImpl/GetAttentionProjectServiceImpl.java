package com.team5.funthing.user.service.impl.homeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.HomeDAO;
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.service.homeService.GetAttentionProjectService;

@Service
public class GetAttentionProjectServiceImpl implements GetAttentionProjectService {
	
	@Autowired
	private  HomeDAO homeDAO;

	
	@Override	
	public List<ProjectBoardVO> getAttentionProjectList(ProjectBoardVO vo) {
		return homeDAO.getAttentionProjectList(vo);
	}

}
