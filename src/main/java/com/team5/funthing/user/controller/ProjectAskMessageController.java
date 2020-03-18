package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.team5.funthing.user.model.vo.CSBoardVO;
import com.team5.funthing.user.model.vo.CreatorVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectAskMessageVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.creatorService.GetCreatorListByEmailService;
import com.team5.funthing.user.service.csboardService.GetUserCSBoardListService;
import com.team5.funthing.user.service.memberService.GetMemberService;
import com.team5.funthing.user.service.projectAskMessageService.GetChoiceProjectAskMessageService;
import com.team5.funthing.user.service.projectAskMessageService.GetEntireProjectAskMessageListService;
import com.team5.funthing.user.service.projectAskMessageService.GetEntireProjectMakerAskMessageListService;
import com.team5.funthing.user.service.projectAskMessageService.GetMakerMemberCreatorService;
import com.team5.funthing.user.service.projectAskMessageService.InsertProjectAskContentsService;
import com.team5.funthing.user.service.projectAskMessageService.UpdateProjectAskReplyContentsStatusService;
import com.team5.funthing.user.service.projectService.GetProjectService;

@Controller
@SessionAttributes("member")
public class ProjectAskMessageController {
   
   @Autowired
   private GetChoiceProjectAskMessageService getChoiceProjectAskMessageService;
   @Autowired
   private GetEntireProjectAskMessageListService getEntireProjectAskMessageListService;
   @Autowired
   private InsertProjectAskContentsService insertProjectAskContentsService;
   @Autowired
   private UpdateProjectAskReplyContentsStatusService updateProjectAskReplyContentsStatusService;
   @Autowired
   private GetMakerMemberCreatorService getMakerMemberCreatorService;
   @Autowired
   private GetEntireProjectMakerAskMessageListService getEntireProjectMakerAskMessageListService;
   @Autowired
   private GetProjectService getProjectService;
   @Autowired
   private GetMemberService getMemberService;
   @Autowired
   private GetCreatorListByEmailService getCreatorListByEmailService;

   
   
   @Autowired
   private GetUserCSBoardListService getCSBoardListService;
   
   @Autowired
   private MemberVO memberVO;
   

   @RequestMapping(value="showInsertwAskMessage.udo", method = RequestMethod.GET)
   public String showInsertwAskMessage(ProjectVO vo, Model model) { 

      vo.setProjectTitle(getProjectService.getProject(vo).getProjectTitle());
      vo.setCreator(getProjectService.getProject(vo).getCreator());

      
      model.addAttribute("vo",vo);

      return "f-projectAsk-message";
   }
   @RequestMapping(value="insertProjectAskContents.udo", method = RequestMethod.POST)
   public String insertProjectAskContents(ProjectAskMessageVO vo) {
      
      insertProjectAskContentsService.insertProjectAskContents(vo);
      
      return "p-project-details"; 


         
   }
   
   
   
   @RequestMapping(value="showDetailMyPage.udo",method = RequestMethod.GET)
   public String showDetailMyPage(CreatorVO cvo, MemberVO vo, ProjectAskMessageVO vo2, CSBoardVO vo3, Model model, HttpSession session) { 
	   
	  memberVO = (MemberVO)session.getAttribute("memberSession");
	  
	  String email = memberVO.getEmail();
	  
	  vo.setEmail(email);
	  vo2.setEmail(email);
	  cvo.setEmail(email);
      
      if(getMakerMemberCreatorService.getMakerMemberCreator(vo) != null) { 
    	  
    	 System.out.println("나는 크리에이터");

         MemberVO getMakerMember = getMakerMemberCreatorService.getMakerMemberCreator(vo); 
         System.out.println("메이커멤버 확인" + getMakerMember.toString());
         model.addAttribute("getMakerMember", getMakerMember);
         

         List<ProjectAskMessageVO> getEntireMakerMessageList = getEntireProjectMakerAskMessageListService.getEntireProjectMakerAskMessageList(vo2);
         
         ProjectVO pvo = new ProjectVO();
         for(ProjectAskMessageVO item: getEntireMakerMessageList) {
        	 System.out.println("작성자 : " + item.getEmail() + " ==  " + item.getProjectNo() + " - " + item.getCreator());
        	 pvo.setProjectNo(item.getProjectNo());
        	 pvo = getProjectService.getProject(pvo);
        	 item.setProject(pvo);
         }
         
         model.addAttribute("messagelist", getEntireMakerMessageList);
//        ==================================================================================
         
         // 그아이디가 보낸 메세지 리스트 띄어주기 
         List<ProjectAskMessageVO>privateMessagelist = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo2);
         System.out.println("여기에는?"+privateMessagelist.toString());
         model.addAttribute("privateMessagelist", privateMessagelist);
         
         
         vo3.setEmail(memberVO.getEmail());
         System.out.println("vo3 : "+ vo3);
         
         List<CSBoardVO> csboardList = getCSBoardListService.getCSBoardList(vo3);
         System.out.println(" : "+ csboardList.toString());
         model.addAttribute("askAdminList",csboardList);
         
         getMemberService.getMember(vo);
         model.addAttribute("getMember",getMemberService.getMember(vo));
         
         return "p-message-check"; 
         

      }else { 

         
    	  System.out.println("나는 그냥 구매자");
            
         vo2.setEmail(memberVO.getEmail());
         List<ProjectAskMessageVO> getEntireProjectAskMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo2);
         model.addAttribute("getMessageList",getEntireProjectAskMessageList);
         
         // 그아이디가 보낸 메세지 리스트 띄어주기 
         List<ProjectAskMessageVO>privateMessagelist = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo2);
         System.out.println("여기에는?"+privateMessagelist.toString());
         model.addAttribute("privateMessagelist", privateMessagelist);

         vo3.setEmail(memberVO.getEmail());
         System.out.println("vo3 : "+ vo3);
         
         getMemberService.getMember(vo);
         model.addAttribute("getMember",getMemberService.getMember(vo));
         
         List<CSBoardVO> csboardList = getCSBoardListService.getCSBoardList(vo3);
         model.addAttribute("askAdminList",csboardList);
         
         return "p-message-check"; 
      }
   }
   

   @RequestMapping(value="getChoiceProjectAskMessageC.udo", method = RequestMethod.GET) 
   public String getChoiceProjectAskMessageC(ProjectAskMessageVO vo, MemberVO vo2, CreatorVO vo3, Model model, HttpSession session) {
      
      

      ProjectAskMessageVO getChoiceProjectAskMessage = getChoiceProjectAskMessageService.getChoiceProjectAskMessage(vo); 
      model.addAttribute("choiceProjectAskMessage", getChoiceProjectAskMessage);
      
      vo2 = (MemberVO)session.getAttribute("memberSession");
      
      MemberVO getMakerMember = getMakerMemberCreatorService.getMakerMemberCreator(vo2); 
      vo3.setCreator(getMakerMember.getCreator().getCreator());
      model.addAttribute("vo3",vo3);
    
      return "f-projectAsk-message-reply-creator";
         
   }
   
   @RequestMapping(value="getChoiceProjectAskMessage.udo", method = RequestMethod.GET)  
   public String getChoiceProjectAskMessage(ProjectAskMessageVO vo, Model model) {
      
      ProjectAskMessageVO getChoiceProjectAskMessage = getChoiceProjectAskMessageService.getChoiceProjectAskMessage(vo); 
      model.addAttribute("choiceProjectAskMessage", getChoiceProjectAskMessage);

      return "f-projectAsk-message-reply";


         
   }
   
   @RequestMapping(value="updateProjectAskReplyContentsStatus.udo", method = RequestMethod.GET)
   public String updateProjectAskReplyContentsStatus(ProjectAskMessageVO vo) {
      updateProjectAskReplyContentsStatusService.updateProjectAskReplyContentsStatus(vo);
      return "redirect: showDetailMyPage.udo"; 
   }

   @RequestMapping(value="getEntireProjectAskMessageList.udo", method = RequestMethod.POST)
   public String getEntireProjectAskMessageList(ProjectAskMessageVO vo, Model model) {
      
      
      List<ProjectAskMessageVO> getEntireProjectAskMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo);
      model.addAttribute("getMessageList",getEntireProjectAskMessageList);
   
      return "redirect: showDetailMyPage.udo"; 

   }

   
   
   
   
   

   
   
   
   

}