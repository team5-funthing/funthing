package com.team5.funthing.user.service.impl.AlarmServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.AlarmDAO;
import com.team5.funthing.user.model.vo.AlarmVO;

@Service
public class InsertProjectReportAlarmServiceImpl implements com.team5.funthing.user.service.AlarmService.InsertProjectReportAlarmService {

	@Autowired
	private AlarmDAO alarmDAO;
	
	@Override
	public int insertProjectReportAlarm(AlarmVO vo) {
		return alarmDAO.insertProjectReportAlarm(vo);
	}

}
