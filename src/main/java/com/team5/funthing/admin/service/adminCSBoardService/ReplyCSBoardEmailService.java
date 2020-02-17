package com.team5.funthing.admin.service.adminCSBoardService;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.team5.funthing.admin.model.vo.AdminCSBoardVO;
import com.team5.funthing.user.model.vo.CSBoardVO;

public interface ReplyCSBoardEmailService {
	
	public void sendReplyEmail(AdminCSBoardVO avo, CSBoardVO cvo) throws UnsupportedEncodingException, MessagingException;

}
