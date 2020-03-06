package com.team5.funthing.user.service.noticeBoardService;

import java.util.List;

import com.team5.funthing.user.model.vo.NoticeBoardVO;

public interface GetRealNoticeBoardListService {

	public List<NoticeBoardVO> getRealNoticeBoardList(String category);
	
}
