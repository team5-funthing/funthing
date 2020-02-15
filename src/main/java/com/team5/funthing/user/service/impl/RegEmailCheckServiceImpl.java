package com.team5.funthing.user.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.service.RegEmailCheckService;

@Service
public class RegEmailCheckServiceImpl implements RegEmailCheckService {
	
	@Autowired
	private SqlSessionTemplate userSqlSessin;
	private MemberDAO memberDAO;
	
	@Override
	public int emailCheck(String email) {
		memberDAO = userSqlSessin.getMapper(MemberDAO.class);
		return memberDAO.regEmailCheck(email);
	}

}
