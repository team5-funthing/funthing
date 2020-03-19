package com.team5.funthing.common.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendMailUtilImpl implements SendMailUtil{
	@Autowired
	private JavaMailSender mailSender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;
	
	public String createCertificationCode(int codeLength) {
		SecureRandom random = new SecureRandom();
		String certificationCode = new BigInteger(codeLength,random).toString();
		
		return certificationCode;
	}
	
	public void sendMail(String emailTitle,String emailContent,String receiverEmailAddress) throws MessagingException, UnsupportedEncodingException {
		message = mailSender.createMimeMessage();
		messageHelper = new MimeMessageHelper(message,true,"UTF-8");
		messageHelper.setSubject(emailTitle);
		messageHelper.setText(emailContent);
		messageHelper.setFrom("funthing@gmail.com","funthing¿î¿µÀÚ");
		messageHelper.setTo(receiverEmailAddress);
		mailSender.send(message);
	}
	
	
}
