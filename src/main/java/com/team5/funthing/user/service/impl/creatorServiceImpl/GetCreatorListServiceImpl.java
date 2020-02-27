package com.team5.funthing.user.service.impl.creatorServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.CreatorDAO;
import com.team5.funthing.user.model.vo.CreatorVO;
import com.team5.funthing.user.service.creatorService.GetCreatorListService;

@Service
public class GetCreatorListServiceImpl implements GetCreatorListService {

	@Autowired
	private CreatorDAO CreatorDAO;
	
	@Override
	public List<CreatorVO> getCreatorList(CreatorVO vo) {
		return CreatorDAO.getCreatorList(vo);
	}

}
