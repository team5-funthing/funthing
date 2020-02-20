package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.service.projectBoardService.DeleteProjectBoardService;
import com.team5.funthing.user.service.projectBoardService.GetChoiceProjectBoardService;
import com.team5.funthing.user.service.projectBoardService.GetEntireProjectBoardListService;
import com.team5.funthing.user.service.projectBoardService.InsertProjectBoardReplyService;
import com.team5.funthing.user.service.projectBoardService.InsertProjectBoardService;
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

	
	
	@RequestMapping(value = "insertProjectBoard.udo", method = RequestMethod.POST )
	public String insertProjectBoard(ProjectBoardVO vo, Model model) { //새글등록하기
		
		System.out.println("글등록한다");
		vo.setProjectNo(2020); //이부분 나중에 바꿔야됨 지금은 임시로 프로젝트 넘버 생성
		
		insertProjectBoardService.insertProjectBoard(vo);
		
		List<ProjectBoardVO> getProjectBoardList = getEntireProjectBoardListService.getEntireProjectBoardList(vo);
		model.addAttribute("list", getProjectBoardList); //전체목록리스트 가져오기
		
		return "p-test-board"; //전체글 보여주는 곳 
			
		
	}
	
	@RequestMapping(value="newBoard.udo", method = RequestMethod.POST)
	public String newProjectBoard() { //새글작성화면으로 가기
		
		return "p-test-board-write"; //글 작성하는곳
			
	}
	
	
	@RequestMapping(value="replyBoard.udo", method = RequestMethod.POST)
	public String replyProjectBoard(ProjectBoardVO vo, Model model) { //답글작성화면으로 가기 (Maker만 수행가능)
		
		vo.setProjectBoardNo(vo.getProjectBoardNo());
		vo.setStep(vo.getStep());
		model.addAttribute("vo", vo);	
		
		return "p-test-board-reply"; //답글 작성하는 곳
			
	}
	
	@RequestMapping(value="insertReplyProjectBoard.udo", method = RequestMethod.POST)
	public String insertReplyProjectBoard(ProjectBoardVO vo, Model model) { //답글작성하기 (Maker만 수행가능)
		
		System.out.println("답글작성하기");
		
		insertProjectBoardReplyService.insertProjectBoardReply(vo);
		List<ProjectBoardVO> getProjectBoardList = getEntireProjectBoardListService.getEntireProjectBoardList(vo);
		model.addAttribute("list", getProjectBoardList);//전체목록리스트 가져오기
		
		return "p-test-board"; //전체글 보여주는 곳
			
	}
	
	
	@RequestMapping(value = "updateProjectBoard.udo", method = RequestMethod.POST )
	public String updateProjectBoard(ProjectBoardVO vo, Model model, HttpSession session) { //글수정하기
	
		System.out.println("글수정하기");
		
		updateProjectBoardService.updateProjectBoard(vo);	
		model.addAttribute("list",getEntireProjectBoardListService.getEntireProjectBoardList(vo)); //전체목록리스트 가져오기 


		return "p-test-board"; //전체글 보여주는 곳
	 
	}
	
	@RequestMapping(value = "getProjectBoard.udo", method = RequestMethod.POST)
	public String updateProjectBoard(ProjectBoardVO vo, Model model) { //선택한 글 가져오기

		
		System.out.println("글수정할 글 넘기기");
			
		String getProjectboardcontents = getChoiceProjectBoardService.getChoiceProjectBoard(vo); //컨텐츠 글 가져오기 
		vo.setProjectBoardContents(getProjectboardcontents);
		model.addAttribute("vo", vo);	

		return "p-test-board-write"; //글 수정 하는 곳
	}
	
	@RequestMapping(value="deleteProjectBoard.udo" , method = RequestMethod.POST)
	public String deleteProjectBoard(ProjectBoardVO vo, Model model) { //글 삭제하기
		
		System.out.println("글 삭제한다");
		
		deleteProjectBoardService.deleteProjectBoard(vo);
		model.addAttribute("list",getEntireProjectBoardListService.getEntireProjectBoardList(vo)); //전체목록리스트 가져오기 

		return "p-test-board"; //전체글 보여주는 곳
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
