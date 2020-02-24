package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectAskMessageVO;

import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.ProjectAskMessageService.GetChoiceProjectAskMessageService;
import com.team5.funthing.user.service.ProjectAskMessageService.GetEntireProjectAskMessageListService;
import com.team5.funthing.user.service.ProjectAskMessageService.GetEntireProjectMakerAskMessageListService;
import com.team5.funthing.user.service.ProjectAskMessageService.GetMakerMemberCreatorService;
import com.team5.funthing.user.service.ProjectAskMessageService.InsertProjectAskContentsService;
import com.team5.funthing.user.service.ProjectAskMessageService.UpdateProjectAskReplyContentsStatusService;

import com.team5.funthing.user.service.projectBoardService.GetChoiceProjectBoardService;
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
	private GetChoiceProjectBoardService getChoiceProjectBoardService;
	@Autowired
	private GetEntireProjectMakerAskMessageListService getEntireProjectMakerAskMessageListService;
	@Autowired
	private GetProjectService getProjectService;
	

	
	@RequestMapping(value="showInsertwAskMessage.udo", method = RequestMethod.GET)
	public String showInsertwAskMessage(ProjectVO vo, Model model) { //문의메세지 입력 화면으로 가기
		
		System.out.println("프로젝트no물고 넘어왔다");
		
		//1.프로젝트 넘버로 프로젝트 테이블에서 프로젝트 제목 가져오기 
		vo.setProjectTitle(getProjectService.getProject(vo).getProjectTitle());//title가져오기
		vo.setCreator(getProjectService.getProject(vo).getCreator());//creator가져오기
		
		model.addAttribute("vo",vo);
		
		System.out.println("여기찍혀라"+getProjectService.getProject(vo).toString());
		
		return "f-projectAsk-message"; //글 작성하는곳
			
	}
	@RequestMapping(value="insertProjectAskContents.udo", method = RequestMethod.POST)
	public String insertProjectAskContents(ProjectAskMessageVO vo, Model model) { //문의메세지 입력하기 
		
		insertProjectAskContentsService.insertProjectAskContents(vo); //메세지 입력 
//		List<ProjectAskMessageVO>getEntireMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo);//전체목록보여주기
//		model.addAttribute("messagelist", getEntireMessageList);
		
		return "p-project-details"; //내가 보낸 문의 메세지 글 리스트 확인하는곳
			
	}
	
	
//--------------------------------마이페이지에서 메세지 눌렀을때------------------------------------(이거여기있어도되나?)
	

	@RequestMapping(value="showMyPageMessage.udo",method = RequestMethod.GET)
	public String showMyPageMessage(MemberVO vo, ProjectAskMessageVO vo2, Model model, HttpSession session) { //메세지 리스트로 이동
		
		
		if(getMakerMemberCreatorService.getMakerMemberCreator(vo) != null) { //메이커일때
			
			
//			vo2.setCreator("KGB아이티"); //이부분 나중에 바꿔야됨 지금은 임시로 프로젝트 넘버 생성
//			model.addAttribute("vo",vo2);
			
			session.setAttribute("makerCreator",getMakerMemberCreatorService.getMakerMemberCreator(vo).getEmail());
			System.out.println("여기찍어"+(String)session.getAttribute("makerCreator"));
			
			List<ProjectAskMessageVO>getEntireMakerMessageList = getEntireProjectMakerAskMessageListService.getEntireProjectMakerAskMessageList(vo2);//전체목록보여주기
			model.addAttribute("messagelist", getEntireMakerMessageList);
			
			return "p-message-check"; //메이커메세지 리스트(먼저뜬다) 확인하는곳 
		}else {
			System.out.println("혹시 여기로 온거니?");
			return "p-detail-mypage"; 
		}
		
			
	}
	
	
//---------------------------------메이커일때(만든프로젝트 있을)-----------------------------------
	
	@RequestMapping(value="getEntireMakerMessageList.udo", method = RequestMethod.POST)
	public String getMakerMemberCreator(MemberVO vo, ProjectAskMessageVO vo2, Model model, HttpSession session) { //메이커에게 온 문의리스트
		
		if(getMakerMemberCreatorService.getMakerMemberCreator(vo) != null) { //메이커일때
			
			vo2.setCreator("KGB아이티"); //이부분 나중에 바꿔야됨 지금은 임시로 프로젝트 넘버 생성
			model.addAttribute("vo",vo2);
			
			session.setAttribute("makerCreator",getMakerMemberCreatorService.getMakerMemberCreator(vo).getEmail());
			System.out.println("여기찍어"+(String)session.getAttribute("makerCreator"));
			
			List<ProjectAskMessageVO>getEntireMakerMessageList = getEntireProjectMakerAskMessageListService.getEntireProjectMakerAskMessageList(vo2);//전체목록보여주기
			model.addAttribute("messagelist", getEntireMakerMessageList);
			
			return "p-test-project-ask-list";  //내가 받은 문의 메세지 글 리스트 확인하는곳
			
			
		}else {//일반회원일때
			
		
			return "p-test-project-maker-user-list"; //리스트 버튼 선택 폼으로 
		}
		
		
			
	}
	
	
//---------------------------------메이커아닐때-----------------------------------------
	
	@RequestMapping(value="getEntireProjectAskMessageList.udo", method = RequestMethod.POST)
	public String getEntireProjectAskMessageList(ProjectAskMessageVO vo, Model model) { // 내가 후원한 메세지 전체목록보여주기
		
		List<ProjectAskMessageVO>getEntireMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo);//전체목록보여주기
		model.addAttribute("messagelist", getEntireMessageList);
		
		return "p-message-check"; //내가 보낸 문의 메세지 글 리스트 확인하는곳
			
	}
	
	
	
	@RequestMapping(value="getChoiceProjectAskMessage.udo", method = RequestMethod.GET)
	public String getChoiceProjectAskMessage(MemberVO vo2, ProjectAskMessageVO vo, Model model) { //선택한 문의 메세지 상세페이지로 이동  
		

		ProjectAskMessageVO getChoiceProjectAskMessage = getChoiceProjectAskMessageService.getChoiceProjectAskMessage(vo); //선택한 프로젝트 정보뽑기 
		model.addAttribute("choiceProjectAskMessage", getChoiceProjectAskMessage);
		
		return "p-test-project-ask-choicelist"; //선택한 문의 메세지 상세페이지 확인하는곳
			
	}
	
	

	@RequestMapping(value="updateProjectAskReplyContentsStatus.udo", method = RequestMethod.POST)
	public String updateProjectAskReplyContentsStatus(ProjectAskMessageVO vo, Model model) { //답변완료
		
		updateProjectAskReplyContentsStatusService.updateProjectAskReplyContentsStatus(vo);
		System.out.println("답변업데이트완료");
		
		List<ProjectAskMessageVO>getEntireMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo);//전체목록보여주기
		model.addAttribute("messagelist", getEntireMessageList);
		
		return "p-test-project-ask-list"; //내가 보낸 문의 메세지 글 리스트 확인하는곳
			
	}
	
	
	
	

}
