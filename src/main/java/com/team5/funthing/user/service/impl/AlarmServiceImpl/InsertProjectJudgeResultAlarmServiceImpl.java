package com.team5.funthing.user.service.impl.AlarmServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.AlarmDAO;
import com.team5.funthing.user.model.vo.AlarmVO;
import com.team5.funthing.user.service.AlarmService.InsertProjectJudgeResultAlarmService;

@Service
public class InsertProjectJudgeResultAlarmServiceImpl implements InsertProjectJudgeResultAlarmService {

	@Autowired
	private AlarmDAO alarmDAO;
	
	@Override
	public int insertProjectJudgeResultAlarm(AlarmVO vo) {
		return alarmDAO.insertProjectJudgeResultAlarm(vo);
	}

}
