package com.team5.funthing.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team5.funthing.admin.model.vo.AdminPersonalInfoProcessingVO;
import com.team5.funthing.admin.model.vo.AdminRegisterTosVO;
import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.model.vo.AdminUserMainProjectVO;
import com.team5.funthing.admin.service.adminRegisterTosService.GetRegisterTosListService;
import com.team5.funthing.admin.service.adminUserMainProjectService.GetFocusProjectListService;
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.TosVO;
import com.team5.funthing.user.service.TosService.GetTosListService;
import com.team5.funthing.user.service.homeService.GetAttentionProjectService;
import com.team5.funthing.user.service.homeService.GetDeadLineListService;
import com.team5.funthing.user.service.homeService.GetLikeCountListService;
import com.team5.funthing.user.service.homeService.GetMoneyPercentListService;
import com.team5.funthing.user.service.homeService.GetProjectProgressListService;
import com.team5.funthing.user.service.personalInfoProcessingService.GetPersonalInfoProcessingListService;
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
	@Autowired
	private GetDeadLineListService getDeadLineListService;
	
	
	@Autowired
	private GetTosListService getTosListService;
	@Autowired
	private GetPersonalInfoProcessingListService getPersonalInfoProcessingListService;
	@Autowired
	private GetRegisterTosListService getRegisterTosListService;

	
	@RequestMapping("*.udo") 
	public String showindex(	@RequestParam(value = "msg", required = false) String msg,
								ProjectBoardVO vo, ProjectVO vo2,AdminUserMainImageChangeVO vo3, Model model) { //筌띯뫁荑귨옙�벉 筌롫뗄�뵥占쎈읂占쎌뵠筌욑옙 占쎈굶占쎈선占쎌궎占쎈뮉
		
		
		List<ProjectBoardVO> attentionProject = getAttentionProjectService.getAttentionProjectList(vo); //1.占쎈솊疫뀐옙 揶쏉옙占쎌삢 筌띾‘�뵠 占쎈떄占쎄퐣占쏙옙嚥∽옙 揶쏉옙占쎌죬占쎌궎疫뀐옙 
		model.addAttribute("attentionProject",attentionProject);
		
		
		ProjectVO getProject = getProjectService.getProject(vo2);
		model.addAttribute("getProject",getProject);
		
		List<ProjectVO> progressList = getProjectProgressListService.getProjectProgressList(vo2); //2. 筌욊쑵六얌빳臾믪뵥 占쎈늄嚥≪뮇�젰占쎈뱜 揶쏉옙占쎌죬占쎌궎疫뀐옙
		model.addAttribute("progressList", progressList);
			List<ProjectVO> progressList2 = getProjectProgressListService.getProjectProgressList2(vo2); //2. 筌욊쑵六얌빳臾믪뵥 占쎈늄嚥≪뮇�젰占쎈뱜 揶쏉옙占쎌죬占쎌궎疫뀐옙
			model.addAttribute("progressList2",progressList2);
			List<ProjectVO> progressList3 = getProjectProgressListService.getProjectProgressList3(vo2); //2. 筌욊쑵六얌빳臾믪뵥 占쎈늄嚥≪뮇�젰占쎈뱜 揶쏉옙占쎌죬占쎌궎疫뀐옙
			model.addAttribute("progressList3", progressList3);
			
			
		List<ProjectVO> likeCountList = getLikeCountListService.getLikeCountList(vo2);
		model.addAttribute("likeCountList",likeCountList);
			List<ProjectVO> likeCountList2 = getLikeCountListService.getLikeCountList2(vo2);
			model.addAttribute("likeCountList2",likeCountList2);
			List<ProjectVO> likeCountList3 = getLikeCountListService.getLikeCountList3(vo2);
			model.addAttribute("likeCountList3",likeCountList3);
		

		List<ProjectVO> moneyPercentList = getMoneyPercentListService.getMoneyPercentList(vo2);
		model.addAttribute("moneyPercentList",moneyPercentList);
			List<ProjectVO> moneyPercentList2 = getMoneyPercentListService.getMoneyPercentList2(vo2);
			model.addAttribute("moneyPercentList2",moneyPercentList2);
			List<ProjectVO> moneyPercentList3 = getMoneyPercentListService.getMoneyPercentList3(vo2);
			model.addAttribute("moneyPercentList3",moneyPercentList3);

		

		List<ProjectVO> deadLineList = getDeadLineListService.getDeadLineList(vo2);
		model.addAttribute("deadLineList",deadLineList);
		

			List<ProjectVO> deadLineList2 = getDeadLineListService.getDeadLineList2(vo2);
			model.addAttribute("deadLineList2",deadLineList2);

			List<ProjectVO> deadLineList3 = getDeadLineListService.getDeadLineList3(vo2);
			model.addAttribute("deadLineList3",deadLineList3);
    

			List<AdminUserMainImageChangeVO> getUserMainImageChangeList = getUserMainImageChangeListService.getUserMainImageChangeList(vo3);
			AdminUserMainImageChangeVO getUserMainImageChangeList2 = null;
			List<AdminUserMainImageChangeVO> getUserMainImageChangeList3 = new ArrayList<AdminUserMainImageChangeVO>();
			System.out.println("사이즈:"+getUserMainImageChangeList.size());
			for(int i=0; i<getUserMainImageChangeList.size(); i++) {
			
				if(!getUserMainImageChangeList.isEmpty()) {
					
					getUserMainImageChangeList2=getUserMainImageChangeList.get(0);
					
				
					if(getUserMainImageChangeList.size() > 1) {
						
						if(i!=0) {
			
							getUserMainImageChangeList3.add(getUserMainImageChangeList.get(i));

							
						}
					}
				}
				
			}
			

			model.addAttribute("getUserMainImageChangeList2",getUserMainImageChangeList2);
			model.addAttribute("getUserMainImageChangeList3",getUserMainImageChangeList3);
			
			
			

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
		
	
		model.addAttribute("msg", msg);
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






