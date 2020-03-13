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
		System.out.println("postHandle메서드 사용");
		HttpSession session = request.getSession();
		MemberVO memberSession = (MemberVO)session.getAttribute("memberSession");
		if(memberSession != null) {
			System.out.println("세션이 있습니다.");
			System.out.println("at postHandle : " + memberSession.toString());
			return true;
		}else {
			System.out.println("세션이 없습니다.");
			response.sendRedirect("/funthing/needLogin.udo");
			return false;
		}
	}

	
	
}
