package com.team5.funthing.user.service.impl.AlarmServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.AlarmDAO;
import com.team5.funthing.user.model.vo.AlarmVO;
import com.team5.funthing.user.service.AlarmService.GetNewestAlarmListService;

@Service
public class GetNewestAlarmListServiceImpl implements GetNewestAlarmListService{

	@Autowired
	private AlarmDAO alarmDAO;
	
	@Override
	public List<AlarmVO> getNewestAlarmList(AlarmVO vo) {
		return alarmDAO.getNewestAlarmList(vo);
	}

}
