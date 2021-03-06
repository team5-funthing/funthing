package com.team5.funthing.user.service.impl.noticeBoardServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.NoticeBoardDAO;
import com.team5.funthing.user.model.vo.NoticeBoardVO;
import com.team5.funthing.user.service.noticeBoardService.GetSearchNoticeBoardListService;

@Service
public class GetSearchNoticeBoardListServiceImpl implements GetSearchNoticeBoardListService {

	@Autowired
	private NoticeBoardDAO noticeBoardDAO;
	
	@Override
	public List<NoticeBoardVO> getSearchNoticeBoardList(NoticeBoardVO vo) {
		return noticeBoardDAO.getSearchNoticeBoardList(vo);
	}

}
