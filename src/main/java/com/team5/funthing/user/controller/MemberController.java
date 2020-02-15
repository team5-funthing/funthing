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
	
	@RequestMapping(value="loginMember.udo", method=RequestMethod.POST) // �α���Ȯ��
	public String loginMember(MemberVO vo, HttpServletRequest request) {
		System.out.println("vo �� :" +loginMemberService.loginMember(vo));
		System.out.println("�ϴ� ���� �°� ���� ??");
		if(loginMemberService.loginMember(vo) != null) {
			
			if(vo.getPassword() == request.getAttribute("password")) { //�н����� �¾����� 
				return "p-index";
			}else { //�н����� Ʋ������ 
				return "f-find-id";
			}
		}else {
			System.out.println("���̶� �̰� ����� ");
			return "f-find-id";
		}

	}
	
	@RequestMapping(value = "loginCheck.udo", method = RequestMethod.GET)//ȸ������ ���̵� �ߺ�üũ 
	public String loginCheck(MemberVO vo) {
		
		if(loginCheckService.loginCheck(vo) != null ) { //���̵� �����Ѵ�.
			return "";
		}else { //���̵� ���������ʴ´�.
			return "";
		}
		
	}
	
	// id �ߺ� üũ ��Ʈ�ѷ�
		@RequestMapping(value = "emailjoin2.udo", method = RequestMethod.GET)
		@ResponseBody
		public int emailCheck(@RequestParam("email") String email) {

			return reg_Service.emailCheck(email);
		}
	
	
	@RequestMapping(value="joinselect.udo" ,method=RequestMethod.GET) // ȸ�����Լ��� ȭ���̵�
	public String loginselect() {
		return "p-waytoJoin-select";
	}
	
	@RequestMapping(value="findidpassword.udo" ,method=RequestMethod.GET) // ���̵� ��й�ȣ ã�� �����̵�
	public String findidpw() {
		return "p-find-id-pw-select";
	}
	
	@RequestMapping(value="findid.udo",method=RequestMethod.GET) // ���̵� ã�� ȭ���̵�
	public String findid() {
		return "f-find-id";
	}
	
	@RequestMapping(value="findpw.udo",method=RequestMethod.GET) // ��й�ȣ ã�� ȭ���̵�
	public String findpw() {
		return "f-find-pw";
	}
	
	@RequestMapping(value="emailjoin.udo",method=RequestMethod.GET) // ���Ϸΰ����ϱ� ȭ���̵�
	public String emailjoin() {
		return "f-join";
	}
	
	@RequestMapping(value="successjoin.udo",method=RequestMethod.POST) // ���Լ����ؼ� ����ȭ���̵�
	public String successjoin(MemberVO vo) {
		insertProject.insertMember(vo);
		return "p-index";
	}
	
	
	
	
	
}
