package com.team5.funthing.user.service.impl.creatorServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.CreatorDAO;
import com.team5.funthing.user.model.vo.CreatorVO;
import com.team5.funthing.user.service.creatorService.GetCreatorListByEmailService;

@Service
public class GetCreatorListByEmailServiceImpl implements GetCreatorListByEmailService {

	@Autowired
	private CreatorDAO creatorDAO;
	
	@Override
	public List<CreatorVO> getCreatorListByEmail(CreatorVO vo) {
		return creatorDAO.getCreatorListByEmail(vo);
	}

}
