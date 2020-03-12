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
import com.team5.funthing.common.utils.uploadUtils.UploadUtil;
import com.team5.funthing.user.model.vo.AlarmVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.AlarmService.GetNewestAlarmListService;
import com.team5.funthing.user.service.memberService.GetMemberService;
import com.team5.funthing.user.service.memberService.InsertImageService;
import com.team5.funthing.user.service.memberService.InsertMemberService;
import com.team5.funthing.user.service.memberService.InsertSocialMemberService;
import com.team5.funthing.user.service.memberService.UpdateMemberService;

@Controller
@SessionAttributes("member")
public class MemberController {

	//   @Autowired
	//   private CertificationEmailService certificationEmailService;

	@Autowired
	private SendMailUtil sendMailUtil;
	@Autowired
	private GetMemberService getMemberService;
	@Autowired
	private InsertMemberService insertMemberService;
	@Autowired
	private UpdateMemberService updateMemberService;



	@RequestMapping(value="socialLogin.udo",method=RequestMethod.GET)
	public String socialLogin() {   
		return "f-socialjoin";
	}


	@RequestMapping(value="getMember.udo", method=RequestMethod.POST) 
	public String getMember(MemberVO vo, AlarmVO avo, Model model, HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IOException {

		MemberVO loginMember = getMemberService.getMember(vo);
		if(loginMember == null) {
			model.addAttribute("loginFail", "µî·ÏµÈ È¸¿øÀÌ ¾Æ´Õ´Ï´Ù.");
			return "forward:member.udo";
		}
		System.out.println(loginMember.toString());
		
		//ÀÌ¸ÞÀÏ·Î °ªÀ» ¹Þ¾Æ¿Â´Ù. 
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
		System.out.println(encoder.encode(vo.getPassword()));
		System.out.println(encoder.matches(vo.getPassword(), loginMember.getPassword()));
			//ºñ¹Ð¹øÈ£°¡ °°À¸¸é Ã³¸®ÇÒ°Í
			if(encoder.matches(vo.getPassword(), loginMember.getPassword())) { 
				System.out.println("°ª :"+request.getParameter("confirm-switch"));
				
				//ÀÔ·Â¾ÆÀÌµð ¹öÆ°¿¡ »óÅÂ¿¡µû¶ó¼­ Ã³¸®
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
			//¸¸ÀÏ ºñ¹Ð¹øÈ£°¡ ÀÏÄ¡ÇÏÁö ¾Ê´Â °æ¿ì
			}
			model.addAttribute("loginFail", "ºñ¹Ð¹øÈ£°¡ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù.");
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
		System.out.println("¼®¼¼½ºÁ¶ÀÎ ½ÇÇà");
		if(email!=null) {
			vo.setEmail(email);
		}
		System.out.println(vo.toString());
		if(vo.getEmail()!=null && vo.getName()!=null && vo.getPassword()!=null)    {
			
			//ºñ¹Ð¹øÈ£ ¾ÏÈ£È­¸¦ ÇÏ±â À§ÇÑ BCryptPasswordEncoder °´Ã¼
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			System.out.println("¾ÏÈ£È­ Àü  : " + vo.getPassword());
			
			String encodePassword = encoder.encode(vo.getPassword());
			
			System.out.println("¾ÏÈ£È­ ÈÄ : " + encodePassword);
			vo.setPassword(encodePassword);
			
			insertMemberService.insertMember(vo);
			//¼º°ø,½ÇÆÐ¸¦ ±¸ºÐÇÏ´Â resultÇÃ·¡±×
			model.addAttribute("result","1");
			//session.setAttribute("memberSession",getMemberService.getMember(vo));
			//System.out.println("¼¼¼Ç È®ÀÎ!"+session.getAttribute("memberSession").toString());
		}else {
			//¼º°ø,½ÇÆÐ¸¦ ±¸ºÐÇÏ´Â resultÇÃ·¡±×
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
			sendMailUtil.sendMail("[Funthing] ÀÎÁõÄÚµå ÀÔ´Ï´Ù.", "ÀÎÁõÄÚµå : ["+certificationCode+"]", vo.getEmail());   
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
			System.out.println(vo.toString());
			if(getMemberService.getMember(vo)!=null) {
				System.out.println(getMemberService.getMember(vo).toString());
			String password = sendMailUtil.createCertificationCode(50);
			sendMailUtil.sendMail("[Funthing] ÀÓÀÇ·Î »ý¼ºµÈ ºñ¹Ð¹øÈ£ ÀÔ´Ï´Ù.", "¹ß¼ÛµÈ ºñ¹Ð¹øÈ£·Î ·Î±×ÀÎÀ» ÇÏ½Ã°í ²À "
					+ "¸¶ÀÌÆäÀÌÁö - È¸¿øÁ¤º¸¼öÁ¤ ¿¡¼­ ºñ¹Ð¹øÈ£¸¦ º¯°æÇÏ¿© ÀÌ¿ë¿¡ ºÒÆíÇÔÀÌ ¾øÀ¸½Ã±æ ¹Ù¶ø´Ï´Ù. "
					+ "ºñ¹Ð¹øÈ£ : ["+password+"]", vo.getEmail());
			MemberVO vo2 = getMemberService.getMember(vo);
			vo2.setPassword(password);
			System.out.println(vo2.toString());
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
		System.out.println("ÀÌ¸ÞÀÏ ®G!");
		System.out.println(getMemberService.getMember(vo));
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
		System.out.println(member.toString());
		
		model.addAttribute("member", member);
		return "f-update-profile";
	}

}