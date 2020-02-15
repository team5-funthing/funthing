package com.team5.funthing.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.GetMemberService;
import com.team5.funthing.user.service.LoginCheckService;
import com.team5.funthing.user.service.LoginMemberService;
import com.team5.funthing.user.service.RegEmailCheckService;
import com.team5.funthing.user.service.projectService.InsertProject;

@Controller
@SessionAttributes("member")
public class MemberController {
	
	@Autowired
	private GetMemberService getMemberService;
	@Autowired
	private LoginMemberService loginMemberService;
	@Autowired
	private InsertProject insertProject;
	@Autowired
	private LoginCheckService loginCheckService;
	@Autowired
	private RegEmailCheckService reg_Service;
	
	
		
	@RequestMapping("*.udo")
	public String showindex() {
		return "p-index";
//		return "test";
	}
	
	@RequestMapping(value="loginMember.udo", method=RequestMethod.POST) // 로그인확인
	public String loginMember(MemberVO vo, HttpServletRequest request) {
		System.out.println("vo 값 :" +loginMemberService.loginMember(vo));
		System.out.println("일단 여기 온거 맞지 ??");
		if(loginMemberService.loginMember(vo) != null) {
			
			if(vo.getPassword() == request.getAttribute("password")) { //패스워드 맞았을때 
				return "p-index";
			}else { //패스워드 틀렸을때 
				return "f-find-id";
			}
		}else {
			System.out.println("널이라 이게 실행됨 ");
			return "f-find-id";
		}

	}
	
	@RequestMapping(value = "loginCheck.udo", method = RequestMethod.GET)//회원가입 아이디 중복체크 
	public String loginCheck(MemberVO vo) {
		
		if(loginCheckService.loginCheck(vo) != null ) { //아이디가 존재한다.
			return "";
		}else { //아이디가 존재하지않는다.
			return "";
		}
		
	}
	
	// id 중복 체크 컨트롤러
		@RequestMapping(value = "emailjoin2.udo", method = RequestMethod.GET)
		@ResponseBody
		public int emailCheck(@RequestParam("email") String email) {

			return reg_Service.emailCheck(email);
		}
	
	
	@RequestMapping(value="joinselect.udo" ,method=RequestMethod.GET) // 회원가입선택 화면이동
	public String loginselect() {
		return "p-waytoJoin-select";
	}
	
	@RequestMapping(value="findidpassword.udo" ,method=RequestMethod.GET) // 아이디 비밀번호 찾기 선택이동
	public String findidpw() {
		return "p-find-id-pw-select";
	}
	
	@RequestMapping(value="findid.udo",method=RequestMethod.GET) // 아이디 찾기 화면이동
	public String findid() {
		return "f-find-id";
	}
	
	@RequestMapping(value="findpw.udo",method=RequestMethod.GET) // 비밀번호 찾기 화면이동
	public String findpw() {
		return "f-find-pw";
	}
	
	@RequestMapping(value="emailjoin.udo",method=RequestMethod.GET) // 메일로가입하기 화면이동
	public String emailjoin() {
		return "f-join";
	}
	
	@RequestMapping(value="successjoin.udo",method=RequestMethod.POST) // 가입성공해서 메인화면이동
	public String successjoin(MemberVO vo) {
		insertProject.insertMember(vo);
		return "p-index";
	}
	
	
	
	
	
}
