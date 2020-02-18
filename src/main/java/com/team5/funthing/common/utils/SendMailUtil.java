package com.team5.funthing.common.utils;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

public interface SendMailUtil {
	
	String createCertificationCode(int codeLength);
	
	public void sendMail(String emailTitle,String emailContent,
			String receiverEmailAddress) 
					throws MessagingException, UnsupportedEncodingException;

}