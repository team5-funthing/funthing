package com.team5.funthing.user.service.noticeService;

import java.util.List;

import com.team5.funthing.user.model.vo.NoticeVO;

public interface NoticeService {

	void insertNotice(NoticeVO vo);
	void updateNotice(NoticeVO vo);
	void deleteNotice(NoticeVO vo);
	List<NoticeVO> selectNoticeList(NoticeVO vo);
	List<NoticeVO> selectEntireNoticeList(NoticeVO vo);
	List<NoticeVO> selectEventNoticeList(NoticeVO vo);
	NoticeVO selectNotice(NoticeVO vo);
	
}
