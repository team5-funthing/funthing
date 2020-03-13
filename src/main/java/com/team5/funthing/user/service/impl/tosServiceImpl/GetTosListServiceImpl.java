package com.team5.funthing.user.service.impl.tosServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.TosDAO;
import com.team5.funthing.user.model.vo.TosVO;
import com.team5.funthing.user.service.TosService.GetTosListService;

@Service
public class GetTosListServiceImpl implements GetTosListService{

	@Autowired
	private TosDAO tosDAO;
	
	@Override
	public List<TosVO> getTosList(TosVO vo) {
		return tosDAO.getTosList(vo);
	}

}
