package com.team5.funthing.user.service.impl.AlarmServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.AlarmDAO;
import com.team5.funthing.user.model.vo.AlarmVO;
import com.team5.funthing.user.service.AlarmService.UpdateReadConfirmAlarmService;

@Service
public class UpdateReadConfirmAlarmServiceImpl implements UpdateReadConfirmAlarmService {

	@Autowired
	private AlarmDAO alarmDAO;
	
	@Override
	public int updateReadConfirmAlarm(AlarmVO vo) {
		return alarmDAO.updateReadConfirmAlarm(vo);
	}

}
