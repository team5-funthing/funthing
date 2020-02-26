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
		
		System.out.println("문의하기 누르면 메세지입력창으로 이동");
		
		vo.setProjectTitle(getProjectService.getProject(vo).getProjectTitle());//title 가져오기
		vo.setCreator(getProjectService.getProject(vo).getCreator());//creator 가져오기
		
		model.addAttribute("vo",vo);
		
		System.out.println("여기찍히니 애미나이야"+getProjectService.getProject(vo).toString());
		
		return "f-projectAsk-message"; //문의하기 입력창으로 
			
	}
	@RequestMapping(value="insertProjectAskContents.udo", method = RequestMethod.POST)
	public String insertProjectAskContents(ProjectAskMessageVO vo) { //참여자가 => 메이커에게 문의하기 입력
		
		insertProjectAskContentsService.insertProjectAskContents(vo); //문의하기 입력 
		
		return "p-project-details"; //프로젝트 페이지로 이동 

			
	}
	
	

//--------------------------------마이페이지에서 메세지 클릭시 들어오는곳------------------------------------(여기있어야되는건가?)
	
	
	@RequestMapping(value="showDetailMyPage.udo",method = RequestMethod.GET)
	public String showDetailMyPage(MemberVO vo, ProjectAskMessageVO vo2, Model model, HttpSession session) { 

		vo.setEmail((String)session.getAttribute("memberSessionEmail"));
		
		if(getMakerMemberCreatorService.getMakerMemberCreator(vo) != null) { //메이커 일때

//			1.creator인지 확인하기 
			MemberVO getMakerMember = getMakerMemberCreatorService.getMakerMemberCreator(vo); 
			model.addAttribute("getMakerMember",getMakerMember);
			
			System.out.println("뭐가찍히니 찍혀야돼"+getMakerMember);
			vo2.setCreator(getMakerMember.getCreator().getCreator());
			model.addAttribute("vo2",vo2);
	
			List<ProjectAskMessageVO>getEntireMakerMessageList = getEntireProjectMakerAskMessageListService.getEntireProjectMakerAskMessageList(vo2);
			model.addAttribute("messagelist", getEntireMakerMessageList);
			
//			2.내가 보낸 문의글 확인하기
			vo2.setEmail((String)session.getAttribute("memberSessionEmail"));
			List<ProjectAskMessageVO> getEntireProjectAskMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo2);
			model.addAttribute("getMessageList",getEntireProjectAskMessageList);
				

			return "p-message-check"; //메세지 리스트로 
			
		}else { //메이커가 아닐때 
			
			System.out.println("메이커가 아닙니다.");
				
//			내가 보낸 문의글 확인하기
			vo2.setEmail((String)session.getAttribute("memberSessionEmail"));
			List<ProjectAskMessageVO> getEntireProjectAskMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo2);
			model.addAttribute("getMessageList",getEntireProjectAskMessageList);
			
			
			return "p-message-check"; 
		}
	}
	
	//크리에이터가 보는 메세지 상세페이지 
	@RequestMapping(value="getChoiceProjectAskMessageC.udo", method = RequestMethod.GET) //문의번호 물고 들어오기 
	public String getChoiceProjectAskMessageC(ProjectAskMessageVO vo, MemberVO vo2, CreatorVO vo3, Model model, HttpSession session) { //리스트중 선택한 문의메세지 상세페이지로 이동
		
		

		ProjectAskMessageVO getChoiceProjectAskMessage = getChoiceProjectAskMessageService.getChoiceProjectAskMessage(vo); 
		model.addAttribute("choiceProjectAskMessage", getChoiceProjectAskMessage);
		
		vo2.setEmail((String)session.getAttribute("memberSessionEmail"));
		MemberVO getMakerMember = getMakerMemberCreatorService.getMakerMemberCreator(vo2); 
		vo3.setCreator(getMakerMember.getCreator().getCreator());
		model.addAttribute("vo3",vo3);
    
		return "f-projectAsk-message-reply-creator"; //크리에이터가 답변다는 곳
			
	}
	

	//크리에이터 아닌 일반회원이 보는 메세지 상세페이지
	@RequestMapping(value="getChoiceProjectAskMessage.udo", method = RequestMethod.GET) //문의번호 물고 들어오기 
	public String getChoiceProjectAskMessage(ProjectAskMessageVO vo, MemberVO vo2, CreatorVO vo3, Model model, HttpSession session) { //리스트중 선택한 문의메세지 상세페이지로 이동
		
		

		ProjectAskMessageVO getChoiceProjectAskMessage = getChoiceProjectAskMessageService.getChoiceProjectAskMessage(vo); 
		model.addAttribute("choiceProjectAskMessage", getChoiceProjectAskMessage);
		
		vo2.setEmail((String)session.getAttribute("memberSessionEmail"));
		
	
		return "f-projectAsk-message-reply"; //크리에이터가 답변다는 곳

			
	}
	
	@RequestMapping(value="updateProjectAskReplyContentsStatus.udo", method = RequestMethod.POST)
	public String updateProjectAskReplyContentsStatus(ProjectAskMessageVO vo) { //답변을 달면 수정으로 들어간다
		
		updateProjectAskReplyContentsStatusService.updateProjectAskReplyContentsStatus(vo);
		System.out.println("답변을 달았습니다.");
		
		
		return "redirect: showDetailMyPage.udo"; 
	}

	@RequestMapping(value="getEntireProjectAskMessageList.udo", method = RequestMethod.POST)
	public String getEntireProjectAskMessageList(ProjectAskMessageVO vo, Model model) { //내아이디로 보낸메세지찾기
		
		
		List<ProjectAskMessageVO> getEntireProjectAskMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo);
		model.addAttribute("getMessageList",getEntireProjectAskMessageList);
	
		return "redirect: showDetailMyPage.udo"; 
	}

	
	
	
	
	

	
	
	
	

}
