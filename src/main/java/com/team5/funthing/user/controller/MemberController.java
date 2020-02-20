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
		System.out.println("socialLoginSuccess.udo 占쎈뼄占쎈뻬");
		//   session.invalidate();  // 嚥≪뮄�젃占쎌뵥 占쎌읈 占쎄쉭占쎈�←룯�뜃由곤옙�넅 
		System.out.println("占쎈꺖占쎈�� 占쎈솭占쎈뮞占쎌뜖占쎈굡 :"+ getMemberService.getMember(vo).getPassword());
		if(getMemberService.getMember(vo) != null) { //vo揶쏉옙 占쎄섯占쎌뵠占쎈툡占쎈빜占쎈르 嚥≪뮄�젃占쎌뵥 占쎄쉐�⑤벊�뻻
			if(getMemberService.getMember(vo).getPassword().equals(request.getParameter("password"))) { //占쎈솭占쎈뮞占쎌뜖占쎈굡 筌띿쉸釉�占쎌뱽占쎈르  
				session.setAttribute("memberSessionEmail", getMemberService.getMember(vo).getEmail());
				session.setAttribute("memberSessionName", getMemberService.getMember(vo).getName());
				session.setAttribute("myprofile", getMemberService.getMember(vo).getMyImage());   
				System.out.println(getMemberService.getMember(vo).getMyImage());
				System.out.println("占쎈꺖占쎈�ζ에�뮄�젃占쎌뵥 占쎄쉐�⑨옙");

				return "p-index";
				
			}else {
				System.out.println("占쎈꺖占쎈�ζ에�뮄�젃占쎌뵥 占쎈뼄占쎈솭");
				return "p-waytoJoin-select";   //占쎈뼄占쎌젫嚥∽옙 占쎄텢占쎌뒠占쎈쭍 占쎌뵬 占쎈씨占쎈뮉野껓옙. 
			}
		}else { //vo揶쏉옙 占쎄섯占쎌뵬占쎈르 嚥≪뮄�젃占쎌뵥 占쎈뼄占쎈솭占쎈뻻
			System.out.println("占쎈꺖占쎈�ζ에�뮄�젃占쎌뵥 占쎈뼄占쎈솭");
			return "p-waytoJoin-select";
		}

	}


	@RequestMapping(value="getMember.udo", method=RequestMethod.POST) // 嚥≪뮄�젃占쎌뵥占쎌넇占쎌뵥
	public String getMember(MemberVO vo, HttpServletRequest request,HttpSession session) {
		System.out.println("getMember.udo 占쎈뼄占쎈뻬");
		if(getMemberService.getMember(vo) != null) { //vo揶쏉옙 占쎄섯占쎌뵠占쎈툡占쎈빜占쎈르 嚥≪뮄�젃占쎌뵥 占쎄쉐�⑤벊�뻻
			if(getMemberService.getMember(vo).getPassword().equals(request.getParameter("password"))) { //占쎈솭占쎈뮞占쎌뜖占쎈굡 筌띿쉸釉�占쎌뱽占쎈르  
				session.setAttribute("memberSessionEmail", getMemberService.getMember(vo).getEmail());
				session.setAttribute("memberSessionName", getMemberService.getMember(vo).getName());
				session.setAttribute("myprofile", getMemberService.getMember(vo).getMyImage()); //嚥≪뮄�젃占쎌뵥占쎈릭占쎌쁽筌띾뜆�쁽 癰귣똻肉э옙鍮욑옙由븝옙苑� �빊遺쏙옙占쎈맙 占쎌뵠野껊슢彛わ옙�뮉椰꾨떯占쏙옙�뒄?�삒�윲占�?占쎌넇占쎌뵥
				session.setAttribute("memberSessionPosition", getMemberService.getMember(vo).getPosition());

				System.out.println(getMemberService.getMember(vo).getMyImage());
				System.out.println("占쎄쉐�⑨옙");

//				return "p-index";
				return "p-test-board-write";
			}else {
				System.out.println("占쎈뼄占쎈솭");
				return "p-index";
			}
		}else { //vo揶쏉옙 占쎄섯占쎌뵬占쎈르 嚥≪뮄�젃占쎌뵥 占쎈뼄占쎈솭占쎈뻻
			return "p-index";
		}

	}


	@RequestMapping(value="joinselect.udo" ,method=RequestMethod.GET) // 占쎌돳占쎌뜚揶쏉옙占쎌뿯占쎄퐨占쎄문 占쎌넅筌롫똻�뵠占쎈짗
	public String login() {
		return "p-waytoJoin-select";
	}


	@RequestMapping(value="findpw.udo",method=RequestMethod.GET) // �뜮袁⑨옙甕곕뜇�깈 筌≪뼐由� 占쎌넅筌롫똻�뵠占쎈짗
	public String findpw() {
		return "f-find-pw";
	}

	@RequestMapping(value="emailJoin.udo",method=RequestMethod.GET) // 筌롫뗄�뵬嚥≪뮄占쏙옙�뿯占쎈릭疫뀐옙 占쎌넅筌롫똻�뵠占쎈짗
	public String emailjoin() {
		return "f-join";
	}

	@RequestMapping(value="successSocialjoin.udo",method=RequestMethod.GET) // 揶쏉옙占쎌뿯占쎄쉐�⑤벏鍮먲옙苑� 筌롫뗄�뵥占쎌넅筌롫똻�뵠占쎈짗
	public String successSocialjoin(MemberVO vo) {
		insertSocialMemberService.insertSocialMember(vo);
		return "p-index";
	}

	@RequestMapping(value="successjoin.udo",method=RequestMethod.POST) // 揶쏉옙占쎌뿯占쎄쉐�⑤벏鍮먲옙苑� 筌롫뗄�뵥占쎌넅筌롫똻�뵠占쎈짗
	public String successjoin(MemberVO vo) {
		System.out.println("占쎌뵠筌롫뗄�뵬嚥∽옙 揶쏉옙占쎌뿯 占쎈뼄占쎈뻬!");
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
			sendMailUtil.sendMail("[Funthing] 占쎌뵥筌앹빖苡뀐옙�깈 占쎌뿯占쎈빍占쎈뼄.", "占쎌뵥筌앹빖苡뀐옙�깈 ["+certificationCode+"]", "ajoqwer@gmail.com");	
			session.setAttribute("certificationCode", certificationCode);   
			/// �뜮袁⑨옙甕곕뜇�깈 占쎌삺占쎄퐬占쎌젟 占쎈읂占쎌뵠筌욑옙占쎈퓠占쎄퐣 占쎄쉭占쎈�� 占쎄텣占쎌젫 占쎈릭占쎈즲嚥∽옙 !!!!
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "f-find-id";
	}

	@RequestMapping(value="test.udo")
	public String tst(Model model) {

		model.addAttribute("test", "占쎌뵠野껉퍓猷� 筌띿쉸釉�");
		return "testing";
	}

	@RequestMapping(value="imageUpload.udo",method=RequestMethod.GET)
	public String imageUpload() {
		//占쎈씜嚥≪뮆諭띄몴占� 占쎌맄占쎈립 癰귢쑨而� 占쎈읂占쎌뵠筌욑옙
		return "f-imageUpload";
	}

	@RequestMapping(value="saveimage.udo",method=RequestMethod.POST)
	public String saveImage(HttpServletRequest request,MemberVO vo,HttpSession session) throws IOException {

		//  占쎈탵占쎌젂占쎈꽅�뵳�됰뮉    占쎈땾占쎌젟占쎈퉸占쎈튊占쎈맙.  �눧�똻�쒎쳞占� 占쎌쟿占쏙옙野껋럥以덃에占� 占쎄땜占쎌뿯占쎈퉸占쎈튊占쎈릭筌롳옙, 占쎌뒭占쎄퐨 疫꿸퀣�뜏占쎈뻷占쎌벥 野껋럥以덃에占� 占쎌삜占쎈뮉占쎈즲占쎈뼄.
		    String saveDir= "C:\\funthing\\project\\funthing\\src\\main\\webapp\\resources\\user\\img\\test";
//		String saveDir= "C:\\Users\\BEGGAR\\Desktop\\apache-tomcat-9.0.29\\wtpwebapps\\funthing\\resources\\user\\img\\test";
		int maxPostSize = 3*1024*1024;
		
		String encoding = "UTF-8";
		System.out.println(request.getParameterNames());
		MultipartRequest ms = new MultipartRequest(request, saveDir, maxPostSize, encoding, new DefaultFileRenamePolicy());  
		String renamedFile = ms.getFilesystemName("filename");
		System.out.println( ms.getFilesystemName("filename"));     
		///  占쎌�筌욑옙癰귣똻�땾 占쎈퓠占쎄퐣 占쎈뼄占쎈솭!!! 占쎈막 �뤃�덉퍢.     

		String email = (String) session.getAttribute("memberSessionEmail");
		vo.setEmail(email);
		vo.setMyImage(renamedFile);
		insertImageService.insertImage(vo);
		//  session.setAttribute("myprofile", getMemberService.getMember(vo).getMyImage());

		return "p-index";
	}

	@RequestMapping(value="mypage.udo",method=RequestMethod.GET)
	public String myPage(HttpSession session,MemberVO vo,Model model) { //筌띾뜆�뵠占쎈읂占쎌뵠筌욑옙嚥∽옙 占쎌뵠占쎈짗 

		//       
		//     String email =  (String)session.getAttribute("memberSessionEmail");
		//     vo.setEmail(email);
		//     model.addAttribute("okname",getMemberService.getMember(vo).getName());
		//     //  p-detail-mypage 嚥∽옙 �뵳�됰뼄占쎌뵠占쎌젂占쎈뱜 占쎈뼄占쎈뻬占쎈뻻  占쎈솁占쎌뵬沃섎챸苑ｅ첎占�  okname=getMemberService.getMember(vo).getName() 占쎌뱽 占쎄퐜野꺿뫁夷�
		return "p-detail-mypage";
	}  
	@RequestMapping(value="logout.udo",method=RequestMethod.GET)
	public String logOut(HttpSession session) { //嚥≪뮄�젃占쎈툡占쎌뜍 
		session.invalidate();
		return "p-index";
	}    


}
