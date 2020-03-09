package com.team5.funthing.user.controller;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team5.funthing.admin.model.vo.AdminCategoryVO;
import com.team5.funthing.admin.service.adminCategoryService.GetCategoryListService;
import com.team5.funthing.common.utils.uploadUtils.UploadUtil;
import com.team5.funthing.user.model.vo.AlarmVO;
import com.team5.funthing.user.model.vo.CreatorVO;
import com.team5.funthing.user.model.vo.KeywordVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.model.vo.ProjectIntroduceImageVO;
import com.team5.funthing.user.model.vo.ProjectKeywordVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.RewardVO
import com.team5.funthing.user.service.creatorService.GetCreatorListByEmailService;

import com.team5.funthing.user.service.AlarmService.InsertProjectJudgeRequestAlarmService;
import com.team5.funthing.user.service.creatorService.GetCreatorListService;
import com.team5.funthing.user.service.creatorService.InsertCreatorService;
import com.team5.funthing.user.service.creatorService.UpdateCreatorService;
import com.team5.funthing.user.service.keywordService.GetKeywordListService;
import com.team5.funthing.user.service.keywordService.InsertKeywordService;
import com.team5.funthing.user.service.projectBoardService.GetEntireProjectBoardListService;
import com.team5.funthing.user.service.projectIntroduceImageService.DeleteProjectIntroduceImageService;
import com.team5.funthing.user.service.projectIntroduceImageService.GetProjectIntroduceImageListService;
import com.team5.funthing.user.service.projectIntroduceImageService.InsertProjectIntroduceImageService;
import com.team5.funthing.user.service.projectKeywordService.DeleteProjectKeywordService;
import com.team5.funthing.user.service.projectKeywordService.GetProjectKeywordListService;
import com.team5.funthing.user.service.projectKeywordService.InsertProjectKeywordService;
import com.team5.funthing.user.service.projectService.DeleteProjectService;
import com.team5.funthing.user.service.projectService.GetAllFundingProjectListService;
import com.team5.funthing.user.service.projectService.GetProjectListByEmailService;
import com.team5.funthing.user.service.projectService.GetProjectService;
import com.team5.funthing.user.service.projectService.InsertProjectService;
import com.team5.funthing.user.service.projectService.UpdateProjectService;
import com.team5.funthing.user.service.rewardService.GetRewardListService;


/**
 * 
 * @author qpara
 *
 */

@Controller
@SessionAttributes("project")
public class ProjectController {

// ===================== 서비스 주입 ==============
	
	@Autowired
	private InsertProjectService insertProjectService;
	@Autowired
	private UpdateProjectService updateProjectService;
	@Autowired
	private DeleteProjectService deleteProjectService;
	@Autowired
	private GetProjectService getProjectService;	
	@Autowired 
	private GetProjectListByEmailService getProjectListByEmailService;
	@Autowired
	private GetAllFundingProjectListService getAllFundingProjectListService;
	@Autowired
	private GetCreatorListByEmailService getCreatorListByEmailService;

	// Keyword Service
	@Autowired
	private InsertKeywordService insertKeywordService;
	@Autowired
	private GetKeywordListService getKeywordListService;
	
	
	// ProjectKeyword Service
	@Autowired
	private InsertProjectKeywordService insertProjectKeywordService;
	@Autowired
	private GetProjectKeywordListService getProjectKeywordListService;
	@Autowired
	private DeleteProjectKeywordService deleteProjectKeywordService;
	
	
	// ProjectIntroduceImage Service
	@Autowired
	private InsertProjectIntroduceImageService insertProjectIntroduceImageService;
	@Autowired
	private GetProjectIntroduceImageListService getProjectIntroduceImageListService;
	@Autowired
	private DeleteProjectIntroduceImageService deleteProjectIntroduceImageService;
	
	

	// ProjectBoard Service
	@Autowired
	private GetEntireProjectBoardListService getEntireProjectBoardListService;
	
	// Creator Service
	@Autowired
	private InsertCreatorService insertCreatorService;
	@Autowired
	private UpdateCreatorService updateCreatorService;

	// Reward Service
	@Autowired
	private GetRewardListService getRewardListService;
	
	// Alarm Service
	@Autowired
	private InsertProjectJudgeRequestAlarmService insertProjectJudgeRequestAlarmService;
	
	//category Service
	@Autowired
	private GetCategoryListService getCategoryListSerivce;
	
// ===================== VO 주입 =====================
	
	@Autowired
	private MemberVO memberVO;
	@Autowired
	private ProjectVO projectVO;
	@Autowired
	private ProjectKeywordVO projectKeywordVO;
	@Autowired
	private KeywordVO keywordVO;
	@Autowired
	private ProjectIntroduceImageVO projectIntroduceImageVO;
	@Autowired
	private RewardVO rewardVO;
	@Autowired
	private ProjectBoardVO projectBoardVO;
	
	
// ===================== 유틸 주입 =====================

	@Autowired
	private UploadUtil uploadUtil;
	
	
	
// ===================== initBinder ==================
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            
			@Override
            public void setAsText(String text) throws IllegalArgumentException {
                this.setValue(Date.valueOf(text));
            }
        });
	}

// ===================== 메서드 =======================	
	
	@RequestMapping(value="getAllFundingProjectList.udo", method = RequestMethod.GET)
	public String getAllFundingProjectList(Model model) {
		
		List<ProjectVO> getAllFundingProjectList = getAllFundingProjectListService.getAllFundingProjectList();
		model.addAttribute("getAllFundingProjectList", getAllFundingProjectList);
		
		return "p-project-list";
	}
	
	@RequestMapping(value="showStartProjectPage.udo", method = RequestMethod.GET)
	public String startProject( RedirectAttributes redirectAttributes,
								HttpSession session, Model model) {
		
		memberVO = (MemberVO)session.getAttribute("memberSession");
		
		if(memberVO == null) {

			model.addAttribute("msg", "로그인 후 이용 가능합니다.");
			return "p-index";
		}
		model.addAttribute("loginEmail", memberVO.getEmail()); 
		return "p-start-project"; // 시작하기 페이지로 이동하자
	} // 로그인 시에만 프로젝트 만들기 접근 가능하도록 하기위해 세션에 저장된 값 확인 후 페이지 이동.
	
	@RequestMapping(value="/getWritingProject.udo", method = RequestMethod.GET)
	public String getProject(	@RequestParam int currentProjectNo, 
								@RequestParam(required = false)String msg, 
								AdminCategoryVO cvo, Model model) {
		
		projectVO.setProjectNo(currentProjectNo);
		projectIntroduceImageVO.setProjectNo(currentProjectNo);
		
		projectVO = getProjectService.getProject(projectVO);
		List<ProjectIntroduceImageVO> projectIntroduceImageList = getProjectIntroduceImageListService.getProjectIntroduceImageList(projectIntroduceImageVO);
		List<ProjectKeywordVO> projectKeywordList = getProjectKeywordList(projectVO);
		
		rewardVO.setProjectNo(currentProjectNo);
		List<RewardVO> getRewardList = getRewardListService.getRewardList(rewardVO);
		
		if(!projectIntroduceImageList.isEmpty()) {
			model.addAttribute("projectIntroduceImageList", projectIntroduceImageList);
		}
		if(!projectKeywordList.isEmpty()) {
			model.addAttribute("addedKeywordList", projectKeywordList);
		}
		if(!getRewardList.isEmpty()) {
			model.addAttribute("rewardList", getRewardList);
		}
		
		model.addAttribute("categoryList", getCategoryListSerivce.getCategoryList(cvo));
		model.addAttribute("msg", msg);
		model.addAttribute("writingProject", projectVO);
		
		return "f-create-project";
	}

	@RequestMapping(value="/showCreateProjectBasicForm.udo", method = RequestMethod.GET)
	public String showCreateProjectBasicForm(	HttpSession session, 
												ProjectVO pvo,
												CreatorVO cvo, 
												Model model) {

		session.removeAttribute("updatingProject");
		
		memberVO = (MemberVO)session.getAttribute("memberSession");
		pvo.setEmail(memberVO.getEmail());
		cvo.setEmail(memberVO.getEmail());
		
		List<CreatorVO> getCreatorList = getCreatorListByEmailService.getCreatorListByEmail(cvo);
		if(!getCreatorList.isEmpty()) {
			model.addAttribute("getCreatorList", getCreatorList);
		}
		
		List<ProjectVO> getProjectList = getProjectListByEmailService.getProjectListByEmail(pvo);
		if(!getProjectList.isEmpty()) {
			model.addAttribute("getProjectList", getProjectList);
		}
		model.addAttribute("basicProjectSetting", pvo);
		
		return "f-create-project-basic"; // 프로젝트 작성 폼
	} // 프로젝트 만들기 시작 페이지에서 수행
	
	//리워드 등록시에 목록을 추가하는 메서드 추가해야한다()
  
	@RequestMapping(value = "/insertProject.udo", method = RequestMethod.POST)
	public String insertProject(	@RequestParam(name = "creatorUploadImage", required = false)List<MultipartFile> creatorUploadImage,
									@RequestParam(name = "businessUploadFile", required = false)List<MultipartFile> businessUploadFile,
									HttpSession session, 
									ProjectVO pvo, 
									CreatorVO cvo,
									AdminCategoryVO acvo,
									Model model) throws Exception {

		// 프로젝트 제작 첫 시작시에만 시작
		ProjectVO checkVO = (ProjectVO)session.getAttribute("updatingProject");


		// 새로고침을 할 경우에 반복적으로 requestMapping 작업이 수행되는 부분을 방지하기 위한 코드
		if(checkVO == null) {
			pvo = insertProjectService.insertProject(pvo);
			creatorProfileImageUploader(creatorUploadImage, cvo);
			creatorBusinessfileUploader(businessUploadFile, cvo);
			insertCreatorService.insertCreator(cvo);
			session.setAttribute("updatingProject", pvo);
		}
		else {
			pvo = checkVO;
		}
		model.addAttribute("categoryList", getCategoryListSerivce.getCategoryList(acvo));
		model.addAttribute("writingCreator");
		model.addAttribute("writingProject", pvo);

		return "f-create-project";
	} // 프로젝트 작성 시작할때 메서드 
	
	@RequestMapping(value = "/updateCreatorAndInsertProject.udo", method = RequestMethod.POST)
	public String updateCreatorAndInsertProject(	@RequestParam(name = "creatorUploadImage", required = false)List<MultipartFile> creatorUploadImage,
													@RequestParam(name = "businessUploadFile", required = false)List<MultipartFile> businessUploadFile,
													HttpSession session, 
													ProjectVO pvo, 
													CreatorVO cvo, 
													Model model) throws Exception {
		
		System.out.println("cvo : " + cvo == null);
		
		// 프로젝트 제작 첫 시작시에만 시작
		ProjectVO checkVO = (ProjectVO)session.getAttribute("updatingProject");


		// 새로고침을 할 경우에 반복적으로 requestMapping 작업이 수행되는 부분을 방지하기 위한 코드
		if(checkVO == null) {
			pvo = insertProjectService.insertProject(pvo);
			creatorProfileImageUploader(creatorUploadImage, cvo);
			creatorBusinessfileUploader(businessUploadFile, cvo);
			updateCreatorService.updateCreator(cvo);
			session.setAttribute("updatingProject", pvo);
		}
		else {
			pvo = checkVO;
		}
		model.addAttribute("writingCreator");
		model.addAttribute("writingProject", pvo);

		return "f-create-project";
	} // 프로젝트 작성 시작할때 메서드 
	
	
	
	
	
	@RequestMapping(value = "deleteProject.udo", method = RequestMethod.GET)
	public String deleteProject(@RequestParam int currentProjectNo) {
		
		projectVO.setProjectNo(currentProjectNo);
		deleteProjectService.deleteProject(projectVO);
		
		return "redirect:mypage.udo";
	}
	
	@RequestMapping(value = "/saveInputWritingProject.udo", method = RequestMethod.POST)
	public String updateProject(	@RequestParam(name = "projectIntroduceImageNo", required = false)List<Integer> projectIntroduceImageNoList,
									@RequestParam(name = "uploadImage", required = false)List<MultipartFile> projectMainImageUpload,
									@RequestParam(name = "projectIntroduceImageUpload", required = false)List<MultipartFile> projectIntroduceImageUploadList,
									@RequestParam(name = "keywords", required = false)List<String> toAddKeywords,
//									@RequestParam(name = "creatorUploadImage", required = false)List<MultipartFile> creatorUploadImage,
//									@RequestParam(name = "businessUploadFile", required = false)List<MultipartFile> businessUploadFile,
									ProjectVO pvo,
//									CreatorVO cvo,
									RedirectAttributes redirectAttributes,
									Model model) throws Exception { // 프로젝트 임시저장 시 실행되는 메서드

	

		
		int ProjectNo = pvo.getProjectNo();
		
		projectIntroduceImageUploader(projectIntroduceImageUploadList, projectIntroduceImageVO, ProjectNo, projectIntroduceImageNoList);
		projectMainImageUploader(projectMainImageUpload, pvo);
//		creatorProfileImageUploader(creatorUploadImage, cvo);
//		creatorBusinessfileUploader(businessUploadFile, cvo);
		
		
		
		
		if(toAddKeywords != null) {
			insertKeyword(toAddKeywords, keywordVO); //DB에 새로운 키워드 추가 메서드
			deleteProjectKeyword(pvo); // 기존 프로젝트에 있던 키워드들 삭제
			insertProjectKeyword(toAddKeywords, pvo.getProjectNo());//DB에 프로젝트와 연결되는 키워드를 추가 하는 메서드
		}
		
		char checkResult = inputCompleteCheck(pvo);
		pvo.setWriteStatus(checkResult); // 입력해야하는 작성부분 체크
		updateProjectService.updateProject(pvo);
		
		if(checkResult == 'y') {
			redirectAttributes.addAttribute("msg", "작성이 완료 되었습니다.");
		}else {
			redirectAttributes.addAttribute("msg", "저장 되었습니다");
		}
		
		redirectAttributes.addAttribute("currentProjectNo", pvo.getProjectNo());
		
		return "redirect:getWritingProject.udo";
		
		
	}

	@RequestMapping(value = "requestCheckProject.udo", method = RequestMethod.POST)
	public String requestCheckProject(	ProjectVO pvo, AlarmVO avo, 
										RedirectAttributes redirectAttributes) {
		
		pvo = getProjectService.getProject(pvo);
		pvo.setStatus('w');
		System.out.println("수정전의 프로젝트 상태 : " + pvo.toString());
		updateProjectService.updateProject(pvo);
		System.out.println("수정후의 프로젝트 상태 : " + pvo.toString());
		
		//////////////////////////////////////////////////////////////

		avo.setAlarmType(pvo.getProjectTitle() + " 심사요청");
		avo.setReceiveId("admin@funthing.com");
		avo.setReadConfirm('n');
		avo.setProjectNo(pvo.getProjectNo());
		avo.setDetailAlarmType("요청");
		System.out.println(avo.toString());
		insertProjectJudgeRequestAlarmService.insertProjectJudgeRequestAlarm(avo);
		
		redirectAttributes.addAttribute("msg", "심사요청을 완료하였습니다.");
		redirectAttributes.addAttribute("currentProjectNo", pvo.getProjectNo());
		return "redirect:getWritingProject.udo";
	}
	
	@RequestMapping(value="projectDetailsFromProjectBoard.udo", method = RequestMethod.GET)
	public String showProjectDetails(	@RequestParam int currentProjectNo,
										ProjectVO pvo, Model model) { // 이미지클릭시 프로젝트 상세 페이지로 이동
		
		System.out.println("currentProjectNo : " + currentProjectNo);
		pvo.setProjectNo(currentProjectNo);
		getProjectDetails(pvo, model);
		
		return "p-project-details"; //프로젝트 상세페이지
	}
	
	@RequestMapping(value="projectDetails.udo", method = RequestMethod.GET)
	public String showProjectDetails(ProjectVO pvo, Model model) { // 이미지클릭시 프로젝트 상세 페이지로 이동

		getProjectDetails(pvo, model);
		return "p-project-details"; //프로젝트 상세페이지
	}
	
	
	
	@RequestMapping(value = "/showPreviewProject.udo", method = RequestMethod.POST)
	public String showPreviewProject(ProjectVO pvo, Model model) throws Exception { // 프로젝트 임시저장 시 실행되는 메서드
		pvo = getProjectService.getProject(pvo);
		int projectNo = pvo.getProjectNo();
		
		projectKeywordVO.setProjectNo(projectNo);
		List<ProjectKeywordVO> projectKeywordList = getProjectKeywordListService.getProjectKeywordList(projectKeywordVO);
		
		projectIntroduceImageVO.setProjectNo(projectNo);
		List<ProjectIntroduceImageVO>projectIntroduceImageList = getProjectIntroduceImageListService.getProjectIntroduceImageList(projectIntroduceImageVO);
		
		rewardVO.setProjectNo(projectNo);
		List<RewardVO> rewardList = getRewardListService.getRewardList(rewardVO);
		
		model.addAttribute("rewardList", rewardList);
		model.addAttribute("projectIntroduceImageList", projectIntroduceImageList);
		model.addAttribute("previewProjectKeywordList", projectKeywordList);
		model.addAttribute("previewProject", pvo);
		
		return "p-project-details-preview";

	}
	
	public void insertKeyword(List<String> toAddKeywords, KeywordVO kvo) {

		List<KeywordVO> existKeywords = getKeywordListService.getKeywordList();
		
		for(String toAddKeyword : toAddKeywords) {
	
			boolean isExist = false;
			for(KeywordVO existKeyword : existKeywords) {
				if(toAddKeyword.equals(existKeyword.getKeyword())) {
					isExist = true;
					break;
				}
			}
	
			//입력한 키워드 중에 DB에 존재하는 키워드가 아니라면 키워드 추가
			if(!isExist) {
				kvo.setKeyword(toAddKeyword);
				insertKeywordService.insertKeyword(kvo);
			}
	
		}
		
	}
	
	public void insertProjectKeyword(List<String> toAddKeywords, int currentProjectNo) {
		
		projectKeywordVO.setProjectNo(currentProjectNo);
		
		for(String toAddKeyword :toAddKeywords) {
			projectKeywordVO.setKeyword(toAddKeyword);
			insertProjectKeywordService.insertProjectKeywordService(projectKeywordVO);
		}
	}
	public List<ProjectKeywordVO> getProjectKeywordList(ProjectVO pvo){

		projectKeywordVO.setProjectNo(pvo.getProjectNo());
		
		List<ProjectKeywordVO> projectKeywordList = getProjectKeywordListService.getProjectKeywordList(projectKeywordVO);
		
		for(int i = 0; i < projectKeywordList.size(); i++) {
			String keyword = projectKeywordList.get(i).getKeyword().replace("#", "").trim();
			projectKeywordList.get(i).setKeyword(keyword);
			
		}
		
		return projectKeywordList;
		
	}
	public int deleteProjectKeyword(ProjectVO pvo) {
		
		projectKeywordVO.setProjectNo(pvo.getProjectNo());
		int deleteCount = deleteProjectKeywordService.deleteProjectKeyword(projectKeywordVO);
		
		return deleteCount;
	}
	
	//=================== 업로드 메서드 =================================

	public void projectIntroduceImageUploader(List<MultipartFile> toDoUploadList, ProjectIntroduceImageVO vo, int ProjectNo, List<Integer> toRemoveImageNoList) throws Exception {
		
		List<String> toRemoveFilePath = new ArrayList<String>();
		vo.setProjectNo(ProjectNo);
		String voName = vo.getClass().getSimpleName();
		List<ProjectIntroduceImageVO> projectIntroduceImageList = getProjectIntroduceImageListService.getProjectIntroduceImageList(vo);
		
		if(projectIntroduceImageList != null && toRemoveImageNoList != null) {
			for(ProjectIntroduceImageVO projectIntroduceImage : projectIntroduceImageList) {
				for(int toRemoveImageNo : toRemoveImageNoList) {
					if (projectIntroduceImage.getProjectIntroduceImageNo() == toRemoveImageNo) {
						toRemoveFilePath.add(projectIntroduceImage.getProjectIntroduceImage());
					}
				}
			}
		}
		
		deleteProjectIntroduceImageService.deleteProjectIntroduceImage(vo, toRemoveImageNoList);

		if(toRemoveFilePath.isEmpty()) {
			toRemoveFilePath.add(0, null);
		}
		
		if(!toDoUploadList.isEmpty()){ //프로젝트 소개 이미지 기존업로드 제거 및 새 업로드, DB 추가 작업 메서드
			
			List<String> tmpUploadList = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
			insertProjectIntroduceImageService.insertProjectIntroduceImage(projectIntroduceImageVO, tmpUploadList);
			

		}else {
			uploadUtil.removeUtil(voName, toRemoveFilePath);
		
		}
		
		
		
	}	
	
	public void projectMainImageUploader(List<MultipartFile> toDoUploadList, ProjectVO vo) throws Exception {
		
		List<String> toRemoveFilePath = new ArrayList<String>();
				
		if(!toDoUploadList.get(0).isEmpty()) { // 업로드 시킨 파일이 이미 존재하는 경우 파일 선택을 다시 안한 경우에 나올 수 있는 상황 처리  
			toRemoveFilePath.add(vo.getProjectMainImage()); //제거될 파일경로를 vo객체에서 가져오기
			String voName = vo.getClass().getSimpleName();
			List<String> toSettingPath = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
			if(toSettingPath == null) return;

			for(String toInsertImage : toSettingPath) {
				vo.setProjectMainImage(toInsertImage);
			}
		}
	}
	public void creatorProfileImageUploader(List<MultipartFile> toDoUploadList, CreatorVO cvo) throws Exception{
		
		List<String> toRemoveFilePath = new ArrayList<String>();

		
		if(!toDoUploadList.get(0).isEmpty()) { // 업로드 시킨 파일이 이미 존재하는 경우 파일 선택을 다시 안한 경우에 나올 수 있는 상황 처리  
			toRemoveFilePath.add(cvo.getCreatorProfileImage()); //제거될 파일경로를 vo객체에서 가져오기
			String voName = cvo.getClass().getSimpleName();
			List<String> toSettingPath = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
			if(toSettingPath == null) return;

			for(String toInsertImage : toSettingPath) {
				cvo.setCreatorProfileImage(toInsertImage);
			}
		}
		
	}
	public void creatorBusinessfileUploader(List<MultipartFile> toDoUploadList, CreatorVO cvo) throws Exception{
		
		List<String> toRemoveFilePath = new ArrayList<String>();

		if(!toDoUploadList.get(0).isEmpty()) { // 업로드 시킨 파일이 이미 존재하는 경우 파일 선택을 다시 안한 경우에 나올 수 있는 상황 처리  
			toRemoveFilePath.add(cvo.getBusinessFileLink()); //제거될 파일경로를 vo객체에서 가져오기
			String voName = "creatorBusinessFiles";
			List<String> toSettingPath = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
			if(toSettingPath == null) return;

			for(String toInsertImage : toSettingPath) {
				cvo.setBusinessFileLink(toInsertImage);
			}
		}
	}
	
	// 구현 OK - 수정 요구됨
	public char inputCompleteCheck(ProjectVO vo) { //임시 저장된 프로젝트 빈칸 체크
		
		System.out.println(vo.toString());
		
		if(		vo.getProjectNo() == -1 ||
				vo.getCreator() == null || vo.getCreator().equals("") ||
				vo.getEmail() == null || vo.getEmail().equals("") ||
				
				vo.getGoalMoney() == 0 ||
				vo.getProjectMainImage() == null || vo.getProjectMainImage().equals("") ||
				vo.getProjectTitle() == null || vo.getProjectTitle().equals("") ||
				vo.getProjectSubTitle() == null || vo.getProjectSubTitle().equals("") ||
				vo.getCategory() == null || vo.getCategory().equals("") ||
//				vo.getStartDate() == null ||
				vo.getEndDate() == null ||

				vo.getProjectSummary() == null || vo.getProjectSummary().equals("") ||
//				vo.getProjectCaution() == null || vo.getProjectCaution().equals("") ||
				vo.getProjectIntroduceVideo() == null || vo.getProjectIntroduceVideo().equals("") || 
				vo.getProjectStory() == null || vo.getProjectStory().equals("")
//				vo.getInformationAgree() == 'n'
				//리워드 체크 추가 해야한다.
				
		){
			
			return 'n';

		}
		
		
		return 'y';
	}
	
	
	
	public void getProjectDetails(ProjectVO pvo, Model model) {
		
		pvo = getProjectService.getProject(pvo);
		int projectNo = pvo.getProjectNo();
		
		projectBoardVO.setProjectNo(projectNo);
		List<ProjectBoardVO> getProjectBoardList = getEntireProjectBoardListService.getEntireProjectBoardList(projectBoardVO);

		projectKeywordVO.setProjectNo(projectNo);
		List<ProjectKeywordVO> projectKeywordList = getProjectKeywordListService.getProjectKeywordList(projectKeywordVO);
		
		projectIntroduceImageVO.setProjectNo(projectNo);
		List<ProjectIntroduceImageVO>projectIntroduceImageList = getProjectIntroduceImageListService.getProjectIntroduceImageList(projectIntroduceImageVO);
		
		rewardVO.setProjectNo(projectNo);
		List<RewardVO> rewardList = getRewardListService.getRewardList(rewardVO);
		
		
		model.addAttribute("rewardList", rewardList);
		model.addAttribute("getProjectBoardList", getProjectBoardList); //전체목록리스트 이름이랑 같이 조인해서 가져오기
		model.addAttribute("projectIntroduceImageList", projectIntroduceImageList);
		model.addAttribute("projectKeywordList", projectKeywordList);
		model.addAttribute("project", pvo);
		
		
	}
	
	
	

	
}













