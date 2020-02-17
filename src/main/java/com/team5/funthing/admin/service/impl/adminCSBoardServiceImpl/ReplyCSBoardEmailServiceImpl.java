package com.team5.funthing.admin.service.impl.adminCSBoardServiceImpl;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.vo.AdminCSBoardVO;
import com.team5.funthing.admin.service.adminCSBoardService.ReplyCSBoardEmailService;
import com.team5.funthing.user.model.vo.CSBoardVO;


@Service
public class ReplyCSBoardEmailServiceImpl implements ReplyCSBoardEmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;
	
	@Override
	public void sendReplyEmail(AdminCSBoardVO avo,CSBoardVO cvo) throws UnsupportedEncodingException, MessagingException {
		message = mailSender.createMimeMessage();
		messageHelper = new MimeMessageHelper(message,true,"UTF-8");
		//
		messageHelper.setSubject("[\""+cvo.getCsTitle()+"\"] [문의답변]:"+avo.getAdminCSTitle());
		messageHelper.setText(avo.getAdminCSContent());
		messageHelper.setFrom("funthing20@gmail.com",avo.getAdminID());
		messageHelper.setTo(cvo.getEmail());
		mailSender.send(message);
		
		

	}

}
