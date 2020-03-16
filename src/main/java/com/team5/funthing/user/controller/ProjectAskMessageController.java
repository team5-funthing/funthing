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
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.model.vo.ProjectVO;
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
   private GetUserCSBoardListService getCSBoardListService;
   
   @Autowired
   private MemberVO memberVO;
   
   

   @RequestMapping(value="showInsertwAskMessage.udo", method = RequestMethod.GET)
   public String showInsertwAskMessage(ProjectVO vo, Model model) { 

      vo.setProjectTitle(getProjectService.getProject(vo).getProjectTitle());//title 占쏙옙占쏙옙占쏙옙占쏙옙
      vo.setCreator(getProjectService.getProject(vo).getCreator());//creator 占쏙옙占쏙옙占쏙옙占쏙옙

      
      model.addAttribute("vo",vo);
      
      return "f-projectAsk-message"; //占쏙옙占쏙옙占싹깍옙 占쌉뤄옙창占쏙옙占쏙옙 
         
   }
   @RequestMapping(value="insertProjectAskContents.udo", method = RequestMethod.POST)
   public String insertProjectAskContents(ProjectAskMessageVO vo) { //占쏙옙占쏙옙占쌘곤옙 => 占쏙옙占쏙옙커占쏙옙占쏙옙 占쏙옙占쏙옙占싹깍옙 占쌉뤄옙
      
      insertProjectAskContentsService.insertProjectAskContents(vo); //占쏙옙占쏙옙占싹깍옙 占쌉뤄옙 
      
      return "p-project-details"; //占쏙옙占쏙옙占쏙옙트 占쏙옙占쏙옙占쏙옙占쏙옙 占싱듸옙 


         
   }
   
   


//--------------------------------占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쌨쇽옙占쏙옙 클占쏙옙占쏙옙 占쏙옙占쏙옙占승곤옙------------------------------------(占쏙옙占쏙옙占쌍억옙森풔째품占?)
   
   
   @RequestMapping(value="showDetailMyPage.udo",method = RequestMethod.GET)
   public String showDetailMyPage(MemberVO vo, ProjectAskMessageVO vo2,CSBoardVO vo3, Model model, HttpSession session) { 
	   
	  memberVO = (MemberVO)session.getAttribute("memberSession");
	  vo.setEmail(memberVO.getEmail());

      
      if(getMakerMemberCreatorService.getMakerMemberCreator(vo) != null) { //占쏙옙占쏙옙커 占싹띰옙

//       1.member占쏙옙占싱븝옙占 creator占쏙옙占싱븝옙 占쏙옙占쏙옙占쌔쇽옙 creator占쏙옙占쏙옙占쏙옙占쏙옙
         MemberVO getMakerMember = getMakerMemberCreatorService.getMakerMemberCreator(vo); 
         System.out.println("크占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙"+getMakerMember.toString());
         model.addAttribute("getMakerMember", getMakerMember);
         
//       creator占쏙옙 占쌍깍옙 占쏙옙占쏙옙
         vo2.setCreator(getMakerMember.getCreator().getCreator());
         model.addAttribute("vo2",vo2);
         
//       2.projectAskMessage占쏙옙占싱븝옙占쏙옙 creator占쏙옙 占승는억옙占쏙옙 占쏙옙占 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 (占쏙옙占썩서 project占쏙옙 占쏙옙占쏙옙占쌔쇽옙 projectMainImage占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙) 
   
         List<ProjectAskMessageVO>getEntireMakerMessageList = getEntireProjectMakerAskMessageListService.getEntireProjectMakerAskMessageList(vo2);
         System.out.println("占쏙옙占쏙옙占쏙옙占쏙옙"+getEntireMakerMessageList.toString());
         model.addAttribute("messagelist", getEntireMakerMessageList);
                
         
         
       // 3. 占쏙옙占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙占싹깍옙 
         vo3.setEmail(memberVO.getEmail());
         System.out.println("vo3 : "+ vo3);
         
         List<CSBoardVO> csboardList = getCSBoardListService.getCSBoardList(vo3);
         System.out.println("占쏙옙占썩에 占썰변占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 : "+ csboardList.toString());
         model.addAttribute("askAdminList",csboardList);
         
         getMemberService.getMember(vo);
         model.addAttribute("getMember",getMemberService.getMember(vo));
         
         return "p-message-check"; //占쌨쇽옙占쏙옙 占쏙옙占쏙옙트占쏙옙 
         
      }else { //占쏙옙占쏙옙커占쏙옙 占싣닐띰옙 
         
         System.out.println("占쏙옙占쏙옙커占쏙옙 占싣닙니댐옙.");
            
//       占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占실깍옙 확占쏙옙占싹깍옙
         vo2.setEmail(memberVO.getEmail());
         List<ProjectAskMessageVO> getEntireProjectAskMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo2);
         model.addAttribute("getMessageList",getEntireProjectAskMessageList);
         

         //    占쏙옙占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙占싹깍옙 
         vo3.setEmail(memberVO.getEmail());
         System.out.println("vo3 : "+ vo3);
         
         getMemberService.getMember(vo);
         model.addAttribute("getMember",getMemberService.getMember(vo));
         
         List<CSBoardVO> csboardList = getCSBoardListService.getCSBoardList(vo3);
         model.addAttribute("askAdminList",csboardList);
         
         return "p-message-check"; 
      }
   }
   

   //크占쏙옙占쏙옙占쏙옙占싶곤옙 占쏙옙占쏙옙 占쌨쇽옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 
   @RequestMapping(value="getChoiceProjectAskMessageC.udo", method = RequestMethod.GET) //占쏙옙占실뱄옙호 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 
   public String getChoiceProjectAskMessageC(ProjectAskMessageVO vo, MemberVO vo2, CreatorVO vo3, Model model, HttpSession session) { //占쏙옙占쏙옙트占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占실메쇽옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占싱듸옙
      
      

      ProjectAskMessageVO getChoiceProjectAskMessage = getChoiceProjectAskMessageService.getChoiceProjectAskMessage(vo); 
      model.addAttribute("choiceProjectAskMessage", getChoiceProjectAskMessage);
      
      vo2 = (MemberVO)session.getAttribute("memberSession");
      
      MemberVO getMakerMember = getMakerMemberCreatorService.getMakerMemberCreator(vo2); 
      vo3.setCreator(getMakerMember.getCreator().getCreator());
      model.addAttribute("vo3",vo3);
    
      return "f-projectAsk-message-reply-creator"; //크占쏙옙占쏙옙占쏙옙占싶곤옙 占썰변占쌕댐옙 占쏙옙
         
   }
   

   //크占쏙옙占쏙옙占쏙옙占쏙옙 占싣댐옙 占싹뱄옙회占쏙옙占쏙옙 占쏙옙占쏙옙 占쌨쇽옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
   @RequestMapping(value="getChoiceProjectAskMessage.udo", method = RequestMethod.GET) //占쏙옙占실뱄옙호 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 
   public String getChoiceProjectAskMessage(ProjectAskMessageVO vo, Model model) { //占쏙옙占쏙옙트占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占실메쇽옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占싱듸옙
      
      ProjectAskMessageVO getChoiceProjectAskMessage = getChoiceProjectAskMessageService.getChoiceProjectAskMessage(vo); 
      model.addAttribute("choiceProjectAskMessage", getChoiceProjectAskMessage);

      return "f-projectAsk-message-reply"; //크占쏙옙占쏙옙占쏙옙占싶곤옙 占썰변占쌕댐옙 占쏙옙


         
   }
   
   @RequestMapping(value="updateProjectAskReplyContentsStatus.udo", method = RequestMethod.GET)
   public String updateProjectAskReplyContentsStatus(ProjectAskMessageVO vo) { //占썰변占쏙옙 占쌨몌옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙載ｏ옙占
      
      updateProjectAskReplyContentsStatusService.updateProjectAskReplyContentsStatus(vo);
      System.out.println("占썰변占쏙옙 占쌨았쏙옙占싹댐옙.");
      
      
      return "redirect: showDetailMyPage.udo"; 
   }

   @RequestMapping(value="getEntireProjectAskMessageList.udo", method = RequestMethod.POST)
   public String getEntireProjectAskMessageList(ProjectAskMessageVO vo, Model model) { //占쏙옙占쏙옙占싱듸옙占 占쏙옙占쏙옙占쌨쇽옙占쏙옙찾占쏙옙
      
      
      List<ProjectAskMessageVO> getEntireProjectAskMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo);
      model.addAttribute("getMessageList",getEntireProjectAskMessageList);
   
      return "redirect: showDetailMyPage.udo"; 

   }

   
   
   
   
   

   
   
   
   

}