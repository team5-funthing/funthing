package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.team5.funthing.user.model.vo.CreatorVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectAskMessageVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.ProjectAskMessageService.GetChoiceProjectAskMessageService;
import com.team5.funthing.user.service.ProjectAskMessageService.GetEntireProjectAskMessageListService;
import com.team5.funthing.user.service.ProjectAskMessageService.GetEntireProjectMakerAskMessageListService;
import com.team5.funthing.user.service.ProjectAskMessageService.GetMakerMemberCreatorService;
import com.team5.funthing.user.service.ProjectAskMessageService.InsertProjectAskContentsService;
import com.team5.funthing.user.service.ProjectAskMessageService.UpdateProjectAskReplyContentsStatusService;
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
	

	
	@RequestMapping(value="showInsertwAskMessage.udo", method = RequestMethod.GET)

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
	public String showDetailMyPage(MemberVO vo, ProjectAskMessageVO vo2, Model model, HttpSession session) { 

		vo.setEmail((String)session.getAttribute("memberSessionEmail"));
		
		if(getMakerMemberCreatorService.getMakerMemberCreator(vo) != null) { //����Ŀ �϶�

//			1.creator���� Ȯ���ϱ� 
			MemberVO getMakerMember = getMakerMemberCreatorService.getMakerMemberCreator(vo); 
			model.addAttribute("getMakerMember",getMakerMember);
			
			System.out.println("���������� �����ߵ�"+getMakerMember);
			vo2.setCreator(getMakerMember.getCreator().getCreator());
			model.addAttribute("vo2",vo2);
	
			List<ProjectAskMessageVO>getEntireMakerMessageList = getEntireProjectMakerAskMessageListService.getEntireProjectMakerAskMessageList(vo2);
			model.addAttribute("messagelist", getEntireMakerMessageList);
			
//			2.���� ���� ���Ǳ� Ȯ���ϱ�
			vo2.setEmail((String)session.getAttribute("memberSessionEmail"));
			List<ProjectAskMessageVO> getEntireProjectAskMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo2);
			model.addAttribute("getMessageList",getEntireProjectAskMessageList);
				

			return "p-message-check"; //�޼��� ����Ʈ�� 
			
		}else { //����Ŀ�� �ƴҶ� 
			
			System.out.println("����Ŀ�� �ƴմϴ�.");
				
//			���� ���� ���Ǳ� Ȯ���ϱ�
			vo2.setEmail((String)session.getAttribute("memberSessionEmail"));
			List<ProjectAskMessageVO> getEntireProjectAskMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo2);
			model.addAttribute("getMessageList",getEntireProjectAskMessageList);
			
			
			return "p-message-check"; 
		}
	}
	
	//ũ�������Ͱ� ���� �޼��� �������� 
	@RequestMapping(value="getChoiceProjectAskMessageC.udo", method = RequestMethod.GET) //���ǹ�ȣ ���� ������ 
	public String getChoiceProjectAskMessageC(ProjectAskMessageVO vo, MemberVO vo2, CreatorVO vo3, Model model, HttpSession session) { //����Ʈ�� ������ ���Ǹ޼��� ���������� �̵�
		
		

		ProjectAskMessageVO getChoiceProjectAskMessage = getChoiceProjectAskMessageService.getChoiceProjectAskMessage(vo); 
		model.addAttribute("choiceProjectAskMessage", getChoiceProjectAskMessage);
		
		vo2.setEmail((String)session.getAttribute("memberSessionEmail"));
		MemberVO getMakerMember = getMakerMemberCreatorService.getMakerMemberCreator(vo2); 
		vo3.setCreator(getMakerMember.getCreator().getCreator());
		model.addAttribute("vo3",vo3);
    
		return "f-projectAsk-message-reply-creator"; //ũ�������Ͱ� �亯�ٴ� ��
			
	}
	

	//ũ�������� �ƴ� �Ϲ�ȸ���� ���� �޼��� ��������
	@RequestMapping(value="getChoiceProjectAskMessage.udo", method = RequestMethod.GET) //���ǹ�ȣ ���� ������ 
	public String getChoiceProjectAskMessage(ProjectAskMessageVO vo, MemberVO vo2, CreatorVO vo3, Model model, HttpSession session) { //����Ʈ�� ������ ���Ǹ޼��� ���������� �̵�
		
		

		ProjectAskMessageVO getChoiceProjectAskMessage = getChoiceProjectAskMessageService.getChoiceProjectAskMessage(vo); 
		model.addAttribute("choiceProjectAskMessage", getChoiceProjectAskMessage);
		
		vo2.setEmail((String)session.getAttribute("memberSessionEmail"));
		
	
		return "f-projectAsk-message-reply"; //ũ�������Ͱ� �亯�ٴ� ��

			
	}
	
	@RequestMapping(value="updateProjectAskReplyContentsStatus.udo", method = RequestMethod.POST)
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
