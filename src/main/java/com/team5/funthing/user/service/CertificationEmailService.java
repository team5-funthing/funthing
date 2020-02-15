package com.team5.funthing.user.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.team5.funthing.user.model.vo.MemberVO;

public interface CertificationEmailService {

		public void sendCertificationEmailforJoin(MemberVO vo) throws Exception;
		
		public void sendCertificationEmailforFindPassword(MemberVO vo) throws UnsupportedEncodingException, MessagingException;
}
