package com.team5.funthing.user.service.creatorService;

import java.util.List;

import com.team5.funthing.user.model.vo.CreatorVO;

public interface GetCreatorListByEmailService {
	
	public List<CreatorVO> getCreatorListByEmail(CreatorVO vo);

}
