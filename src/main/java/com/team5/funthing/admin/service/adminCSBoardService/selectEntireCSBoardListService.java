package com.team5.funthing.admin.service.adminCSBoardService;

import java.util.List;

import com.team5.funthing.admin.model.vo.AdminCSBoardVO;
import com.team5.funthing.user.model.vo.CSBoardVO;

public interface SelectEntireCSBoardListService {
	
	List<CSBoardVO> selectEntireCSBoardList(CSBoardVO vo);
	
	
	
	
}
