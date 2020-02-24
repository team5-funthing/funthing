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
	public String showProjectDetails(ProjectBoardVO vo, Model model) { //�̹���Ŭ���� ������Ʈ �� �������� �̵�
	
//		vo.setProjectNo(318); //�̺κ� ���߿� �ٲ�ߵ� ������ �ӽ÷� ������Ʈ �ѹ� ����
		
		vo.getProjectNo();
		model.addAttribute("vo",vo);
		
		System.out.println("������Ʈ �Խ��� �� �������� ");
		List<ProjectBoardVO> getProjectBoardList = getEntireProjectBoardListService.getEntireProjectBoardList(vo);
		model.addAttribute("getProjectBoard", getProjectBoardList); //��ü��ϸ���Ʈ �̸��̶� ���� �����ؼ� ��������
		
		return "p-project-details"; //������Ʈ ��������
	}
	
	
	@RequestMapping(value = "insertProjectBoard.udo", method = RequestMethod.POST )
	public String insertProjectBoard(ProjectBoardVO vo) { //���۵���ϱ�
		
		System.out.println("������Ʈ �Խ��� ���۵���Ѵ�");
		insertProjectBoardService.insertProjectBoard(vo);
		
		return "redirect: projectDetails.udo";//��ü�� �����ִ� �޼ҵ�� �̵� 
		
	}

	
	@RequestMapping(value="insertNewBoard.udo", method = RequestMethod.POST)
	public String newProjectBoard() { //�����ۼ�ȭ������ ����
		
		return "p-test-board-write"; //�� �ۼ��ϴ°�
			
	}
	
	
	@RequestMapping(value="replyBoard.udo", method = RequestMethod.GET)
	public String replyProjectBoard(ProjectBoardVO vo, Model model) { //����ۼ�ȭ������ ���� (Maker�� ���డ��)
		
		vo.setProjectBoardNo(vo.getProjectBoardNo());
		vo.setProjectBoardContents(getChoiceProjectBoardService.getChoiceProjectBoard(vo).getProjectBoardContents());//���밡������
		vo.setProjectBoardDate(getChoiceProjectBoardService.getChoiceProjectBoard(vo).getProjectBoardDate());//��¥��������
		vo.setEmail(getChoiceProjectBoardService.getChoiceProjectBoard(vo).getEmail());//�̸��ϰ�������? �̸����������ھ� 
		
		model.addAttribute("vo", vo);
		
		return "f-projectBoard-reply"; //��� �ۼ��ϴ� ��
			
	}
	
	@RequestMapping(value="insertReplyProjectBoard.udo", method = RequestMethod.POST)
	public String insertReplyProjectBoard(ProjectBoardVO vo, Model model) { //����ۼ��ϱ� (Maker�� ���డ��)
		
		System.out.println("����ۼ��ϱ�");
		insertProjectBoardReplyService.insertProjectBoardReply(vo);
		
		return "redirect: projectDetails.udo"; //��ü�� �����ִ� �޼ҵ�� �̵� 
			
	}
	
	@RequestMapping(value = "getProjectBoard.udo", method = RequestMethod.GET)
	public String updateProjectBoard(ProjectBoardVO vo, Model model) { //������ �� ��������

		System.out.println("�ۼ����� �� �ѱ��");
		
		vo.setProjectBoardNo(vo.getProjectBoardNo());//�� ��ȣ ��������
		vo.setProjectBoardContents(getChoiceProjectBoardService.getChoiceProjectBoard(vo).getProjectBoardContents());//���밡������
		
		System.out.println("������ �ֹ̳���"+vo.getProjectBoardContents());
		model.addAttribute("vo", vo);	

		return "f-projectBoard-update"; //�� ���� �ϴ� ��
	}
	
	@RequestMapping(value = "updateProjectBoard.udo", method = RequestMethod.POST )
	public String updateProjectBoard(ProjectBoardVO vo, Model model, HttpSession session) { //�ۼ����ϱ�
	
		System.out.println("�ۼ����ϱ�");
		updateProjectBoardService.updateProjectBoard(vo);	

		return "redirect: projectDetails.udo"; //��ü�� �����ִ� �޼ҵ�� �̵� 
	 
	}
	
	@RequestMapping(value="deleteProjectBoard.udo" , method = RequestMethod.GET)
	public String deleteProjectBoard(ProjectBoardVO vo, Model model) { //�� �����ϱ�
		
		System.out.println("�� �����Ѵ�");
		deleteProjectBoardService.deleteProjectBoard(vo);
	
		return "redirect: projectDetails.udo"; //��ü�� �����ִ� �޼ҵ�� �̵� 
	}
	
	
//------------------------------------------�亯�� ���-----------------------------------------
	
	//�亯�ۼ���
		@RequestMapping(value = "getProjectBoardReply.udo", method = RequestMethod.POST)
		public String updateReplyProjectBoard(ProjectBoardVO vo, Model model) { //�亯������ �� ��������

			System.out.println("�亯 �ۼ����� �� �ѱ��");
			
			vo.setRef(getChoiceProjectBoardReplyService.getChoiceProjectBoardReply(vo).getRef());//ref��������
			vo.setStep(getChoiceProjectBoardReplyService.getChoiceProjectBoardReply(vo).getStep());//step��������
			vo.setProjectBoardContents(getChoiceProjectBoardReplyService.getChoiceProjectBoardReply(vo).getProjectBoardContents());//���밡������
			
			model.addAttribute("vo", vo);	

			return "f-projectBoardReply-update"; //�� ���� �ϴ� ��
			
		}
	
	//�亯�� �����ϱ�
	@RequestMapping(value = "updateProjectBoardReply.udo", method = RequestMethod.POST )
	public String updateProjectBoardReply(ProjectBoardVO vo, Model model, HttpSession session) { //�亯�ۼ����ϱ�
	
		System.out.println("�亯�ۼ����ϱ�");
		updateProjectBoardReplyService.updateProjectBoardReply(vo);	

		return "redirect: projectDetails.udo"; //��ü�� �����ִ� �޼ҵ�� �̵� 
	 
	}
	
	//�亯�� �����ϱ� 
	@RequestMapping(value="deleteProjectBoardReply.udo" , method = RequestMethod.POST)
	public String deleteProjectBoardReply(ProjectBoardVO vo, Model model) { //�亯�� �����ϱ�
		
		System.out.println("�亯�� �����Ѵ�");
		deleteProjectBoardReplyServiceImpl.deleteProjectBoardReply(vo);
	
		return "redirect: projectDetails.udo"; //��ü�� �����ִ� �޼ҵ�� �̵� 
	}
	
	


}
