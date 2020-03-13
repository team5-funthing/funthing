package com.team5.funthing.user.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.team5.funthing.common.utils.SendMailUtil;
import com.team5.funthing.user.model.vo.AlarmVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.deletememberService.GetDeleteMemberService;
import com.team5.funthing.user.service.memberService.GetMemberService;
import com.team5.funthing.user.service.memberService.InsertMemberService;
import com.team5.funthing.user.service.memberService.UpdateMemberService;

@Controller
@SessionAttributes("member")
public class MemberController {


	@Autowired
	private SendMailUtil sendMailUtil;
	@Autowired
	private GetMemberService getMemberService;
	@Autowired
	private InsertMemberService insertMemberService;
	@Autowired
	private UpdateMemberService updateMemberService;
	@Autowired
	private GetDeleteMemberService getDeleteMemberService;


	@RequestMapping(value="socialLogin.udo",method=RequestMethod.GET)
	public String socialLogin() {   
		return "f-socialjoin";
	}


	@RequestMapping(value="getMember.udo", method=RequestMethod.POST) 
	public String getMember(MemberVO vo, AlarmVO avo, Model model, HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IOException {

		MemberVO loginMember = getMemberService.getMember(vo);
		if(loginMember == null) {
			model.addAttribute("loginFail", "등록된 회원이 아닙니다.");
			return "forward:member.udo";
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if(encoder.matches(vo.getPassword(), loginMember.getPassword())) { 
				if(request.getParameter("confirm-switch")==null) {
					Cookie cookieid = new Cookie("funthingCookieId",null);
					cookieid.setMaxAge(0);  /// kill the cookie 
					Cookie cookiepw = new Cookie("funthingCookiePw",null);
					cookiepw.setMaxAge(0); /// kill the cookie
					response.addCookie(cookieid);
					response.addCookie(cookiepw);
				}else {
					Cookie cookieid = new Cookie("funthingCookieId",vo.getEmail());
					cookieid.setMaxAge(60*60*24*30);  /// cookie's life setting 30 days 
					Cookie cookiepw = new Cookie("funthingCookiePw",vo.getPassword());
					cookiepw.setMaxAge(60*60*24*30); /// cookie's life setting 30 days 
					response.addCookie(cookieid);
					response.addCookie(cookiepw);
				}
				session.setAttribute("memberSession", getMemberService.getMember(vo));
				System.out.println(session.getAttribute("memberSession"));
				return "forward:member.udo";
			}
			model.addAttribute("loginFail", "비밀번호가 일치하지 않습니다.");
			return "forward:member.udo";
	}
	
	@RequestMapping(value="joinselect.udo" ,method=RequestMethod.GET)
	public String login(HttpSession session) {
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


	@RequestMapping(value="successjoin.udo",method=RequestMethod.POST) 
	public String successjoin(MemberVO vo,Model model,@RequestParam(name="email2",required=false)String email,HttpSession session) {
		if(email!=null) {
			vo.setEmail(email);
		}
		if(vo.getEmail()!=null && vo.getName()!=null && vo.getPassword()!=null)    {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodePassword = encoder.encode(vo.getPassword());			
			vo.setPassword(encodePassword);			
			insertMemberService.insertMember(vo);
			model.addAttribute("result","1");
		}else {
			model.addAttribute("result","2");
		}

		return "ajax/callback";
	}

	@RequestMapping(value="socialjoin.udo",method=RequestMethod.GET)
	public String socialJoin() {
		return "f-socialjoin";
	}

	@RequestMapping(value= "certification.udo" ,method=RequestMethod.GET )
	public String certificationEmail(MemberVO vo,String email,Model model) {
		try {
			vo.setEmail(email);
			String certificationCode = sendMailUtil.createCertificationCode(50);
			sendMailUtil.sendMail("[Funthing] 인증코드 입니다.", "인증코드 : ["+certificationCode+"]", vo.getEmail());   
			model.addAttribute("certificationCode",certificationCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ajax/certificationCodeCallback";
	}
	
	 @RequestMapping(value="pwSuccess.udo",method=RequestMethod.POST)
	    @ResponseBody
	    public String updatePw(MemberVO vo,String email) {
	    	String result = "2";
	    	try {
				vo.setEmail(email);
				if(getMemberService.getMember(vo)!=null) {
				String password = sendMailUtil.createCertificationCode(50);
				sendMailUtil.sendMail("[Funthing] 임의로 생성된 비밀번호 입니다.", "발송된 비밀번호로 로그인을 하시고 꼭 "
						+ "마이페이지 - 회원정보수정 에서 비밀번호를 변경하여 이용에 불편함이 없으시길 바랍니다. "
						+ "비밀번호 : ["+password+"]", vo.getEmail());
				MemberVO vo2 = getMemberService.getMember(vo);
				vo2.setPassword(password);
				updateMemberService.updateMember(vo2);
				result="1";
				}
	    	}catch(Exception e) {
				e.printStackTrace();
			}
	    	return result;
	    }

	@RequestMapping(value="imageUpload.udo",method=RequestMethod.GET)
	public String imageUpload() {
		return "f-imageUpload";
	}




	@RequestMapping(value="logout.udo",method=RequestMethod.GET)
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:index.udo";
	}    


	@RequestMapping(value="emailCheck.udo",method=RequestMethod.GET)
	public String duplicationCheck(MemberVO vo,String typedEmail,Model model) throws JsonProcessingException {
		vo.setEmail(typedEmail);
		if(getDeleteMemberService.getDeleteMemberTableMember(vo)!=null) {
			model.addAttribute("result","3");
			return "ajax/callback";
		}
		if(getMemberService.getMember(vo)==null) {
			model.addAttribute("result", "1");      
		}else {
			model.addAttribute("result","2");
		}

		return "ajax/callback";
	}


	@RequestMapping(value="updateProfile.udo",method=RequestMethod.GET)
	public String updateProfile(Model model,HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("memberSession");	
		model.addAttribute("member", member);
		return "f-update-profile";
	}

}