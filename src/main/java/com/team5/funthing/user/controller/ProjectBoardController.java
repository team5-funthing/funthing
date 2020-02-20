package com.team5.funthing.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.projectBoardService.DeleteProjectBoardService;
import com.team5.funthing.user.service.projectBoardService.EntireDeleateProjectBoardService;
import com.team5.funthing.user.service.projectBoardService.InsertProjectBoardService;
import com.team5.funthing.user.service.projectBoardService.SelectEntireProjectBoardListService;
import com.team5.funthing.user.service.projectBoardService.UpdateProjectBoardService;
import com.team5.funthing.user.service.projectService.GetProjectService;

@Controller
@SessionAttributes("member")
public class ProjectBoardController {
	
	@Autowired
	private DeleteProjectBoardService deleteProjectBoardService;
	@Autowired
	private EntireDeleateProjectBoardService entireDeleteProjectBoardService;
	@Autowired
	private InsertProjectBoardService insertProjectBoardService;
	@Autowired
	private SelectEntireProjectBoardListService selectEntireProjectBoardListService;
	@Autowired
	private UpdateProjectBoardService updateProjectBoardService;
	
	@Autowired
	private GetProjectService getProjectService; //프로젝트 가져오기 
	
//	@Autowired
//	private SelectMemberService selectMemberService; //프로젝트 가져오기 
	
	
	
	@RequestMapping(value = "insertprojectBoard.udo", method=RequestMethod.GET )
	public ModelAndView insertProjectBoard(ProjectBoardVO vo, HttpSession session) { //글등록하기
		System.out.println("여기까지 안와?");
		vo.setProjectno(2020);
		insertProjectBoardService.insertProjectBoard(vo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("List",selectEntireProjectBoardListService.selectEntireProjectBoardList(vo)); //전체목록리스트 가져오기 
		System.out.println(selectEntireProjectBoardListService.selectEntireProjectBoardList(vo).get(0).getMember().getName());
		mav.setViewName("p-test-board");
		return mav; //어느화면으로 갈건지 
	}
	
//	@RequestMapping("selectProjectBoardList.udo")
//	public String selectProjectBoardList(ProjectBoardVO vo, Model model) { 
//		model.addAttribute("List",selectEntireProjectBoardListService.selectEntireProjectBoardList(vo));
//		return "p-test-board";
//	}
	
	@RequestMapping("updateProjectBoard.udo")
	public String updateProjectBoard(ProjectBoardVO vo) { //글수정하기 
		updateProjectBoardService.updateProjectBoard(vo);
		return ""; //어느화면으로 갈건지 
	}
	
	@RequestMapping("deleteProjectBoard.udo")
	public String deleteProjectBoard(ProjectBoardVO vo) { //글 개별지우기 
		deleteProjectBoardService.deleteProjectBoard(vo);
		return ""; //어느화면으로 갈건지 
	}
	
	@RequestMapping("deleteAllProjectBoard.udo")
	public String deleteAllProjectBoard(ProjectBoardVO vo) { //글 전체지우기 
		entireDeleteProjectBoardService.entireDeleateProjectBoard(vo);
		return ""; //어느화면으로 갈건지 
	}
	
	@RequestMapping("replyBoard.udo")
	public String insertReplyProjectBoard(ProjectVO projectVO, MemberVO memberVO, ProjectBoardVO vo, HttpSession session) { //답글작성하기 (Maker만 수행가능) 
		
		String makerEmail = projectVO.getEmail();
		
		
		if(makerEmail.equals("memberSessionEmail")) { //메이커이메일과 프로젝트 보드의 이메일이 같으면 
			entireDeleteProjectBoardService.entireDeleateProjectBoard(vo);
			return ""; //어느화면으로 갈건지 
			
		}else {
			
			return ""; //어느화면으로 갈건지 
			
		}
		
	
	}
	
	
	
	
	
	
	
	

}
