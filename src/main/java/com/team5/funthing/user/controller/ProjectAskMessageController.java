package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectAskMessageVO;
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.service.projectAskMessageService.GetChoiceProjectAskMessageService;
import com.team5.funthing.user.service.projectAskMessageService.GetEntireProjectAskMessageListService;
import com.team5.funthing.user.service.projectAskMessageService.GetEntireProjectMakerAskMessageListService;
import com.team5.funthing.user.service.projectAskMessageService.GetMakerMemberCreatorService;
import com.team5.funthing.user.service.projectAskMessageService.InsertProjectAskContentsService;
import com.team5.funthing.user.service.projectAskMessageService.UpdateProjectAskReplyContentsStatusService;
import com.team5.funthing.user.service.projectBoardService.GetChoiceProjectBoardService;

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
	private GetChoiceProjectBoardService getChoiceProjectBoardService;
	@Autowired
	private GetEntireProjectMakerAskMessageListService getEntireProjectMakerAskMessageListService;
	
	

	
	@RequestMapping(value="insertNewAskMessage.udo", method = RequestMethod.POST)
	public String insertNewAskMessage(ProjectAskMessageVO vo, Model model) { //���Ǹ޼��� �Է� ȭ������ ����
		
		vo.setCreator("KGB����Ƽ"); //�̺κ� ���߿� �ٲ�ߵ� ������ �ӽ÷� ������Ʈ �ѹ� ����
		model.addAttribute("vo",vo);
		return "p-test-project-ask-message"; //�� �ۼ��ϴ°�
			
	}
	@RequestMapping(value="insertProjectAskContents.udo", method = RequestMethod.POST)
	public String insertProjectAskContents(ProjectAskMessageVO vo, Model model) { //���Ǹ޼��� �Է��ϱ� 
		
		insertProjectAskContentsService.insertProjectAskContents(vo); //�޼��� �Է� 
		List<ProjectAskMessageVO>getEntireMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo);//��ü��Ϻ����ֱ�
		model.addAttribute("messagelist", getEntireMessageList);
		
		return "p-test-project-ask-list"; //���� ���� ���� �޼��� �� ����Ʈ Ȯ���ϴ°�
			
	}
	
	@RequestMapping(value="getChoiceProjectAskMessage.udo", method = RequestMethod.GET)
	public String getChoiceProjectAskMessage(MemberVO vo2, ProjectAskMessageVO vo, Model model) { //������ ���� �޼��� ���������� �̵�  
		

		ProjectAskMessageVO getChoiceProjectAskMessage = getChoiceProjectAskMessageService.getChoiceProjectAskMessage(vo); //������ ������Ʈ �����̱� 
		model.addAttribute("choiceProjectAskMessage", getChoiceProjectAskMessage);
		
		return "p-test-project-ask-choicelist"; //������ ���� �޼��� �������� Ȯ���ϴ°�
			
	}
	
	@RequestMapping(value="getEntireProjectAskMessageList.udo", method = RequestMethod.POST)
	public String getEntireProjectAskMessageList(ProjectAskMessageVO vo, Model model) { //��Ϻ����ֱ�
		
		List<ProjectAskMessageVO>getEntireMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo);//��ü��Ϻ����ֱ�
		model.addAttribute("messagelist", getEntireMessageList);
		
		return "p-test-project-ask-list"; //���� ���� ���� �޼��� �� ����Ʈ Ȯ���ϴ°�
			
	}
	
	@RequestMapping(value="getEntireMakerMessageList.udo", method = RequestMethod.POST)
	public String getMakerMemberCreator(MemberVO vo, ProjectAskMessageVO vo2, Model model, HttpSession session) { //����Ŀ���� �� ���Ǹ���Ʈ
		
		if(getMakerMemberCreatorService.getMakerMemberCreator(vo) != null) { //����Ŀ�϶�
			
			vo2.setCreator("KGB����Ƽ"); //�̺κ� ���߿� �ٲ�ߵ� ������ �ӽ÷� ������Ʈ �ѹ� ����
			model.addAttribute("vo",vo2);
			
			session.setAttribute("makerCreator",getMakerMemberCreatorService.getMakerMemberCreator(vo).getEmail());
			System.out.println("�������"+(String)session.getAttribute("makerCreator"));
			
			List<ProjectAskMessageVO>getEntireMakerMessageList = getEntireProjectMakerAskMessageListService.getEntireProjectMakerAskMessageList(vo2);//��ü��Ϻ����ֱ�
			model.addAttribute("messagelist", getEntireMakerMessageList);
			
			return "p-test-project-ask-list";  //���� ���� ���� �޼��� �� ����Ʈ Ȯ���ϴ°�
			
			
		}else {//�Ϲ�ȸ���϶�
			
		
			return "p-test-project-maker-user-list"; //����Ʈ ��ư ���� ������ 
		}
		
		
			
	}
	
	@RequestMapping(value="updateProjectAskReplyContentsStatus.udo", method = RequestMethod.POST)
	public String updateProjectAskReplyContentsStatus(ProjectAskMessageVO vo, Model model) { //�亯�Ϸ�
		
		updateProjectAskReplyContentsStatusService.updateProjectAskReplyContentsStatus(vo);
		System.out.println("�亯������Ʈ�Ϸ�");
		
		List<ProjectAskMessageVO>getEntireMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo);//��ü��Ϻ����ֱ�
		model.addAttribute("messagelist", getEntireMessageList);
		
		return "p-test-project-ask-list"; //���� ���� ���� �޼��� �� ����Ʈ Ȯ���ϴ°�
			
	}
	
	
	
	

}
