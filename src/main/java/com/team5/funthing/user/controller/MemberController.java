package com.team5.funthing.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.CertificationEmailService;
import com.team5.funthing.user.service.GetMemberService;
import com.team5.funthing.user.service.LoginMemberService;
import com.team5.funthing.user.service.projectService.InsertProject;

@Controller
@SessionAttributes("member")
public class MemberController {
<<<<<<< HEAD
   
   @Autowired
   private GetMemberService getMemberService;
   @Autowired
   private LoginMemberService loginMemberService;
   @Autowired
   private CertificationEmailService certificationEmailService;
   
   @Autowired
   private InsertProject insertProject;
   
	/*
	 * @RequestMapping("getMember.udo") public String getMember(MemberVO vo, Model
	 * model) { System.out.println("MemberController ===> getMember 메서드 수행");
	 * 
	 * vo.setEmail("test@naver.com");
	 * 
	 * MemberVO test = getMemberService.getMember(vo);
	 * 
	 * System.out.println(test.toString());
	 * 
	 * return "p-index"; }
	 */
   
   
   @RequestMapping("*.udo")
   public String showindex() {
      return "p-index";
   }
   
   @RequestMapping(value="loginMember.udo", method=RequestMethod.POST) // 로그인확인
   public String loginMember(MemberVO vo, HttpServletRequest request,HttpSession session) {
	   System.out.println(vo.getEmail());
	   System.out.println(request.getParameter("password"));
	   if(loginMemberService.loginMember(vo) != null) {
		   if(vo.getPassword() == request.getParameter("password")) { //패스워드 맞았을때 
			   System.out.println("로그인 성공");
			   session.setAttribute("memberSession", vo);
			   return "p-index";
		   }else { //패스워드 틀렸을때 
			   return "f-find-id";
		   }
	   }else {
		   System.out.println("널이라 이게 실행됨 ");
		   return "f-find-id";
	   }
   }
   
   
   
   @RequestMapping(value="joinselect.udo" ,method=RequestMethod.GET) // 회원가입선택 화면이동
   public String login() {
      return "p-waytoJoin-select";
   }
   

   @RequestMapping(value="findpw.udo",method=RequestMethod.GET) // 비밀번호 찾기 화면이동
   public String findpw() {
      return "f-find-pw";
   }
   
   @RequestMapping(value="emailJoin.udo",method=RequestMethod.GET) // 메일로가입하기 화면이동
   public String emailjoin() {
      return "f-join";
   }
   
   @RequestMapping(value="successSocialjoin.udo",method=RequestMethod.GET) // 가입성공해서 메인화면이동
   public String successSocialjoin(MemberVO vo) {
      insertProject.insertSocialMember(vo);
      return "p-index";
   }
   
   @RequestMapping(value="successjoin.udo",method=RequestMethod.POST) // 가입성공해서 메인화면이동
   public String successjoin(MemberVO vo) {
	   System.out.println("이메일로 가입 실행!");
      insertProject.insertMember(vo);
      return "p-index";
   }
   @RequestMapping(value="naverjoin.udo",method=RequestMethod.GET)
   public String naverJoin(MemberVO vo,HttpServletRequest request) {
	   return "naverjoin";
   }
   
   @RequestMapping(value= "certification.udo" ,method=RequestMethod.GET )
   public String certificationEmail(MemberVO vo,Model model,HttpSession session) {
	   try {
		certificationEmailService.sendCertificationEmailforFindPassword(vo);
		session.setAttribute("certificationCode", vo.getCertificationCode());	
	} catch (Exception e) {
		e.printStackTrace();
=======
	
	@Autowired
	private GetMemberService getMemberService;
	
	
	@RequestMapping("getMember.udo")
	public String getMember(MemberVO vo, Model model) {
		System.out.println("MemberController ===> getMember �޼��� ����");
		
		vo.setEmail("test@naver.com");
		
		MemberVO test = getMemberService.getMember(vo);
		
		System.out.println(test.toString());
		
		return "p-index";
	}
	
	@RequestMapping("/*.udo")
	public String showindex() {
		return "p-index";
>>>>>>> 193ce0181c850e546df0196c8f9f2b0411ccf7e0
	}
	   return "f-find-id";
   }

   @RequestMapping(value="test.udo")
   public String testing() {
	   return "testing";
   }
   
   
   
}