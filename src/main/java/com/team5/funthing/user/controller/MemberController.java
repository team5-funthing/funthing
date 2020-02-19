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
import com.team5.funthing.common.utils.SendMailUtil;
import com.team5.funthing.user.memberService.GetMemberService;
import com.team5.funthing.user.memberService.InsertImageService;
import com.team5.funthing.user.memberService.InsertMemberService;
import com.team5.funthing.user.memberService.InsertSocialMemberService;
import com.team5.funthing.user.model.vo.MemberVO;

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

	@RequestMapping("*.udo")
	public String showindex() {
		return "p-index";
	}

	@RequestMapping(value="socialLogin.udo",method=RequestMethod.GET)
	public String socialLogin() {   
		return "f-socialjoin";
	}
	@RequestMapping(value="socialLoginSuccess.udo",method=RequestMethod.POST)
	public String socialLoginSuccess(HttpServletRequest request,HttpSession session,MemberVO vo) {   
		System.out.println("socialLoginSuccess.udo �떎�뻾");
		//   session.invalidate();  // 濡쒓렇�씤 �쟾 �꽭�뀡珥덇린�솕 
		System.out.println("�냼�뀥 �뙣�뒪�썙�뱶 :"+getMemberService.getMember(vo).getPassword());
		if(getMemberService.getMember(vo) != null) { //vo媛� �꼸�씠�븘�땺�븣 濡쒓렇�씤 �꽦怨듭떆
			if(getMemberService.getMember(vo).getPassword().equals(request.getParameter("password"))) { //�뙣�뒪�썙�뱶 留욎븯�쓣�븣  
				session.setAttribute("memberSessionEmail", getMemberService.getMember(vo).getEmail());
				session.setAttribute("memberSessionName", getMemberService.getMember(vo).getName());
				session.setAttribute("myprofile", getMemberService.getMember(vo).getMyImage());   
				System.out.println(getMemberService.getMember(vo).getMyImage());
				System.out.println("�냼�뀥濡쒓렇�씤 �꽦怨�");

				return "p-index";
			}else {
				System.out.println("�냼�뀥濡쒓렇�씤 �떎�뙣");
				return "p-waytoJoin-select";   //�떎�젣濡� �궗�슜�맆 �씪 �뾾�뒗寃�. 
			}
		}else { //vo媛� �꼸�씪�븣 濡쒓렇�씤 �떎�뙣�떆
			System.out.println("�냼�뀥濡쒓렇�씤 �떎�뙣");
			return "p-waytoJoin-select";
		}

	}


	@RequestMapping(value="getMember.udo", method=RequestMethod.POST) // 濡쒓렇�씤�솗�씤
	public String getMember(MemberVO vo, HttpServletRequest request,HttpSession session) {
		System.out.println("getMember.udo �떎�뻾");
		if(getMemberService.getMember(vo) != null) { //vo媛� �꼸�씠�븘�땺�븣 濡쒓렇�씤 �꽦怨듭떆
			if(getMemberService.getMember(vo).getPassword().equals(request.getParameter("password"))) { //�뙣�뒪�썙�뱶 留욎븯�쓣�븣  
				session.setAttribute("memberSessionEmail", getMemberService.getMember(vo).getEmail());
				session.setAttribute("memberSessionName", getMemberService.getMember(vo).getName());
				session.setAttribute("myprofile", getMemberService.getMember(vo).getMyImage()); //濡쒓렇�씤�븯�옄留덉옄 蹂댁뿬�빞�릺�꽌 異붽��븿 �씠寃뚮쭪�뒗嫄닿��슂?혗蟯�?�솗�씤


				System.out.println(getMemberService.getMember(vo).getMyImage());
				System.out.println("�꽦怨�");

				return "p-index";
			}else {
				System.out.println("�떎�뙣");
				return "p-index";
			}
		}else { //vo媛� �꼸�씪�븣 濡쒓렇�씤 �떎�뙣�떆
			return "p-index";
		}

	}


	@RequestMapping(value="joinselect.udo" ,method=RequestMethod.GET) // �쉶�썝媛��엯�꽑�깮 �솕硫댁씠�룞
	public String login() {
		return "p-waytoJoin-select";
	}


	@RequestMapping(value="findpw.udo",method=RequestMethod.GET) // 鍮꾨�踰덊샇 李얘린 �솕硫댁씠�룞
	public String findpw() {
		return "f-find-pw";
	}

	@RequestMapping(value="emailJoin.udo",method=RequestMethod.GET) // 硫붿씪濡쒓��엯�븯湲� �솕硫댁씠�룞
	public String emailjoin() {
		return "f-join";
	}

	@RequestMapping(value="successSocialjoin.udo",method=RequestMethod.GET) // 媛��엯�꽦怨듯빐�꽌 硫붿씤�솕硫댁씠�룞
	public String successSocialjoin(MemberVO vo) {
		insertSocialMemberService.insertSocialMember(vo);
		return "p-index";
	}

	@RequestMapping(value="successjoin.udo",method=RequestMethod.POST) // 媛��엯�꽦怨듯빐�꽌 硫붿씤�솕硫댁씠�룞
	public String successjoin(MemberVO vo) {
		System.out.println("�씠硫붿씪濡� 媛��엯 �떎�뻾!");
		insertMemberService.insertMember(vo);
		return "p-index";
	}

	@RequestMapping(value="socialjoin.udo",method=RequestMethod.GET)
	public String naverJoin(MemberVO vo,HttpServletRequest request) {
		return "f-socialjoin";
	}

	@RequestMapping(value= "certification.udo" ,method=RequestMethod.GET )
	public String certificationEmail(MemberVO vo,Model model,HttpSession session) {
		try {
			String certificationCode = sendMailUtil.createCertificationCode(50);
			sendMailUtil.sendMail("[Funthing] �씤利앸쾲�샇 �엯�땲�떎.", "�씤利앸쾲�샇 ["+certificationCode+"]", "ajoqwer@gmail.com");	
			session.setAttribute("certificationCode", certificationCode);   
			/// 鍮꾨�踰덊샇 �옱�꽕�젙 �럹�씠吏��뿉�꽌 �꽭�뀡 �궘�젣 �븯�룄濡� !!!!
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "f-find-id";
	}

	@RequestMapping(value="test.udo")
	public String tst(Model model) {

		model.addAttribute("test", "�씠寃껊룄 留욎븘");
		return "testing";
	}

	@RequestMapping(value="imageUpload.udo",method=RequestMethod.GET)
	public String imageUpload() {
		//�뾽濡쒕뱶瑜� �쐞�븳 蹂꾧컻 �럹�씠吏�
		return "f-imageUpload";
	}

	@RequestMapping(value="saveimage.udo",method=RequestMethod.POST)
	public String saveImage(HttpServletRequest request,MemberVO vo,HttpSession session) throws IOException {

		//  �뵒�젆�넗由щ뒗    �닔�젙�빐�빞�븿.  臾댁“嫄� �젅��寃쎈줈濡� �궫�엯�빐�빞�븯硫�, �슦�꽑 湲곗썒�떂�쓽 寃쎈줈濡� �옟�뒗�룄�떎.
		//      String saveDir= "C:\\funthing\\project\\funthing\\src\\main\\webapp\\resources\\user\\img\\test";
		String saveDir= "C:/funthing/project/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/funthing/resources/user/uploadImg";
		int maxPostSize = 3*1024*1024;
		
		String encoding = "UTF-8";
		System.out.println(request.getParameterNames());
		MultipartRequest ms = new MultipartRequest(request, saveDir, maxPostSize, encoding, new DefaultFileRenamePolicy());  
		String renamedFile = ms.getFilesystemName("filename");
		System.out.println( ms.getFilesystemName("filename"));     
		///  �쑀吏�蹂댁닔 �뿉�꽌 �떎�뙣!!! �븷 援ш컙.     

		String email = (String) session.getAttribute("memberSessionEmail");
		vo.setEmail(email);
		vo.setMyImage(renamedFile);
		insertImageService.insertImage(vo);
		//  session.setAttribute("myprofile", getMemberService.getMember(vo).getMyImage());

		return "p-index";
	}

	@RequestMapping(value="mypage.udo",method=RequestMethod.GET)
	public String myPage(HttpSession session,MemberVO vo,Model model) { //留덉씠�럹�씠吏�濡� �씠�룞 

		//       
		//     String email =  (String)session.getAttribute("memberSessionEmail");
		//     vo.setEmail(email);
		//     model.addAttribute("okname",getMemberService.getMember(vo).getName());
		//     //  p-detail-mypage 濡� 由щ떎�씠�젆�듃 �떎�뻾�떆  �뙆�씪誘명꽣媛�  okname=getMemberService.getMember(vo).getName() �쓣 �꽆寃⑥쨲
		return "p-detail-mypage";
	}  
	@RequestMapping(value="logout.udo",method=RequestMethod.GET)
	public String logOut(HttpSession session) { //濡쒓렇�븘�썐 
		session.invalidate();
		return "p-index";
	}    


}
