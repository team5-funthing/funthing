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
	private GetProjectService getProjectService; //������Ʈ �������� 
	
//	@Autowired
//	private SelectMemberService selectMemberService; //������Ʈ �������� 
	
	
	
	@RequestMapping(value = "insertprojectBoard.udo", method=RequestMethod.GET )
	public ModelAndView insertProjectBoard(ProjectBoardVO vo, HttpSession session) { //�۵���ϱ�
		System.out.println("������� �ȿ�?");
		vo.setProjectno(2020);
		insertProjectBoardService.insertProjectBoard(vo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("List",selectEntireProjectBoardListService.selectEntireProjectBoardList(vo)); //��ü��ϸ���Ʈ �������� 
		System.out.println(selectEntireProjectBoardListService.selectEntireProjectBoardList(vo).get(0).getMember().getName());
		mav.setViewName("p-test-board");
		return mav; //���ȭ������ ������ 
	}
	
//	@RequestMapping("selectProjectBoardList.udo")
//	public String selectProjectBoardList(ProjectBoardVO vo, Model model) { 
//		model.addAttribute("List",selectEntireProjectBoardListService.selectEntireProjectBoardList(vo));
//		return "p-test-board";
//	}
	
	@RequestMapping("updateProjectBoard.udo")
	public String updateProjectBoard(ProjectBoardVO vo) { //�ۼ����ϱ� 
		updateProjectBoardService.updateProjectBoard(vo);
		return ""; //���ȭ������ ������ 
	}
	
	@RequestMapping("deleteProjectBoard.udo")
	public String deleteProjectBoard(ProjectBoardVO vo) { //�� ��������� 
		deleteProjectBoardService.deleteProjectBoard(vo);
		return ""; //���ȭ������ ������ 
	}
	
	@RequestMapping("deleteAllProjectBoard.udo")
	public String deleteAllProjectBoard(ProjectBoardVO vo) { //�� ��ü����� 
		entireDeleteProjectBoardService.entireDeleateProjectBoard(vo);
		return ""; //���ȭ������ ������ 
	}
	
	@RequestMapping("replyBoard.udo")
	public String insertReplyProjectBoard(ProjectVO projectVO, MemberVO memberVO, ProjectBoardVO vo, HttpSession session) { //����ۼ��ϱ� (Maker�� ���డ��) 
		
		String makerEmail = projectVO.getEmail();
		
		
		if(makerEmail.equals("memberSessionEmail")) { //����Ŀ�̸��ϰ� ������Ʈ ������ �̸����� ������ 
			entireDeleteProjectBoardService.entireDeleateProjectBoard(vo);
			return ""; //���ȭ������ ������ 
			
		}else {
			
			return ""; //���ȭ������ ������ 
			
		}
		
	
	}
	
	
	
	
	
	
	
	

}
