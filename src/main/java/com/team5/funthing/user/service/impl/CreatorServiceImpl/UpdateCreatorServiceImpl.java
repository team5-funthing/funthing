package com.team5.funthing.user.service.impl.CreatorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.UserCreatorDAO;
import com.team5.funthing.user.model.vo.UserCreatorVO;
import com.team5.funthing.user.service.CreatorService.UpdateCreatorService;

@Service
public class UpdateCreatorServiceImpl implements UpdateCreatorService{

	@Autowired
	private UserCreatorDAO userCreatorDAO;

	@Override
	public int updateCreator(UserCreatorVO vo) {
		return userCreatorDAO.updateCreator(vo);
	}
	
	
}
