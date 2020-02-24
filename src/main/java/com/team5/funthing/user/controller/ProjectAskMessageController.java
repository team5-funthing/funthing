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
import com.team5.funthing.user.service.projectAskMessageService.GetChoiceProjectAskMessageService;
import com.team5.funthing.user.service.projectAskMessageService.GetEntireProjectAskMessageListService;
import com.team5.funthing.user.service.projectAskMessageService.GetEntireProjectMakerAskMessageListService;
import com.team5.funthing.user.service.projectAskMessageService.GetMakerMemberCreatorService;
import com.team5.funthing.user.service.projectAskMessageService.InsertProjectAskContentsService;
import com.team5.funthing.user.service.projectAskMessageService.UpdateProjectAskReplyContentsStatusService;
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
	public String showInsertwAskMessage(ProjectVO vo, Model model) { //占쏙옙占실메쇽옙占쏙옙 占쌉뤄옙 화占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
		
		System.out.println("占쏙옙占쏙옙占쏙옙트no占쏙옙占쏙옙 占싼억옙都占�");
		
		//1.占쏙옙占쏙옙占쏙옙트 占싼뱄옙占쏙옙 占쏙옙占쏙옙占쏙옙트 占쏙옙占싱븝옙占쏙옙 占쏙옙占쏙옙占쏙옙트 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 
		vo.setProjectTitle(getProjectService.getProject(vo).getProjectTitle());//title占쏙옙占쏙옙占쏙옙占쏙옙
		vo.setCreator(getProjectService.getProject(vo).getCreator());//creator占쏙옙占쏙옙占쏙옙占쏙옙
		
		model.addAttribute("vo",vo);
		
		System.out.println("占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙"+getProjectService.getProject(vo).toString());
		
		return "f-projectAsk-message"; //占쏙옙 占쌜쇽옙占싹는곤옙
			
	}
	@RequestMapping(value="insertProjectAskContents.udo", method = RequestMethod.POST)
	public String insertProjectAskContents(ProjectAskMessageVO vo, Model model) { //占쏙옙占실메쇽옙占쏙옙 占쌉뤄옙占싹깍옙 
		
		insertProjectAskContentsService.insertProjectAskContents(vo); //占쌨쇽옙占쏙옙 占쌉뤄옙 
//		List<ProjectAskMessageVO>getEntireMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo);//占쏙옙체占쏙옙瞿占쏙옙占쏙옙殮占�
//		model.addAttribute("messagelist", getEntireMessageList);
		
		return "p-project-details"; //占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쌨쇽옙占쏙옙 占쏙옙 占쏙옙占쏙옙트 확占쏙옙占싹는곤옙
			
	}
	
	
//--------------------------------占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쌨쇽옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙------------------------------------(占싱거울옙占쏙옙占쌍어도占실놂옙?)
	

	@RequestMapping(value="showMyPageMessage.udo",method = RequestMethod.GET)
	public String showMyPageMessage(MemberVO vo, ProjectAskMessageVO vo2, Model model, HttpSession session) { //占쌨쇽옙占쏙옙 占쏙옙占쏙옙트占쏙옙 占싱듸옙
		
		
		if(getMakerMemberCreatorService.getMakerMemberCreator(vo) != null) { //占쏙옙占쏙옙커占싹띰옙
			
			
//			vo2.setCreator("KGB占쏙옙占쏙옙티"); //占싱부븝옙 占쏙옙占쌩울옙 占쌕뀐옙森占� 占쏙옙占쏙옙占쏙옙 占쌈시뤄옙 占쏙옙占쏙옙占쏙옙트 占싼뱄옙 占쏙옙占쏙옙
//			model.addAttribute("vo",vo2);
			
			session.setAttribute("makerCreator",getMakerMemberCreatorService.getMakerMemberCreator(vo).getEmail());
			System.out.println("占쏙옙占쏙옙占쏙옙占�"+(String)session.getAttribute("makerCreator"));
			
			List<ProjectAskMessageVO>getEntireMakerMessageList = getEntireProjectMakerAskMessageListService.getEntireProjectMakerAskMessageList(vo2);//占쏙옙체占쏙옙瞿占쏙옙占쏙옙殮占�
			model.addAttribute("messagelist", getEntireMakerMessageList);
			
			return "p-message-check"; //占쏙옙占쏙옙커占쌨쇽옙占쏙옙 占쏙옙占쏙옙트(占쏙옙占쏙옙占쏙옙占�) 확占쏙옙占싹는곤옙 
		}else {
			System.out.println("혹占쏙옙 占쏙옙占쏙옙占� 占승거댐옙?");
			return "p-detail-mypage"; 
		}
		
			
	}
	
	
//---------------------------------占쏙옙占쏙옙커占싹띰옙-----------------------------------
	
	@RequestMapping(value="getEntireMakerMessageList.udo", method = RequestMethod.POST)
	public String getMakerMemberCreator(MemberVO vo, ProjectAskMessageVO vo2, Model model, HttpSession session) { //占쏙옙占쏙옙커占쏙옙占쏙옙 占쏙옙 占쏙옙占실몌옙占쏙옙트
		
		if(getMakerMemberCreatorService.getMakerMemberCreator(vo) != null) { //占쏙옙占쏙옙커占싹띰옙
			
			vo2.setCreator("KGB占쏙옙占쏙옙티"); //占싱부븝옙 占쏙옙占쌩울옙 占쌕뀐옙森占� 占쏙옙占쏙옙占쏙옙 占쌈시뤄옙 占쏙옙占쏙옙占쏙옙트 占싼뱄옙 占쏙옙占쏙옙
			model.addAttribute("vo",vo2);
			
			session.setAttribute("makerCreator",getMakerMemberCreatorService.getMakerMemberCreator(vo).getEmail());
			System.out.println("占쏙옙占쏙옙占쏙옙占�"+(String)session.getAttribute("makerCreator"));
			
			List<ProjectAskMessageVO>getEntireMakerMessageList = getEntireProjectMakerAskMessageListService.getEntireProjectMakerAskMessageList(vo2);//占쏙옙체占쏙옙瞿占쏙옙占쏙옙殮占�
			model.addAttribute("messagelist", getEntireMakerMessageList);
			
			return "p-test-project-ask-list";  //占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쌨쇽옙占쏙옙 占쏙옙 占쏙옙占쏙옙트 확占쏙옙占싹는곤옙
			
			
		}else {//占싹뱄옙회占쏙옙占싹띰옙
			
		
			return "p-test-project-maker-user-list"; //占쏙옙占쏙옙트 占쏙옙튼 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 
		}
		
		
			
	}
	
	
//---------------------------------占쏙옙占쏙옙커占싣닐띰옙-----------------------------------------
	
	@RequestMapping(value="getEntireProjectAskMessageList.udo", method = RequestMethod.POST)
	public String getEntireProjectAskMessageList(ProjectAskMessageVO vo, Model model) { // 占쏙옙占쏙옙 占식울옙占쏙옙 占쌨쇽옙占쏙옙 占쏙옙체占쏙옙瞿占쏙옙占쏙옙殮占�
		
		List<ProjectAskMessageVO>getEntireMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo);//占쏙옙체占쏙옙瞿占쏙옙占쏙옙殮占�
		model.addAttribute("messagelist", getEntireMessageList);
		
		return "p-message-check"; //占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쌨쇽옙占쏙옙 占쏙옙 占쏙옙占쏙옙트 확占쏙옙占싹는곤옙
			
	}
	
	
	
	@RequestMapping(value="getChoiceProjectAskMessage.udo", method = RequestMethod.GET)
	public String getChoiceProjectAskMessage(MemberVO vo2, ProjectAskMessageVO vo, Model model) { //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쌨쇽옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占싱듸옙  
		

		ProjectAskMessageVO getChoiceProjectAskMessage = getChoiceProjectAskMessageService.getChoiceProjectAskMessage(vo); //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙트 占쏙옙占쏙옙占싱깍옙 
		model.addAttribute("choiceProjectAskMessage", getChoiceProjectAskMessage);
		
		return "p-test-project-ask-choicelist"; //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쌨쇽옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 확占쏙옙占싹는곤옙
			
	}
	
	

	@RequestMapping(value="updateProjectAskReplyContentsStatus.udo", method = RequestMethod.POST)
	public String updateProjectAskReplyContentsStatus(ProjectAskMessageVO vo, Model model) { //占썰변占싹뤄옙
		
		updateProjectAskReplyContentsStatusService.updateProjectAskReplyContentsStatus(vo);
		System.out.println("占썰변占쏙옙占쏙옙占쏙옙트占싹뤄옙");
		
		List<ProjectAskMessageVO>getEntireMessageList = getEntireProjectAskMessageListService.getEntireProjectAskMessageList(vo);//占쏙옙체占쏙옙瞿占쏙옙占쏙옙殮占�
		model.addAttribute("messagelist", getEntireMessageList);
		
		return "p-test-project-ask-list"; //占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쌨쇽옙占쏙옙 占쏙옙 占쏙옙占쏙옙트 확占쏙옙占싹는곤옙
			
	}
	
	
	
	

}
