package com.team5.funthing.user.service.impl.noticeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.NoticeDAO;
import com.team5.funthing.user.model.vo.NoticeVO;
import com.team5.funthing.user.service.noticeService.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO noticeDao;
	
	@Override
	public void insertNotice(NoticeVO vo) {
		noticeDao.insertNotice(vo);
	}

	@Override
	public void updateNotice(NoticeVO vo) {
		noticeDao.updateNotice(vo);
	}

	@Override
	public void deleteNotice(NoticeVO vo) {
		noticeDao.deleteNotice(vo);
	}

	@Override
	public List<NoticeVO> selectNoticeList(NoticeVO vo) {
		return noticeDao.selectNoticeList(vo);
	}

	@Override
	public List<NoticeVO> selectEventNoticeList(NoticeVO vo) {
		return noticeDao.selectEventNoticeList(vo);
	}

	@Override
	public List<NoticeVO> selectEntireNoticeList(NoticeVO vo) {
		return noticeDao.selectEntireNoticeList(vo);
	}

	@Override
	public NoticeVO selectNotice(NoticeVO vo) {
		return noticeDao.selectNotice(vo);
	}

	@Override
	public List<NoticeVO> selectSearchNoticeList(NoticeVO vo) {
		return noticeDao.selectSearchNoticeList(vo);
	}

	@Override
	public int selectNoticeCount(NoticeVO vo) {
		return noticeDao.selectNoticeCount(vo);
	}
	
	
}
