package com.team5.funthing.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team5.funthing.user.model.vo.MemberVO;

public class UserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("postHandle�޼��� ���");
		HttpSession session = request.getSession();
		MemberVO memberSession = (MemberVO)session.getAttribute("memberSession");
		if(memberSession != null) {
			System.out.println("������ �ֽ��ϴ�.");
			System.out.println("at postHandle : " + memberSession.toString());
			return true;
		}else {
			System.out.println("������ �����ϴ�.");
			response.sendRedirect("/funthing/needLogin.udo");
			return false;
		}
	}

	
	
}
