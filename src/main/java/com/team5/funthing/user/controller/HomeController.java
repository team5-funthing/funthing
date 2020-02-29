package com.team5.funthing.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.homeService.GetAttentionProjectService;
import com.team5.funthing.user.service.homeService.GetLikeCountListService;
import com.team5.funthing.user.service.homeService.GetMoneyPercentListService;
import com.team5.funthing.user.service.homeService.GetProjectProgressListService;
import com.team5.funthing.user.service.projectService.GetProjectService;

@Controller
public class HomeController {

	
	@Autowired
	private GetAttentionProjectService getAttentionProjectService;
	@Autowired
	private GetProjectService getProjectService;
	@Autowired
	private GetProjectProgressListService getProjectProgressListService;
	@Autowired
	private GetLikeCountListService getLikeCountListService;
	@Autowired
	private GetMoneyPercentListService getMoneyPercentListService;
	
	@RequestMapping("*.udo") 
	public String showindex(ProjectBoardVO vo, ProjectVO vo2, Model model) { //��ó�� ���������� ������
		
		//1.�ָ��Ҹ��� ������Ʈ (��������)
		List<ProjectBoardVO> attentionProject = getAttentionProjectService.getAttentionProjectList(vo); //1.��� ���� ���� ������� �������� 
		model.addAttribute("attentionProject",attentionProject);
		
//		vo2.setProjectNo(Integer.parseInt(((ProjectBoardVO) getAttentionProjectService.getAttentionProjectList(vo)).getProjectNo());
		ProjectVO getProject = getProjectService.getProject(vo2); //projectNo���� �������� 
		model.addAttribute("getProject",getProject);
		
		//2.�������� ������Ʈ 
		List<ProjectVO> progeressList = getProjectProgressListService.getProjectProgressList(vo2); //2. �������� ������Ʈ ��������
		model.addAttribute("progeressList",progeressList);
			//2��° �����̵�
			List<ProjectVO> progeressList2 = getProjectProgressListService.getProjectProgressList2(vo2); //2. �������� ������Ʈ ��������
			model.addAttribute("progeressList2",progeressList2);
			//3��° �����̵�
			List<ProjectVO> progeressList3 = getProjectProgressListService.getProjectProgressList3(vo2); //2. �������� ������Ʈ ��������
			model.addAttribute("progeressList3",progeressList3);
			
		//3.�α�������Ʈ
		List<ProjectVO> likeCountList = getLikeCountListService.getLikeCountList(vo2);
		model.addAttribute("likeCountList",likeCountList);
			//2��° �����̵� 
			List<ProjectVO> likeCountList2 = getLikeCountListService.getLikeCountList2(vo2);
			model.addAttribute("likeCountList2",likeCountList2);
			//3��° �����̵� 
			List<ProjectVO> likeCountList3 = getLikeCountListService.getLikeCountList3(vo2);
			model.addAttribute("likeCountList3",likeCountList3);
		
		//4.�����ӹ�������Ʈ
		List<ProjectVO> moneyPercentList = getMoneyPercentListService.getMoneyPercentList(vo2);
		model.addAttribute("moneyPercentList",moneyPercentList);
		
			//2��° �����̵�
			List<ProjectVO> moneyPercentList2 = getMoneyPercentListService.getMoneyPercentList2(vo2);
			model.addAttribute("moneyPercentList2",moneyPercentList2);
			//3��° �����̵�
			List<ProjectVO> moneyPercentList3 = getMoneyPercentListService.getMoneyPercentList3(vo2);
			model.addAttribute("moneyPercentList3",moneyPercentList3);
		
		return "p-index";
	}

}
