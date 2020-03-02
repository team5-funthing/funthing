package com.team5.funthing.user.service.boardService;

import java.util.List;

import com.team5.funthing.user.model.vo.BoardVO;
import com.team5.funthing.user.model.vo.NoticeBoardVO;

public interface GetBoardEachPageListService {

	public List<NoticeBoardVO> getBoardEachPageList(BoardVO vo);
	
}
