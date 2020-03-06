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

import com.team5.funthing.admin.model.vo.AdminPersonalInfoProcessingVO;
import com.team5.funthing.admin.model.vo.AdminRegisterTosVO;
import com.team5.funthing.admin.service.adminRegisterTosService.GetRegisterTosListService;

import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.TosVO;
import com.team5.funthing.user.service.TosService.GetTosListService;
import com.team5.funthing.user.service.homeService.GetAttentionProjectService;
import com.team5.funthing.user.service.homeService.GetDeadLineListService;
import com.team5.funthing.user.service.homeService.GetLikeCountListService;
import com.team5.funthing.user.service.homeService.GetMoneyPercentListService;
import com.team5.funthing.user.service.homeService.GetProjectProgressListService;

import com.team5.funthing.user.service.projectService.GetAllFundingProjectListService;

import com.team5.funthing.user.service.personalInfoProcessingService.GetPersonalInfoProcessingListService;

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
	@Autowired
	private GetDeadLineListService getDeadLineListService;
	
	//=====================�빟愿�,媛쒖씤�젙蹂댁쿂由щ갑移� 愿��젴 �꽌鍮꾩뒪=========================
	
	@Autowired
	private GetTosListService getTosListService;
	@Autowired
	private GetPersonalInfoProcessingListService getPersonalInfoProcessingListService;
	@Autowired
	private GetRegisterTosListService getRegisterTosListService;

	
	@RequestMapping("*.udo") 
	public String showindex(ProjectBoardVO vo, ProjectVO vo2,AdminUserMainImageChangeVO vo3, Model model) { //留⑥쿂�쓬 硫붿씤�럹�씠吏� �뱾�뼱�삤�뒗
		
		//1.二쇰ぉ�븷留뚰븳 �봽濡쒖젥�듃 (�꽦怨듬せ�븿)
		List<ProjectBoardVO> attentionProject = getAttentionProjectService.getAttentionProjectList(vo); //1.�뙎湲� 媛��옣 留롮씠 �닚�꽌��濡� 媛��졇�삤湲� 
		model.addAttribute("attentionProject",attentionProject);
		
//		vo2.setProjectNo(Integer.parseInt(((ProjectBoardVO) getAttentionProjectService.getAttentionProjectList(vo)).getProjectNo());
		ProjectVO getProject = getProjectService.getProject(vo2); //projectNo�쑝濡� 媛��졇�삤湲� 
		model.addAttribute("getProject",getProject);
		
		//2.吏꾪뻾以묒씤 �봽濡쒖젥�듃 
		List<ProjectVO> progressList = getProjectProgressListService.getProjectProgressList(vo2); //2. 吏꾪뻾以묒씤 �봽濡쒖젥�듃 媛��졇�삤湲�
		model.addAttribute("progressList", progressList);
			//2踰덉㎏ �뒳�씪�씠�뱶
			List<ProjectVO> progressList2 = getProjectProgressListService.getProjectProgressList2(vo2); //2. 吏꾪뻾以묒씤 �봽濡쒖젥�듃 媛��졇�삤湲�
			model.addAttribute("progressList2",progressList2);
			//3踰덉㎏ �뒳�씪�씠�뱶
			List<ProjectVO> progressList3 = getProjectProgressListService.getProjectProgressList3(vo2); //2. 吏꾪뻾以묒씤 �봽濡쒖젥�듃 媛��졇�삤湲�
			model.addAttribute("progressList3", progressList3);
			
		//3.�씤湲고봽濡쒖젥�듃
		List<ProjectVO> likeCountList = getLikeCountListService.getLikeCountList(vo2);
		model.addAttribute("likeCountList",likeCountList);
			//2踰덉㎏ �뒳�씪�씠�뱶 
			List<ProjectVO> likeCountList2 = getLikeCountListService.getLikeCountList2(vo2);
			model.addAttribute("likeCountList2",likeCountList2);
			//3踰덉㎏ �뒳�씪�씠�뱶 
			List<ProjectVO> likeCountList3 = getLikeCountListService.getLikeCountList3(vo2);
			model.addAttribute("likeCountList3",likeCountList3);
		
		//4.�꽦怨듭엫諛뺥봽濡쒖젥�듃
		List<ProjectVO> moneyPercentList = getMoneyPercentListService.getMoneyPercentList(vo2);
		model.addAttribute("moneyPercentList",moneyPercentList);
		
			//2踰덉㎏ �뒳�씪�씠�뱶
			List<ProjectVO> moneyPercentList2 = getMoneyPercentListService.getMoneyPercentList2(vo2);
			model.addAttribute("moneyPercentList2",moneyPercentList2);
			//3踰덉㎏ �뒳�씪�씠�뱶
			List<ProjectVO> moneyPercentList3 = getMoneyPercentListService.getMoneyPercentList3(vo2);
			model.addAttribute("moneyPercentList3",moneyPercentList3);

		
		//5.留덇컧�엫諛뺥봽濡쒖젥�듃
		List<ProjectVO> deadLineList = getDeadLineListService.getDeadLineList(vo2);
		model.addAttribute("deadLineList",deadLineList);
		
			//2踰덉㎏ �뒳�씪�씠�뱶
			List<ProjectVO> deadLineList2 = getDeadLineListService.getDeadLineList2(vo2);
			model.addAttribute("deadLineList2",deadLineList2);
			//3踰덉㎏ �뒳�씪�씠�뱶
			List<ProjectVO> deadLineList3 = getDeadLineListService.getDeadLineList3(vo2);
			model.addAttribute("deadLineList3",deadLineList3);
    
		//6.�씠誘몄�	
			List<AdminUserMainImageChangeVO> getUserMainImageChangeList = getUserMainImageChangeListService.getUserMainImageChangeList(vo3);
			model.addAttribute("getUserMainImageChangeList",getUserMainImageChangeList);
		
			
			
			
		//7.二쇰ぉ�봽濡쒖젥�듃
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
	
	@RequestMapping("TosAndPolicy.udo")
	public String showTosAndPolicyPage(AdminRegisterTosVO rtvo, TosVO tvo, AdminPersonalInfoProcessingVO pvo, Model model) {
		
		model.addAttribute("getTosList", getTosListService.getTosList(tvo));
		model.addAttribute("getPersonalInfoProcessing", getPersonalInfoProcessingListService.getPersonalInfoProcessingList(pvo));
		model.addAttribute("getRegisterTosList",getRegisterTosListService.getRegisterTosList(rtvo));
		
		return "p-tosAndPolicy";
	}
	

}






