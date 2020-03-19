package com.team5.funthing.user.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team5.funthing.common.utils.uploadUtils.UploadUtil;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.deletememberService.InsertDeleteMemberTableService;
import com.team5.funthing.user.service.memberService.DeleteMemberService;
import com.team5.funthing.user.service.memberService.GetMemberService;
import com.team5.funthing.user.service.memberService.InsertImageService;
import com.team5.funthing.user.service.memberService.InsertSocialMemberService;
import com.team5.funthing.user.service.memberService.UpdateMemberService;

@Controller
public class MemberController2 {

	@Autowired
	GetMemberService getMemberService;
	@Autowired
	UpdateMemberService updateMemberService;
	@Autowired
	DeleteMemberService deleteMemberService;
	@Autowired
	InsertImageService insertImageService;
	@Autowired
	InsertSocialMemberService insertSocialMemberService;
	@Autowired
	InsertDeleteMemberTableService insertDeleteMemberService;
	@Autowired
	UploadUtil upload;
	
	@RequestMapping("deleteMember.udo")
	public String deleteMember(MemberVO vo,HttpSession session) {
		MemberVO vo2 =(MemberVO)session.getAttribute("memberSession");
		insertDeleteMemberService.insertDeleteMemberTableService(vo2);
		File file = new File(vo2.getMyImage());
		 if(file.exists()) {
			 file.delete();
		 }
		deleteMemberService.deleteMember(vo);
		Cookie cookieid = new Cookie("funthingCookieId",null);
		cookieid.setMaxAge(0);  /// kill the cookie 
		Cookie cookiepw = new Cookie("funthingCookiePw",null);
		cookiepw.setMaxAge(0); /// kill the cookie
		session.invalidate();
		return "p-index";
	}
	
	//
	@RequestMapping(value = "updateMember.udo",method= RequestMethod.POST)
		public String updateProfile(MemberVO vo,HttpSession session,Model model) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(vo.getPassword());
		vo.setPassword(encodedPassword);
		updateMemberService.updateMember(vo);
		session.removeAttribute("memberSession");
		session.setAttribute("memberSession", vo);
		model.addAttribute("ok","1");
		return "f-update-profile";
	}
	@RequestMapping(value = "updateSocialMember.udo",method= RequestMethod.POST)
	public String updateSocialProfile(MemberVO vo,HttpSession session) {
		System.out.println(session.getAttribute("memberSession"));
		MemberVO sessionpw = (MemberVO)session.getAttribute("memberSession");
		vo.setPassword(sessionpw.getPassword());
		updateMemberService.updateMember(vo);
		session.removeAttribute("memberSession");
		session.setAttribute("memberSession", vo);
		return "1";
	}
	
	@RequestMapping(value="updateCheck.udo",method=RequestMethod.POST)
	public String pwCheck(String pw,Model model,MemberVO vo,HttpSession session){
		MemberVO insertedMember = (MemberVO) session.getAttribute("memberSession");		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(pw, insertedMember.getPassword())) {
			model.addAttribute("result","1");
		}else {
			model.addAttribute("result","2");

		}
		return "ajax/callback";
	}

	
	   @RequestMapping(value="saveimage.udo",method=RequestMethod.POST)
	   @ResponseBody
	   public String saveImage(@RequestParam(name ="imgname") List<MultipartFile> uploadFile,MemberVO vo,HttpSession session) throws Exception {
		   MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		   File file = new File(vo2.getMyImage());
			 if(file.exists()) {
				 file.delete();
			 }
			 vo2.setMyImage("");
		   vo.setEmail(vo2.getEmail());
	       memberImageUploader(uploadFile, vo);

	        insertImageService.insertImage(vo);
	        session.setAttribute("memberSession", getMemberService.getMember(vo));
	        
	      return "1";
	   }

	   @RequestMapping(value="saveimage2.udo",method=RequestMethod.POST)
	   public String saveImage2(@RequestParam(name ="imgname") List<MultipartFile> uploadFile,MemberVO vo,HttpSession session) throws Exception {
		   MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		   File file = new File(vo2.getMyImage());
			 if(file.exists()) {
				 file.delete();
			 }
			 vo2.setMyImage("");
		   vo.setEmail(vo2.getEmail());
	       memberImageUploader(uploadFile, vo);
	        insertImageService.insertImage(vo);
	        session.setAttribute("memberSession", getMemberService.getMember(vo));
	        
	        return "f-update-profile";
	   }
	   
	   


	   @RequestMapping(value="deleteimage.udo",method=RequestMethod.POST)
	   public String deleteImage(@RequestParam(name ="imgname") List<MultipartFile> uploadFile,MemberVO vo,HttpSession session) throws Exception {
		   MemberVO vo2  = (MemberVO)session.getAttribute("memberSession");
		 File file = new File(vo2.getMyImage());
		 if(file.exists()) {
			 file.delete();
		 }
		 vo2.setMyImage("");
		 session.setAttribute("memberSession", vo2);
	      return "f-update-profile";
	   }


	   
	   
	public void memberImageUploader(List<MultipartFile> toDoUploadList, MemberVO vo) throws Exception {

		List<String> toRemoveFilePath = new ArrayList<String>();

				
		if(!toDoUploadList.get(0).isEmpty()) { 
			toRemoveFilePath.add(vo.getMyImage()); 

			String voName = vo.getClass().getSimpleName();
			List<String> toSettingPath = upload.upload(toDoUploadList, voName, toRemoveFilePath);


			if(toSettingPath == null) {  return;}

			if(toSettingPath == null) {  return;}

			
			int cnt = 1;
			for(String toInsertImage : toSettingPath) {
				System.out.println("cnt : " + cnt++);
				vo.setMyImage(toInsertImage);
			}
		}else {
		}
		
	}
	
	

	
	
	@RequestMapping(value="successSocialjoin.udo",method=RequestMethod.POST) 
	public String successjoin(MemberVO vo,Model model,@RequestParam(name="email2",required=false)String email,HttpSession session) {
		if(email!=null) {
			vo.setEmail(email);
		}
		System.out.println(vo.toString());
		if(vo.getEmail()!=null && vo.getName()!=null && vo.getPassword()!=null)    {
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();			
			String encodePassword = encoder.encode(vo.getPassword());
			vo.setPassword(encodePassword);			
			insertSocialMemberService.insertSocialMember(vo);

			model.addAttribute("result","1");

		}else {

			model.addAttribute("result","2");
		}

		return "ajax/callback";
	}
	
}
