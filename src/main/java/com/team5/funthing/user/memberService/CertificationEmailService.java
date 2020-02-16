package com.team5.funthing.user.memberService;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.team5.funthing.user.model.vo.MemberVO;

public interface CertificationEmailService {

		
		public void sendCertificationEmail(MemberVO vo) throws UnsupportedEncodingException, MessagingException;
}
