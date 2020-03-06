package com.team5.funthing.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.model.vo.AdminUserMainProjectVO;
import com.team5.funthing.admin.service.adminUserMainProjectService.GetFocusProjectListService;
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.homeService.GetAttentionProjectService;
import com.team5.funthing.user.service.homeService.GetLikeCountListService;
import com.team5.funthing.user.service.homeService.GetMoneyPercentListService;
import com.team5.funthing.user.service.homeService.GetProjectProgressListService;
import com.team5.funthing.user.service.projectService.GetAllFundingProjectListService;
import com.team5.funthing.user.service.projectService.GetProjectService;
import com.team5.funthing.user.service.userMainImageChangeService.GetUserMainImageChangeListService;

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
	@Autowired
	private GetUserMainImageChangeListService getUserMainImageChangeListService;
	@Autowired
	private GetFocusProjectListService getFocusProjectListService;
	@Autowired
	private GetAllFundingProjectListService getAllFundingProjectListService;
	
	@RequestMapping("*.udo") 
	public String showindex(ProjectBoardVO vo, ProjectVO vo2,AdminUserMainImageChangeVO vo3, Model model) { //��ó�� ���������� ������
		
		//1.�ָ��Ҹ��� ������Ʈ (��������)
		List<ProjectBoardVO> attentionProject = getAttentionProjectService.getAttentionProjectList(vo); //1.��� ���� ���� ������� �������� 
		model.addAttribute("attentionProject",attentionProject);
		
//		vo2.setProjectNo(Integer.parseInt(((ProjectBoardVO) getAttentionProjectService.getAttentionProjectList(vo)).getProjectNo());
		ProjectVO getProject = getProjectService.getProject(vo2); //projectNo���� �������� 
		model.addAttribute("getProject",getProject);
		
		//2.�������� ������Ʈ 
		List<ProjectVO> progressList = getProjectProgressListService.getProjectProgressList(vo2); //2. �������� ������Ʈ ��������
		model.addAttribute("progressList", progressList);
			//2��° �����̵�
			List<ProjectVO> progressList2 = getProjectProgressListService.getProjectProgressList2(vo2); //2. �������� ������Ʈ ��������
			model.addAttribute("progressList2",progressList2);
			//3��° �����̵�
			List<ProjectVO> progressList3 = getProjectProgressListService.getProjectProgressList3(vo2); //2. �������� ������Ʈ ��������
			model.addAttribute("progressList3", progressList3);
			
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
			
		//5.�̹���	
			List<AdminUserMainImageChangeVO> getUserMainImageChangeList = getUserMainImageChangeListService.getUserMainImageChangeList(vo3);
			model.addAttribute("getUserMainImageChangeList",getUserMainImageChangeList);
			
		//6.�ָ�������Ʈ
		List<AdminUserMainProjectVO> focusList = getFocusProjectListService.getFocusProjectList(vo2);
		List<ProjectVO> projectList = getAllFundingProjectListService.getAllFundingProjectList();
		List<ProjectVO> userMainFocusList = new ArrayList<ProjectVO>();
		for (int j = 0; j < focusList.size(); j++) {
			for (int i = 0; i < projectList.size(); i++) {

				if (focusList.get(j).getProjectNo() == projectList.get(i).getProjectNo()) {
					userMainFocusList.add(projectList.get(i));
				}

			}
		}
		model.addAttribute("userMainFocusList",userMainFocusList);
			
		return "p-index";
	}

}
