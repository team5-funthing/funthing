package com.team5.funthing.user.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.CertificationEmailService;
import com.team5.funthing.user.service.LoginMemberService;
import com.team5.funthing.user.service.projectService.InsertProject;

@Controller
@SessionAttributes("member")
public class MemberController {


	
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
   
   @RequestMapping(value="loginmember.udo", method=RequestMethod.POST) // 로그인확인
   public String loginMember(MemberVO vo, HttpServletRequest request,HttpSession session) {
    System.out.println("달라"+loginMemberService.loginMember(vo).getPassword());
    request.getParameter("password");
		   if(loginMemberService.loginMember(vo).getPassword().equals(request.getParameter("password"))) { //패스워드 맞았을때 
		   session.setAttribute("memberSessionEmail", vo.getEmail());
		   System.out.println("성공");
			   return "p-index";
		   }else {
			   System.out.println("실패");
			   return "p-index";
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
		System.out.println("vo 인증번호 확인 :" +vo.getCertificationCode());
		System.out.println("session 인증번호 확인 : "+ session.getAttribute("certificationCode"));
		
		/// 비밀번호 재설정 페이지에서 세션 삭제 하도록 !!!!
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return "f-find-id";
   }
   
   @RequestMapping(value="test.udo")
   public String tst() {
	   return "testing";
   }
   
   @RequestMapping(value="imageUpload.udo",method=RequestMethod.GET)
   public String imageUpload() {
	   //업로드를 위한 별개 페이지
	   return "imageUpload";
   }
   
   @RequestMapping(value="saveimage.udo",method=RequestMethod.POST)
   public String saveImage(HttpServletRequest request,MemberVO vo,HttpSession session) throws IOException {
	   
	    //  디렉토리는    수정해야함.  무조건 절대경로로 삽입해야하며, 우선 기웅님의 경로로 잡는도다.
	   String saveDir= "C:\\funthing\\project\\funthing\\src\\main\\webapp\\resources\\user\\img\\test";
	   int maxPostSize = 3*1024*1024;
	   String encoding = "UTF-8";
	   MultipartRequest ms = new MultipartRequest(request, saveDir, maxPostSize, encoding, new DefaultFileRenamePolicy());  
       String renamedFile = ms.getFilesystemName("filename");
       System.out.println( ms.getFilesystemName("filename"));     
       ///  유지보수 에서 실패!!! 할 구간.     
       String callpath = "/funthing/resources/user/img/test/";
       String email = (String) session.getAttribute("memberSessionEmail");
       vo.setEmail(email);
       vo.setMyImage(callpath+renamedFile);
	   insertProject.saveImage(vo);
	   return "testing";
   }
	  
		
		
		
 
   
}
   