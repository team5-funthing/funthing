package com.team5.funthing.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberDAO;
@Service
public class SpringScheduelUtilImpl implements SpringScheduelUtil {
	
	@Autowired
	MemberDAO dao;


	@Scheduled(cron="0 0 0 * * * ")
	public void deleteMemberAbsolutely() {
		//매일 0시 0분 0초마다  deleteMember 테이블에서 회원탈퇴 후 5년지난 회원 개인정보 삭제
		dao.deleteDeleteMemberTableMember();
	}

}
