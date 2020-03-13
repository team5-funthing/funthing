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
	

	
	@RequestMapping(value = "insertProjectBoardInterceptor.udo", method = RequestMethod.GET )
	public String insertProjectBoard(	ProjectBoardVO vo,
										RedirectAttributes redirectAttributes) { //���۵���ϱ�
		
		System.out.println("������Ʈ �Խ��� ���۵���Ѵ�");
		insertProjectBoardService.insertProjectBoard(vo);
		
		redirectAttributes.addAttribute("currentProjectNo", vo.getProjectNo());
		
		return "redirect: projectDetailsFromProjectBoard.udo";//��ü�� �����ִ� �޼ҵ�� �̵� 
		
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
	
	@RequestMapping(value="insertReplyProjectBoard.udo", method = RequestMethod.GET)
	public String insertReplyProjectBoard(ProjectBoardVO vo, Model model, RedirectAttributes redirectAttributes) { //����ۼ��ϱ� (Maker�� ���డ��)
		
		System.out.println("����ۼ��ϱ�");
		insertProjectBoardReplyService.insertProjectBoardReply(vo);
		redirectAttributes.addAttribute("currentProjectNo", vo.getProjectNo());
		System.out.println("����"+vo.getProjectNo());
		
		return "redirect: projectDetailsFromProjectBoard.udo"; //��ü�� �����ִ� �޼ҵ�� �̵� 
			
	}
	
	@RequestMapping(value = "getProjectBoard.udo", method = RequestMethod.GET)
	public String updateProjectBoard(ProjectBoardVO vo, Model model) { //������ �� ��������
		
		vo.setProjectBoardNo(vo.getProjectBoardNo());//�� ��ȣ ��������
		vo.setProjectBoardContents(getChoiceProjectBoardService.getChoiceProjectBoard(vo).getProjectBoardContents());//���밡������
		System.out.println("getProjectBoard vo getprojectNo : " + vo.getProjectNo());
		model.addAttribute("vo", vo);	

		return "f-projectBoard-update"; //�� ���� �ϴ� ��
	}
	
	@RequestMapping(value = "updateProjectBoard.udo", method = RequestMethod.GET )
	public String updateProjectBoard(ProjectBoardVO vo, Model model, HttpSession session, RedirectAttributes redirectAttributes) { //�ۼ����ϱ�
		
		System.out.println("�ۼ����ϱ�");
		updateProjectBoardService.updateProjectBoard(vo);	
		redirectAttributes.addAttribute("currentProjectNo", vo.getProjectNo());

		return "redirect: projectDetailsFromProjectBoard.udo"; //��ü�� �����ִ� �޼ҵ�� �̵� 
	 
	}
	
	@RequestMapping(value="deleteProjectBoard.udo" , method = RequestMethod.GET)
	public String deleteProjectBoard(ProjectBoardVO vo, Model model, RedirectAttributes redirectAttributes) { //�� �����ϱ�
		
		System.out.println("�� �����Ѵ�");
		deleteProjectBoardService.deleteProjectBoard(vo);
		redirectAttributes.addAttribute("currentProjectNo", vo.getProjectNo());
	
		return "redirect: projectDetailsFromProjectBoard.udo"; //��ü�� �����ִ� �޼ҵ�� �̵� 
	}
	
	
//------------------------------------------�亯�� ���-----------------------------------------
	
	//�亯�ۼ���
	@RequestMapping(value = "getProjectBoardReply.udo", method = RequestMethod.GET)
	public String updateReplyProjectBoard(ProjectBoardVO vo, Model model) { //�亯������ �� ��������

		System.out.println("�亯 �ۼ����� �� �ѱ��");
		
		vo.setRef(getChoiceProjectBoardReplyService.getChoiceProjectBoardReply(vo).getRef());//ref��������
		vo.setStep(getChoiceProjectBoardReplyService.getChoiceProjectBoardReply(vo).getStep());//step��������
		vo.setProjectBoardContents(getChoiceProjectBoardReplyService.getChoiceProjectBoardReply(vo).getProjectBoardContents());//���밡������
		
		model.addAttribute("vo", vo);	

		return "f-projectBoardReply-update"; //�� ���� �ϴ� ��
		
	}
	
	//�亯�� �����ϱ�
	@RequestMapping(value = "updateProjectBoardReply.udo", method = RequestMethod.GET )
	public String updateProjectBoardReply(ProjectBoardVO vo, Model model, HttpSession session, RedirectAttributes redirectAttributes) { //�亯�ۼ����ϱ�
	
		System.out.println("�亯�ۼ����ϱ�");
		updateProjectBoardReplyService.updateProjectBoardReply(vo);	
		redirectAttributes.addAttribute("currentProjectNo", vo.getProjectNo());

		return "redirect: projectDetailsFromProjectBoard.udo"; //��ü�� �����ִ� �޼ҵ�� �̵� 
	 
	}
	
	//�亯�� �����ϱ� 
	@RequestMapping(value="deleteProjectBoardReply.udo" , method = RequestMethod.GET)
	public String deleteProjectBoardReply(ProjectBoardVO vo, Model model, RedirectAttributes redirectAttributes) { //�亯�� �����ϱ�
		
		System.out.println("�亯�� �����Ѵ�");
		deleteProjectBoardReplyServiceImpl.deleteProjectBoardReply(vo);
		redirectAttributes.addAttribute("currentProjectNo", vo.getProjectNo());
	
		return "redirect: projectDetailsFromProjectBoard.udo"; //��ü�� �����ִ� �޼ҵ�� �̵� 
	}
	
	


}
