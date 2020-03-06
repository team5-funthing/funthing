package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.AlarmVO;

@Repository
public class AlarmDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insertProjectJudgeResultAlarm(AlarmVO vo) {
		return sqlSessionTemplate.insert("AlarmDAO.insertProjectJudgeResultAlarm",vo);
	}
	
	public int insertProjectJudgeRequestAlarm(AlarmVO vo) {
		return sqlSessionTemplate.insert("AlarmDAO.insertProjectJudgeRequestAlarm", vo);
	}
	
	public int updateReadConfirmAlarm(AlarmVO vo) {
		return sqlSessionTemplate.update("AlarmDAO.updateReadConfirmAlarm", vo);
	}
	
	public List<AlarmVO> getNewestAlarmList(AlarmVO vo){
		return sqlSessionTemplate.selectList("AlarmDAO.selectNewestAlarm", vo);
	}
	
}
