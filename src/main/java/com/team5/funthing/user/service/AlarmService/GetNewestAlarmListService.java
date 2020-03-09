package com.team5.funthing.user.service.AlarmService;

import java.util.List;

import com.team5.funthing.user.model.vo.AlarmVO;

public interface GetNewestAlarmListService {

	public List<AlarmVO> getNewestAlarmList(AlarmVO vo);
	
}
