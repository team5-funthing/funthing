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
   
   
   @RequestMapping(value="showInsertwAskMessageInterceptor.udo", method = RequestMethod.GET)
   public String showInsertwAskMessage(ProjectVO vo, Model model) { 
      
      System.out.println("�����ϱ� ������ �޼����Է�â���� �̵�");
      
      vo.setProjectTitle(getProjectService.getProject(vo).getProjectTitle());//title ��������
      vo.setCreator(getProjectService.getProject(vo).getCreator());//creator ��������
      
      model.addAttribute("vo",vo);
      
      System.out.println("���������� �ֹ̳��̾�"+getProjectService.getProject(vo).toString());
      
      return "f-projectAsk-message"; //�����ϱ� �Է�â���� 
         
   }
   @RequestMapping(value="insertProjectAskContents.udo", method = RequestMethod.POST)
   public String insertProjectAskContents(ProjectAskMessageVO vo) { //�����ڰ� => ����Ŀ���� �����ϱ� �Է�
      
      insertProjectAskContentsService.insertProjectAskContents(vo); //�����ϱ� �Է� 
      
      return "p-project-details"; //������Ʈ �������� �̵� 


         
   }
   
   


//--------------------------------�������������� �޼��� Ŭ���� �����°�------------------------------------(�����־�ߵǴ°ǰ�?)
   
   
   @RequestMapping(value="showDetailMyPage.udo",method = RequestMethod.GET)
   public String showDetailMyPage(MemberVO vo, ProjectAskMessageVO vo2,CSBoardVO vo3, Model model, HttpSession session) { 
	   
	  memberVO = (MemberVO)session.getAttribute("memberSession");
	  vo.setEmail(memberVO.getEmail());

      
      if(getMakerMemberCreatorService.getMakerMemberCreator(vo) != null) { //����Ŀ �϶�

//       1.member���̺�� creator���̺� �����ؼ� creator��������
         MemberVO getMakerMember = getMakerMemberCreatorService.getMakerMemberCreator(vo); 
         System.out.println("ũ�������� ��������"+getMakerMember.toString());
         model.addAttribute("getMakerMember", getMakerMember);
         
//       creator�� �ֱ� ����
         vo2.setCreator(getMakerMember.getCreator().getCreator());
         model.addAttribute("vo2",vo2);
         
//       2.projectAskMessage���̺��� creator�� �´¾��� ��� ������ �������� (���⼭ project�� �����ؼ� projectMainImage�� ���� ��������) 
   
         List<ProjectAskMessageVO>getEntireMakerMessageList = getEntireProjectMakerAskMessageListService.getEntireProjectMakerAskMessageList(vo2);
         System.out.println("��������"+getEntireMakerMessageList.toString());
         model.addAttribute("messagelist", getEntireMakerMessageList);
                
         
         
       // 3. �����ڿ��� �����ϱ� 
         vo3.setEmail(memberVO.getEmail());
         System.out.println("vo3 : "+ vo3);
         
         List<CSBoardVO> csboardList = getCSBoardListService.getCSBoardList(vo3);
         System.out.println("���⿡ �亯���� ������������ : "+ csboardList.toString());
         model.addAttribute("askAdminList",csboardList);
         
         getMemberService.getMember(vo);
         model.addAttribute("getMember",getMemberService.getMember(vo));
         
         return "p-message-check"; //�޼��� ����Ʈ�� 
         
      }else { //����Ŀ�� �ƴҶ� 
         
         System.out.println("����Ŀ�� �ƴմϴ�.");
            
//       ���� ���� ���Ǳ� Ȯ���ϱ�
         vo2.setEmail(memberVO.getEmail());
         List<ProjectAskMessageVO> getEntireProjectAskMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo2);
         model.addAttribute("getMessageList",getEntireProjectAskMessageList);
         

         //    �����ڿ��� �����ϱ� 
         vo3.setEmail(memberVO.getEmail());
         System.out.println("vo3 : "+ vo3);
         
         getMemberService.getMember(vo);
         model.addAttribute("getMember",getMemberService.getMember(vo));
         
         List<CSBoardVO> csboardList = getCSBoardListService.getCSBoardList(vo3);
         model.addAttribute("askAdminList",csboardList);
         
         return "p-message-check"; 
      }
   }
   

   //ũ�������Ͱ� ���� �޼��� �������� 
   @RequestMapping(value="getChoiceProjectAskMessageC.udo", method = RequestMethod.GET) //���ǹ�ȣ ���� ������ 
   public String getChoiceProjectAskMessageC(ProjectAskMessageVO vo, MemberVO vo2, CreatorVO vo3, Model model, HttpSession session) { //����Ʈ�� ������ ���Ǹ޼��� ���������� �̵�
      
      

      ProjectAskMessageVO getChoiceProjectAskMessage = getChoiceProjectAskMessageService.getChoiceProjectAskMessage(vo); 
      model.addAttribute("choiceProjectAskMessage", getChoiceProjectAskMessage);
      
      vo2 = (MemberVO)session.getAttribute("memberSession");
      
      MemberVO getMakerMember = getMakerMemberCreatorService.getMakerMemberCreator(vo2); 
      vo3.setCreator(getMakerMember.getCreator().getCreator());
      model.addAttribute("vo3",vo3);
    
      return "f-projectAsk-message-reply-creator"; //ũ�������Ͱ� �亯�ٴ� ��
         
   }
   

   //ũ�������� �ƴ� �Ϲ�ȸ���� ���� �޼��� ��������
   @RequestMapping(value="getChoiceProjectAskMessage.udo", method = RequestMethod.GET) //���ǹ�ȣ ���� ������ 
   public String getChoiceProjectAskMessage(ProjectAskMessageVO vo, Model model) { //����Ʈ�� ������ ���Ǹ޼��� ���������� �̵�
      
      ProjectAskMessageVO getChoiceProjectAskMessage = getChoiceProjectAskMessageService.getChoiceProjectAskMessage(vo); 
      model.addAttribute("choiceProjectAskMessage", getChoiceProjectAskMessage);

      return "f-projectAsk-message-reply"; //ũ�������Ͱ� �亯�ٴ� ��


         
   }
   
   @RequestMapping(value="updateProjectAskReplyContentsStatus.udo", method = RequestMethod.GET)
   public String updateProjectAskReplyContentsStatus(ProjectAskMessageVO vo) { //�亯�� �޸� �������� ����
      
      updateProjectAskReplyContentsStatusService.updateProjectAskReplyContentsStatus(vo);
      System.out.println("�亯�� �޾ҽ��ϴ�.");
      
      
      return "redirect: showDetailMyPage.udo"; 
   }

   @RequestMapping(value="getEntireProjectAskMessageList.udo", method = RequestMethod.POST)
   public String getEntireProjectAskMessageList(ProjectAskMessageVO vo, Model model) { //�����̵�� �����޼���ã��
      
      
      List<ProjectAskMessageVO> getEntireProjectAskMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo);
      model.addAttribute("getMessageList",getEntireProjectAskMessageList);
   
      return "redirect: showDetailMyPage.udo"; 

   }

   
   
   
   
   

   
   
   
   

}