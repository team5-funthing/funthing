package com.team5.funthing.user.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team5.funthing.common.utils.SendMailUtil;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.memberService.GetMemberService;
import com.team5.funthing.user.service.memberService.InsertImageService;
import com.team5.funthing.user.service.memberService.InsertMemberService;
import com.team5.funthing.user.service.memberService.InsertSocialMemberService;

@Controller
@SessionAttributes("member")
public class MemberController {

//	@Autowired
//	private CertificationEmailService certificationEmailService;

	@Autowired
	private SendMailUtil sendMailUtil;
	@Autowired
	private GetMemberService getMemberService;
	
	@Autowired
	private InsertMemberService insertMemberService;
	@Autowired
	private InsertSocialMemberService insertSocialMemberService;
	@Autowired
	private InsertImageService insertImageService;

//	하늘이가 가져갑니다. 
//	@RequestMapping("member.udo") 
//	public String showindex() {
//		return "p-index";
//	}

	@RequestMapping(value="socialLogin.udo",method=RequestMethod.GET)
	public String socialLogin() {   
		return "f-socialjoin";
	}
	
	@RequestMapping(value="socialLoginSuccess.udo",method=RequestMethod.POST)
	public void socialLoginSuccess(HttpServletRequest request,HttpSession session,MemberVO vo,HttpServletResponse response) throws IOException {   
		System.out.println("socialLoginSuccess.udo");
		System.out.println("소셜 로그인 했음");
		if(getMemberService.getMember(vo) != null) { 
			if(getMemberService.getMember(vo).getPassword().equals(request.getParameter("password"))) { 

				session.setAttribute("memberSessionEmail", getMemberService.getMember(vo).getEmail());
				System.out.println(""+session.getAttribute("memberSessionEmail"));
				session.setAttribute("memberSessionName", getMemberService.getMember(vo).getName());
				if(session.getAttribute("myprofile")!=null) {
					session.setAttribute("myprofile", getMemberService.getMember(vo).getMyImage()); 
				}

				response.sendRedirect("member.udo");
				
			}else {
				response.sendRedirect("findpw.udo");
			}

		}
	}



	@RequestMapping(value="getMember.udo", method=RequestMethod.POST) 
	public void getMember(MemberVO vo, HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IOException {
		System.out.println("일반 로그인 했음");
		if(getMemberService.getMember(vo) != null) { 
			if(getMemberService.getMember(vo).getPassword().equals(request.getParameter("password"))) { 
				if(request.getParameter("confirm-switch") != null) {
					Cookie cookieid = new Cookie("funthingCookieId",vo.getEmail());
					cookieid.setMaxAge(60*60*24*30);  /// cookie's life setting 30 days 
					Cookie cookiepw = new Cookie("funthingCookiePw",vo.getPassword());
					cookiepw.setMaxAge(60*60*24*30); /// cookie's life setting 30 days 
					response.addCookie(cookieid);
					response.addCookie(cookiepw);
				}else {
					Cookie cookieid = new Cookie("funthingCookieId",null);
					cookieid.setMaxAge(0);  /// kill the cookie 
					Cookie cookiepw = new Cookie("funthingCookiePw",null);
					cookiepw.setMaxAge(0); /// kill the cookie
				}
				session.setAttribute("memberSessionEmail", getMemberService.getMember(vo).getEmail());
				session.setAttribute("memberSessionName", getMemberService.getMember(vo).getName());
			    if(session.getAttribute("myprofile")!=null) {
				session.setAttribute("myprofile", getMemberService.getMember(vo).getMyImage()); 
			    }

				response.sendRedirect("member.udo");

			}else {
				response.sendRedirect("findpw.udo");
			}
	
		}
	}

	@RequestMapping(value="joinselect.udo" ,method=RequestMethod.GET)
	public String login(HttpSession session) {
		
		if(session.getAttribute("certificationCode")!=null) {
			session.removeAttribute("certificationCode");
		}
		if(session.getAttribute("emailCheck")!=null) {
			session.removeAttribute("emailCheck");
		}
		return "p-waytoJoin-select";
	}


	@RequestMapping(value="findpw.udo",method=RequestMethod.GET) 
	public String findpw() {
		return "f-find-pw";
	}

	@RequestMapping(value="emailJoin.udo",method=RequestMethod.GET) 
	public String emailjoin() {
		return "f-join";
	}

	@RequestMapping(value="successSocialjoin.udo",method=RequestMethod.GET) 
	public String successSocialjoin(MemberVO vo,HttpSession session) {
		if(session.getAttribute("certificationCode")!=null) {
			session.removeAttribute("certificationCode");
		}
		if(session.getAttribute("emailCheck")!=null) {
			session.removeAttribute("emailCheck");
		}
		insertSocialMemberService.insertSocialMember(vo);
		return "p-index";
	}

	@RequestMapping(value="successjoin.udo",method=RequestMethod.POST) 
	public String successjoin(MemberVO vo,HttpSession session) {
		if(session.getAttribute("certificationCode")!=null) {
			session.removeAttribute("certificationCode");
		}
		if(session.getAttribute("emailCheck")!=null) {
			session.removeAttribute("emailCheck");
		}
		insertMemberService.insertMember(vo);
		return "p-index";
	}

	@RequestMapping(value="socialjoin.udo",method=RequestMethod.GET)
	public String socialJoin() {
		return "f-socialjoin";
	}

	@RequestMapping(value= "certification.udo" ,method=RequestMethod.GET )
	public String certificationEmail(MemberVO vo,HttpSession session) {
		try {
			String certificationCode = sendMailUtil.createCertificationCode(50);

			sendMailUtil.sendMail("[Funthing] ", " : ["+certificationCode+"]", vo.getEmail());	
			session.setAttribute("certificationCode", certificationCode);   

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "p-callback";
	}

	@RequestMapping(value="test.udo")
	public String tst() {
		String afk=null;
        if(afk==null) {
        	System.out.println("");
        }
		return "testing";
	}

	@RequestMapping(value="imageUpload.udo",method=RequestMethod.GET)
	public String imageUpload() {
		return "f-imageUpload";
	}

	@RequestMapping(value="saveimage.udo",method=RequestMethod.POST)
	public String saveImage(HttpServletRequest request,MemberVO vo,HttpSession session) throws IOException {

		String saveDir= request.getRealPath("/resources/user/img/test");
		int maxPostSize = 3*1024*1024;
		String encoding = "UTF-8";
		MultipartRequest ms = new MultipartRequest(request, saveDir, maxPostSize, encoding, new DefaultFileRenamePolicy());  
		String renamedFile = ms.getFilesystemName("filename");
		String email = (String) session.getAttribute("memberSessionEmail");
		vo.setEmail(email);
		vo.setMyImage(renamedFile);
		insertImageService.insertImage(vo);
		session.setAttribute("myprofile", getMemberService.getMember(vo).getMyImage()); 
		return "p-index";
	}


	
	@RequestMapping(value="logout.udo",method=RequestMethod.GET)
	public String logOut(HttpSession session) {
		session.invalidate();
		return "p-index";
	}    


	@RequestMapping(value="emailCheck.udo",method=RequestMethod.GET)
	public String duplicationCheck(HttpServletRequest request,MemberVO vo,HttpSession session) {
		vo.setEmail(request.getParameter("email"));
    
		if(getMemberService.getMember(vo).getPassword()!=null) {	
		}else {
			session.setAttribute("emailCheck", vo.getEmail());
		}
		return "p-callback";
	}
	
	
	@RequestMapping(value="updateProfile.udo",method=RequestMethod.GET)
	public String updateProfile() {
		return "f-update-profile";
	}
	
	
	
}
