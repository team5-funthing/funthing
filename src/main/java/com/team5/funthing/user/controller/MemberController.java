package com.team5.funthing.user.controller;

import java.io.IOException;

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
import com.team5.funthing.user.memberService.CertificationEmailService;
import com.team5.funthing.user.memberService.InsertMemberService;
import com.team5.funthing.user.memberService.SelectMemberService;
import com.team5.funthing.user.model.vo.MemberVO;

@Controller
@SessionAttributes("member")
public class MemberController {


   
   @Autowired
   private SelectMemberService selectMemberService;
   
   @Autowired
   private CertificationEmailService certificationEmailService;
   
   @Autowired
   private InsertMemberService insertMemberService;
   

   @RequestMapping("*.udo")
   public String showindex(MemberVO vo, HttpSession session) {
      return "p-index";
//      return "p-start-project";

   }
   
   @RequestMapping(value="loginmember.udo", method=RequestMethod.POST) // 로그인확인
   public String loginMember(MemberVO vo, HttpServletRequest request,HttpSession session) {
    System.out.println("달라"+selectMemberService.loginMember(vo).getPassword());

    if(selectMemberService.loginMember(vo) != null) { //vo가 널이아닐때 로그인 성공시
         if(selectMemberService.loginMember(vo).getPassword().equals(request.getParameter("password"))) { //패스워드 맞았을때  
         session.setAttribute("memberSessionEmail", selectMemberService.loginMember(vo).getEmail());
         session.setAttribute("memberSessionName", selectMemberService.loginMember(vo).getName());
         session.setAttribute("myprofile", selectMemberService.loginMember(vo).getMyImage()); //로그인하자마자 보여야되서 추가함 이게맞는건가요?귱씨?확인
         
  
         System.out.println(selectMemberService.getMember(vo).getMyImage());
         System.out.println("성공");
         
//            return "p-index";
            return "p-test-board-write";
         }else {
            System.out.println("실패");
            return "p-index";
         }
    }else { //vo가 널일때 로그인 실패시
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
      insertMemberService.insertSocialMember(vo);
      return "p-index";
   }
   
   @RequestMapping(value="successjoin.udo",method=RequestMethod.POST) // 가입성공해서 메인화면이동
   public String successjoin(MemberVO vo) {
      System.out.println("이메일로 가입 실행!");
      insertMemberService.insertMember(vo);
      return "p-index";
   }
   
   @RequestMapping(value="naverjoin.udo",method=RequestMethod.GET)
   public String naverJoin(MemberVO vo,HttpServletRequest request) {
      return "naverjoin";
   }
   
   @RequestMapping(value= "certification.udo" ,method=RequestMethod.GET )
   public String certificationEmail(MemberVO vo,Model model,HttpSession session) {
      try {
      certificationEmailService.sendCertificationEmail(vo);
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
//      String saveDir= "C:\\funthing\\project\\funthing\\src\\main\\webapp\\resources\\user\\img\\test";
	  String saveDir= "C:\\tomcat\\wtpwebapps\\funthing\\resources\\user\\img\\test";
      int maxPostSize = 3*1024*1024;
      String encoding = "UTF-8";
      MultipartRequest ms = new MultipartRequest(request, saveDir, maxPostSize, encoding, new DefaultFileRenamePolicy());  
       String renamedFile = ms.getFilesystemName("filename");
       System.out.println( ms.getFilesystemName("filename"));     
       ///  유지보수 에서 실패!!! 할 구간.     
       
       String email = (String) session.getAttribute("memberSessionEmail");
       vo.setEmail(email);
       vo.setMyImage(renamedFile);
      insertMemberService.saveImage(vo);
//      session.setAttribute("myprofile", selectMemberService.getMember(vo).getMyImage());
      
      return "p-index";
   }
     
   @RequestMapping(value="mypage.udo",method=RequestMethod.GET)
   public String myPage(HttpSession session,MemberVO vo,Model model) { //마이페이지로 이동 
   
//       
//     String email =  (String)session.getAttribute("memberSessionEmail");
//     vo.setEmail(email);
//     model.addAttribute("okname",selectMemberService.getMember(vo).getName());
//     //  p-detail-mypage 로 리다이렉트 실행시  파라미터값  okname=selectMemberService.getMember(vo).getName() 을 넘겨줌
      return "p-detail-mypage";
   }  
   @RequestMapping(value="logout.udo",method=RequestMethod.GET)
   public String logOut(HttpSession session) { //로그아웃 
     session.invalidate();
      return "p-index";
   }    
      
      
 
   
}
   