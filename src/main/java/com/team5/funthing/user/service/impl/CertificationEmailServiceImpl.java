package com.team5.funthing.user.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.CertificationEmailService;

@Service
public class CertificationEmailServiceImpl implements CertificationEmailService {


@Autowired
private JavaMailSender mailSender;
private MimeMessage message;
private MimeMessageHelper messageHelper;




	@Override
	public void sendCertificationEmailforJoin(MemberVO vo) throws MessagingException, UnsupportedEncodingException  {
		message = mailSender.createMimeMessage();
		messageHelper = new MimeMessageHelper(message,true,"UTF-8");
		SecureRandom random = new SecureRandom();
		String certificationCode = new BigInteger(50, random).toString();
		messageHelper.setSubject("[Funthing]본인확인 이메일 인증번호");
		messageHelper.setText("인증코드 : [ "+certificationCode+
				" ]");
		messageHelper.setFrom("funthing20@gmail.com","관리자");
		messageHelper.setTo(vo.getEmail());
		mailSender.send(message);
		
		vo.setCertificationCode(certificationCode);
	}
	

	@Override
	public void sendCertificationEmailforFindPassword(MemberVO vo) throws UnsupportedEncodingException, MessagingException {
		System.out.println(vo.toString());
		message = mailSender.createMimeMessage();
		messageHelper = new MimeMessageHelper(message,true,"UTF-8");
		SecureRandom random = new SecureRandom();
		String certificationCode = new BigInteger(50, random).toString();
		messageHelper.setSubject("[Funthing]본인확인 이메일 인증번호");
		messageHelper.setText("인증코드 : "+certificationCode+
				"위의 인증코드를 입력하여 주세요</center>");
		messageHelper.setFrom("funthing20@gmail.com","관리자");
		messageHelper.setTo(vo.getEmail());
		mailSender.send(message);
		
		vo.setCertificationCode(certificationCode);
	}

	
}
