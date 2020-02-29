package com.team5.funthing.user.service.impl.creatorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.CreatorDAO;
import com.team5.funthing.user.model.vo.CreatorVO;
import com.team5.funthing.user.service.creatorService.UpdateCreatorService;

@Service
public class UpdateCreatorServiceImpl implements UpdateCreatorService{

	@Autowired
	private CreatorDAO userCreatorDAO;

	@Override
	public int updateCreator(CreatorVO vo) {
		return userCreatorDAO.updateCreator(vo);
	}
	
	
}
