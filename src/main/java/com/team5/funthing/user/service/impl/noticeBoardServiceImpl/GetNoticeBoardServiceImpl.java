package com.team5.funthing.user.service.impl.noticeBoardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.NoticeBoardDAO;
import com.team5.funthing.user.model.vo.NoticeBoardVO;
import com.team5.funthing.user.service.noticeBoardService.GetNoticeBoardService;

@Service
public class GetNoticeBoardServiceImpl implements GetNoticeBoardService {

	@Autowired
	private NoticeBoardDAO noticeBoardDAO;

	@Override
	public NoticeBoardVO getNoticeBoard(NoticeBoardVO vo) {
		return noticeBoardDAO.getNoticeBoard(vo);
	}
	
}
