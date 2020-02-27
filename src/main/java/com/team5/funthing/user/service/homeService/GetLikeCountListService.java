package com.team5.funthing.user.service.homeService;

import java.util.List;

import com.team5.funthing.user.model.vo.ProjectVO;

public interface GetLikeCountListService {
	
	public List<ProjectVO> getLikeCountList(ProjectVO vo);
	public List<ProjectVO> getLikeCountList2(ProjectVO vo);
	public List<ProjectVO> getLikeCountList3(ProjectVO vo);
	
}
