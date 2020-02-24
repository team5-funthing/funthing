package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.service.impl.projectBoardServiceImpl.DeleteProjectBoardReplyServiceImpl;
import com.team5.funthing.user.service.projectBoardService.DeleteProjectBoardService;
import com.team5.funthing.user.service.projectBoardService.GetChoiceProjectBoardReplyService;
import com.team5.funthing.user.service.projectBoardService.GetChoiceProjectBoardService;
import com.team5.funthing.user.service.projectBoardService.GetEntireProjectBoardListService;
import com.team5.funthing.user.service.projectBoardService.InsertProjectBoardReplyService;
import com.team5.funthing.user.service.projectBoardService.InsertProjectBoardService;
import com.team5.funthing.user.service.projectBoardService.UpdateProjectBoardReplyService;
import com.team5.funthing.user.service.projectBoardService.UpdateProjectBoardService;

@Controller
public class ProjectBoardController {
	
	@Autowired
	private DeleteProjectBoardService deleteProjectBoardService;
	@Autowired
	private InsertProjectBoardService insertProjectBoardService;
	@Autowired
	private GetEntireProjectBoardListService getEntireProjectBoardListService;
	@Autowired
	private UpdateProjectBoardService updateProjectBoardService;
	@Autowired
	private GetChoiceProjectBoardService getChoiceProjectBoardService;
	@Autowired
	private InsertProjectBoardReplyService insertProjectBoardReplyService;
	@Autowired
	private GetChoiceProjectBoardReplyService getChoiceProjectBoardReplyService;
	@Autowired
	private UpdateProjectBoardReplyService updateProjectBoardReplyService;
	@Autowired
	private DeleteProjectBoardReplyServiceImpl deleteProjectBoardReplyServiceImpl;
	
	@RequestMapping(value="projectDetails.udo", method = RequestMethod.GET)
	public String showProjectDetails(ProjectBoardVO vo, Model model) { //이미지클릭시 프로젝트 상세 페이지로 이동
	
//		vo.setProjectNo(318); //이부분 나중에 바꿔야됨 지금은 임시로 프로젝트 넘버 생성
		
		vo.getProjectNo();
		model.addAttribute("vo",vo);
		
		System.out.println("프로젝트 게시판 글 가져오기 ");
		List<ProjectBoardVO> getProjectBoardList = getEntireProjectBoardListService.getEntireProjectBoardList(vo);
		model.addAttribute("getProjectBoard", getProjectBoardList); //전체목록리스트 이름이랑 같이 조인해서 가져오기
		
		return "p-project-details"; //프로젝트 상세페이지
	}
	
	
	@RequestMapping(value = "insertProjectBoard.udo", method = RequestMethod.POST )
	public String insertProjectBoard(ProjectBoardVO vo) { //새글등록하기
		
		System.out.println("프로젝트 게시판 새글등록한다");
		insertProjectBoardService.insertProjectBoard(vo);
		
		return "redirect: projectDetails.udo";//전체글 보여주는 메소드로 이동 
		
	}

	
	@RequestMapping(value="insertNewBoard.udo", method = RequestMethod.POST)
	public String newProjectBoard() { //새글작성화면으로 가기
		
		return "p-test-board-write"; //글 작성하는곳
			
	}
	
	
	@RequestMapping(value="replyBoard.udo", method = RequestMethod.GET)
	public String replyProjectBoard(ProjectBoardVO vo, Model model) { //답글작성화면으로 가기 (Maker만 수행가능)
		
		vo.setProjectBoardNo(vo.getProjectBoardNo());
		vo.setProjectBoardContents(getChoiceProjectBoardService.getChoiceProjectBoard(vo).getProjectBoardContents());//내용가져오기
		vo.setProjectBoardDate(getChoiceProjectBoardService.getChoiceProjectBoard(vo).getProjectBoardDate());//날짜가져오기
		vo.setEmail(getChoiceProjectBoardService.getChoiceProjectBoard(vo).getEmail());//이메일가져오기? 이름못가져오겠어 
		
		model.addAttribute("vo", vo);
		
		return "f-projectBoard-reply"; //답글 작성하는 곳
			
	}
	
	@RequestMapping(value="insertReplyProjectBoard.udo", method = RequestMethod.POST)
	public String insertReplyProjectBoard(ProjectBoardVO vo, Model model) { //답글작성하기 (Maker만 수행가능)
		
		System.out.println("답글작성하기");
		insertProjectBoardReplyService.insertProjectBoardReply(vo);
		
		return "redirect: projectDetails.udo"; //전체글 보여주는 메소드로 이동 
			
	}
	
	@RequestMapping(value = "getProjectBoard.udo", method = RequestMethod.GET)
	public String updateProjectBoard(ProjectBoardVO vo, Model model) { //선택한 글 가져오기

		System.out.println("글수정할 글 넘기기");
		
		vo.setProjectBoardNo(vo.getProjectBoardNo());//글 번호 가져오기
		vo.setProjectBoardContents(getChoiceProjectBoardService.getChoiceProjectBoard(vo).getProjectBoardContents());//내용가져오기
		
		System.out.println("찍혀라 애미나이"+vo.getProjectBoardContents());
		model.addAttribute("vo", vo);	

		return "f-projectBoard-update"; //글 수정 하는 곳
	}
	
	@RequestMapping(value = "updateProjectBoard.udo", method = RequestMethod.POST )
	public String updateProjectBoard(ProjectBoardVO vo, Model model, HttpSession session) { //글수정하기
	
		System.out.println("글수정하기");
		updateProjectBoardService.updateProjectBoard(vo);	

		return "redirect: projectDetails.udo"; //전체글 보여주는 메소드로 이동 
	 
	}
	
	@RequestMapping(value="deleteProjectBoard.udo" , method = RequestMethod.GET)
	public String deleteProjectBoard(ProjectBoardVO vo, Model model) { //글 삭제하기
		
		System.out.println("글 삭제한다");
		deleteProjectBoardService.deleteProjectBoard(vo);
	
		return "redirect: projectDetails.udo"; //전체글 보여주는 메소드로 이동 
	}
	
	
//------------------------------------------답변쪽 기능-----------------------------------------
	
	//답변글수정
		@RequestMapping(value = "getProjectBoardReply.udo", method = RequestMethod.POST)
		public String updateReplyProjectBoard(ProjectBoardVO vo, Model model) { //답변선택한 글 가져오기

			System.out.println("답변 글수정할 글 넘기기");
			
			vo.setRef(getChoiceProjectBoardReplyService.getChoiceProjectBoardReply(vo).getRef());//ref가져오기
			vo.setStep(getChoiceProjectBoardReplyService.getChoiceProjectBoardReply(vo).getStep());//step가져오기
			vo.setProjectBoardContents(getChoiceProjectBoardReplyService.getChoiceProjectBoardReply(vo).getProjectBoardContents());//내용가져오기
			
			model.addAttribute("vo", vo);	

			return "f-projectBoardReply-update"; //글 수정 하는 곳
			
		}
	
	//답변글 수정하기
	@RequestMapping(value = "updateProjectBoardReply.udo", method = RequestMethod.POST )
	public String updateProjectBoardReply(ProjectBoardVO vo, Model model, HttpSession session) { //답변글수정하기
	
		System.out.println("답변글수정하기");
		updateProjectBoardReplyService.updateProjectBoardReply(vo);	

		return "redirect: projectDetails.udo"; //전체글 보여주는 메소드로 이동 
	 
	}
	
	//답변글 삭제하기 
	@RequestMapping(value="deleteProjectBoardReply.udo" , method = RequestMethod.POST)
	public String deleteProjectBoardReply(ProjectBoardVO vo, Model model) { //답변글 삭제하기
		
		System.out.println("답변글 삭제한다");
		deleteProjectBoardReplyServiceImpl.deleteProjectBoardReply(vo);
	
		return "redirect: projectDetails.udo"; //전체글 보여주는 메소드로 이동 
	}
	
	


}
