package com.team5.funthing.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("postHandle메서드 사용");
		HttpSession session = request.getSession();
		String AdminMemberSession = (String)session.getAttribute("adminSessionEmail");
		if(AdminMemberSession != null) {
			System.out.println("세션이 있습니다.");
			System.out.println("at postHandle : " + AdminMemberSession.toString());
			return true;
		}else {
			System.out.println("세션이 없습니다.");
			response.sendRedirect("/funthing/adminLogin.ado");
			return false;
		}
	}

}
