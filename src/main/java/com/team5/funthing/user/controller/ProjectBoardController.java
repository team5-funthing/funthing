package com.team5.funthing.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.service.impl.projectBoardServiceImpl.DeleteProjectBoardReplyServiceImpl;
import com.team5.funthing.user.service.projectBoardService.DeleteProjectBoardService;
import com.team5.funthing.user.service.projectBoardService.GetChoiceProjectBoardReplyService;
import com.team5.funthing.user.service.projectBoardService.GetChoiceProjectBoardService;
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
	

	
	@RequestMapping(value = "insertProjectBoard.udo", method = RequestMethod.GET )
	public String insertProjectBoard(	ProjectBoardVO vo,
										RedirectAttributes redirectAttributes) {
		
		insertProjectBoardService.insertProjectBoard(vo);
		
		redirectAttributes.addAttribute("currentProjectNo", vo.getProjectNo());
		
		return "redirect: projectDetailsFromProjectBoard.udo";
		
	}

	
	@RequestMapping(value="insertNewBoard.udo", method = RequestMethod.POST)
	public String newProjectBoard() {
		
		return "p-test-board-write";
			
	}
	
	
	@RequestMapping(value="replyBoard.udo", method = RequestMethod.GET)
	public String replyProjectBoard(ProjectBoardVO vo, Model model) {
		
		vo.setProjectBoardNo(vo.getProjectBoardNo());
		vo.setProjectBoardContents(getChoiceProjectBoardService.getChoiceProjectBoard(vo).getProjectBoardContents());
		vo.setProjectBoardDate(getChoiceProjectBoardService.getChoiceProjectBoard(vo).getProjectBoardDate());
		vo.setEmail(getChoiceProjectBoardService.getChoiceProjectBoard(vo).getEmail());
		
		model.addAttribute("vo", vo);
		
		return "f-projectBoard-reply";
			
	}
	
	@RequestMapping(value="insertReplyProjectBoard.udo", method = RequestMethod.GET)
	public String insertReplyProjectBoard(ProjectBoardVO vo, Model model, RedirectAttributes redirectAttributes) {
		
		insertProjectBoardReplyService.insertProjectBoardReply(vo);
		redirectAttributes.addAttribute("currentProjectNo", vo.getProjectNo());
		
		return "redirect: projectDetailsFromProjectBoard.udo";
			
	}
	
	@RequestMapping(value = "getProjectBoard.udo", method = RequestMethod.GET)
	public String updateProjectBoard(ProjectBoardVO vo, Model model) {
		
		vo.setProjectBoardNo(vo.getProjectBoardNo());
		vo.setProjectBoardContents(getChoiceProjectBoardService.getChoiceProjectBoard(vo).getProjectBoardContents());
		model.addAttribute("vo", vo);	

		return "f-projectBoard-update";
	}
	
	@RequestMapping(value = "updateProjectBoard.udo", method = RequestMethod.GET )
	public String updateProjectBoard(ProjectBoardVO vo, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		
		updateProjectBoardService.updateProjectBoard(vo);	
		redirectAttributes.addAttribute("currentProjectNo", vo.getProjectNo());

		return "redirect: projectDetailsFromProjectBoard.udo";
	 
	}
	
	@RequestMapping(value="deleteProjectBoard.udo" , method = RequestMethod.GET)
	public String deleteProjectBoard(ProjectBoardVO vo, Model model, RedirectAttributes redirectAttributes) {
		
		deleteProjectBoardService.deleteProjectBoard(vo);
		redirectAttributes.addAttribute("currentProjectNo", vo.getProjectNo());
	
		return "redirect: projectDetailsFromProjectBoard.udo"; 
	}
	

	@RequestMapping(value = "getProjectBoardReply.udo", method = RequestMethod.GET)
	public String updateReplyProjectBoard(ProjectBoardVO vo, Model model) {

		vo.setRef(getChoiceProjectBoardReplyService.getChoiceProjectBoardReply(vo).getRef());
		vo.setStep(getChoiceProjectBoardReplyService.getChoiceProjectBoardReply(vo).getStep());
		vo.setProjectBoardContents(getChoiceProjectBoardReplyService.getChoiceProjectBoardReply(vo).getProjectBoardContents());
		
		model.addAttribute("vo", vo);	

		return "f-projectBoardReply-update";
		
	}
	
	@RequestMapping(value = "updateProjectBoardReply.udo", method = RequestMethod.GET )
	public String updateProjectBoardReply(ProjectBoardVO vo, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
	
		updateProjectBoardReplyService.updateProjectBoardReply(vo);	
		redirectAttributes.addAttribute("currentProjectNo", vo.getProjectNo());

		return "redirect: projectDetailsFromProjectBoard.udo"; 
	 
	}

	@RequestMapping(value="deleteProjectBoardReply.udo" , method = RequestMethod.GET)
	public String deleteProjectBoardReply(ProjectBoardVO vo, Model model, RedirectAttributes redirectAttributes) {
		
		deleteProjectBoardReplyServiceImpl.deleteProjectBoardReply(vo);
		redirectAttributes.addAttribute("currentProjectNo", vo.getProjectNo());
	
		return "redirect: projectDetailsFromProjectBoard.udo";
	}
	
	


}
