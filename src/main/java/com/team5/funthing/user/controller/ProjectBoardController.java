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
	public String insertProjectBoard(ProjectBoardVO vo, Model model) { //���۵���ϱ�
		
		System.out.println("�۵���Ѵ�");
		vo.setProjectNo(2020); //�̺κ� ���߿� �ٲ�ߵ� ������ �ӽ÷� ������Ʈ �ѹ� ����
		
		insertProjectBoardService.insertProjectBoard(vo);
		
		List<ProjectBoardVO> getProjectBoardList = getEntireProjectBoardListService.getEntireProjectBoardList(vo);
		model.addAttribute("list", getProjectBoardList); //��ü��ϸ���Ʈ ��������
		
		return "p-test-board"; //��ü�� �����ִ� �� 
			
		
	}
	
	@RequestMapping(value="newBoard.udo", method = RequestMethod.POST)
	public String newProjectBoard() { //�����ۼ�ȭ������ ����
		
		return "p-test-board-write"; //�� �ۼ��ϴ°�
			
	}
	
	
	@RequestMapping(value="replyBoard.udo", method = RequestMethod.POST)
	public String replyProjectBoard(ProjectBoardVO vo, Model model) { //����ۼ�ȭ������ ���� (Maker�� ���డ��)
		
		vo.setProjectBoardNo(vo.getProjectBoardNo());
		vo.setStep(vo.getStep());
		model.addAttribute("vo", vo);	
		
		return "p-test-board-reply"; //��� �ۼ��ϴ� ��
			
	}
	
	@RequestMapping(value="insertReplyProjectBoard.udo", method = RequestMethod.POST)
	public String insertReplyProjectBoard(ProjectBoardVO vo, Model model) { //����ۼ��ϱ� (Maker�� ���డ��)
		
		System.out.println("����ۼ��ϱ�");
		
		insertProjectBoardReplyService.insertProjectBoardReply(vo);
		List<ProjectBoardVO> getProjectBoardList = getEntireProjectBoardListService.getEntireProjectBoardList(vo);
		model.addAttribute("list", getProjectBoardList);//��ü��ϸ���Ʈ ��������
		
		return "p-test-board"; //��ü�� �����ִ� ��
			
	}
	
	
	@RequestMapping(value = "updateProjectBoard.udo", method = RequestMethod.POST )
	public String updateProjectBoard(ProjectBoardVO vo, Model model, HttpSession session) { //�ۼ����ϱ�
	
		System.out.println("�ۼ����ϱ�");
		
		updateProjectBoardService.updateProjectBoard(vo);	
		model.addAttribute("list",getEntireProjectBoardListService.getEntireProjectBoardList(vo)); //��ü��ϸ���Ʈ �������� 


		return "p-test-board"; //��ü�� �����ִ� ��
	 
	}
	
	@RequestMapping(value = "getProjectBoard.udo", method = RequestMethod.POST)
	public String updateProjectBoard(ProjectBoardVO vo, Model model) { //������ �� ��������

		
		System.out.println("�ۼ����� �� �ѱ��");
			
		String getProjectboardcontents = getChoiceProjectBoardService.getChoiceProjectBoard(vo); //������ �� �������� 
		vo.setProjectBoardContents(getProjectboardcontents);
		model.addAttribute("vo", vo);	

		return "p-test-board-write"; //�� ���� �ϴ� ��
	}
	
	@RequestMapping(value="deleteProjectBoard.udo" , method = RequestMethod.POST)
	public String deleteProjectBoard(ProjectBoardVO vo, Model model) { //�� �����ϱ�
		
		System.out.println("�� �����Ѵ�");
		
		deleteProjectBoardService.deleteProjectBoard(vo);
		model.addAttribute("list",getEntireProjectBoardListService.getEntireProjectBoardList(vo)); //��ü��ϸ���Ʈ �������� 

		return "p-test-board"; //��ü�� �����ִ� ��
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
