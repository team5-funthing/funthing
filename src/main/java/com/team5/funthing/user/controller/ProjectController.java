package com.team5.funthing.user.controller;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import com.team5.funthing.common.utils.uploadUtils.UploadUtil;
import com.team5.funthing.user.model.vo.KeywordVO;
import com.team5.funthing.user.model.vo.ProjectKeywordVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.model.vo.ProjectIntroduceImageVO;
import com.team5.funthing.user.service.RewardService.GetRewardListService;
import com.team5.funthing.user.service.keywordService.GetKeywordListService;
import com.team5.funthing.user.service.keywordService.InsertKeywordService;
import com.team5.funthing.user.service.projectIntroduceImageService.GetProjectIntroduceImageListService;
import com.team5.funthing.user.service.projectIntroduceImageService.InsertProjectIntroduceImageService;
import com.team5.funthing.user.service.projectKeywordService.DeleteProjectKeywordService;
import com.team5.funthing.user.service.projectKeywordService.GetProjectKeywordListService;
import com.team5.funthing.user.service.projectKeywordService.InsertProjectKeywordService;
import com.team5.funthing.user.service.projectService.CreateProjectService;
import com.team5.funthing.user.service.projectService.DeleteProjectService;
import com.team5.funthing.user.service.projectService.GetProjectListByEmailService;
import com.team5.funthing.user.service.projectService.GetProjectService;
import com.team5.funthing.user.service.projectService.InsertProjectService;
import com.team5.funthing.user.service.projectService.UpdateProjectService;


/**
 * 
 * @author qpara
 *
 */

@Controller
@SessionAttributes("project")
public class ProjectController {

// ===================== 주요 필수 서비스 주입 ==============
	
	@Autowired
	private CreateProjectService createProjectService;
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

	
// ===================== 부 서비스 주입 ================	

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
	private GetRewardListService getRewardListService;
	
	
// ===================== VO 주입 =====================
	
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
	
	
// ===================== 유틸 주입 =====================

	@Autowired
	private UploadUtil uploadUtil;
	
	
	
// ===================== initBinder ==================
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            
			@Override
            public void setAsText(String text) throws IllegalArgumentException {
                // "text" 파라미터는 클라이언트가 보낸 데이터이다.
                // 이렇게 문자열로 보낸 데이터는 java.sql.Date 객체로 바꿔야 한다.
                this.setValue(Date.valueOf(text));
            }
        });
	}
	
	
	
	
// ===================== 메서드 =======================	
	
	@RequestMapping(value="/showStartProjectPage.udo", method = RequestMethod.GET)
	public String startProject(HttpSession session, Model model) {
		String loginEmail = (String)session.getAttribute("memberSessionEmail");
		if(loginEmail == null) {
			model.addAttribute("msg", "로그인 후 이용 가능합니다.");
			return "p-index";
		}
		model.addAttribute("loginEmail", loginEmail); 
		return "p-start-project"; // 시작하기 페이지로 이동하자
	} // 로그인 시에만 프로젝트 만들기 접근 가능하도록 하기위해 세션에 저장된 값 확인 후 페이지 이동.
	
	

	@RequestMapping(value="/getWritingProject.udo", method = RequestMethod.GET)
	public String getProject(@RequestParam int currentProjectNo, @RequestParam String msg, Model model) {
		
		projectVO.setProjectNo(currentProjectNo);
		projectIntroduceImageVO.setProjectNo(currentProjectNo);
		
		projectVO = getProjectService.getProject(projectVO);
		System.out.println("redirect: pvo : " + projectVO.toString());
		List<ProjectIntroduceImageVO> projectIntroduceImageList = getProjectIntroduceImageListService.getProjectIntroduceImageList(projectIntroduceImageVO);
		List<ProjectKeywordVO> projectKeywordList = getProjectKeywordList(projectVO);
		
		if(projectIntroduceImageList != null) {
			model.addAttribute("projectIntroduceImageList", projectIntroduceImageList);
		}
		if(projectKeywordList != null) {
			model.addAttribute("addedKeywordList", projectKeywordList);
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("writingProject", projectVO);
		
		return "f-create-project";
	}
	
	
	
	@RequestMapping(value="/showCreateProjectBasicForm.udo", method = RequestMethod.GET)
	public String showCreateProjectBasicForm(HttpSession session, ProjectVO vo, Model model) {

		session.removeAttribute("updatingProject");
		String loginEmail = (String)session.getAttribute("memberSessionEmail");
		vo.setEmail(loginEmail);
		
		List<ProjectVO> getProjectList = getProjectListByEmailService.getProjectListByEmail(vo);
		if(getProjectList != null) {
			System.out.println("========getProjectList=============");
			for(ProjectVO getProject : getProjectList) {
				System.out.println(getProject.toString());
			}
			System.out.println("===================================");
			model.addAttribute("getProjectList", getProjectList);
		}
		model.addAttribute("basicProjectSetting", vo);
		
		return "f-create-project-basic"; // 프로젝트 작성 폼
	} // 프로젝트 만들기 시작 페이지에서 수행
	
	
  
	
	
	
	//리워드 등록시에 목록을 추가하는 메서드 입력()
	@RequestMapping(value = "/insertProject.udo", method = RequestMethod.POST)
	public String insertProject(HttpSession session, ProjectVO vo, Model model) {

		// 프로젝트 제작 첫 시작시에만 시작
		ProjectVO checkVO = (ProjectVO)session.getAttribute("updatingProject");


		// 새로고침을 할 경우에 반복적으로 requestMapping 작업이 수행되는 부분을 방지하기 위한 코드
		if(checkVO == null) {
			vo = insertProjectService.insertProject(vo);
			session.setAttribute("updatingProject", vo);
		}
		else {
			vo = checkVO;
		}
		model.addAttribute("writingProject", vo);
		model.addAttribute("projectNo", vo.getProjectNo());

		return "f-create-project";
	} // 프로젝트 작성 시작할때 메서드 

	
	
	@RequestMapping(value = "/saveInputWritingProject.udo", method = RequestMethod.POST)
	public String updateProject(	@RequestParam(name = "uploadImage", required = false)List<MultipartFile> projectMainImageUpload,
									@RequestParam(name = "projectIntroduceImageUpload", required = false)List<MultipartFile> projectIntroduceImageUploadList,
									@RequestParam(name = "keywords", required = false)List<String> toAddKeywords,
									ProjectVO pvo,
									RedirectAttributes redirectAttributes,
									Model model) throws Exception { // 프로젝트 임시저장 시 실행되는 메서드

		
		int ProjectNo = pvo.getProjectNo();
		
		System.out.println("-------------임시저장 실행----------------");
		System.out.println(pvo.toString());
		System.out.println("--------------------------------------");
		
		
		projectIntroduceImageUploader(projectIntroduceImageUploadList, projectIntroduceImageVO, ProjectNo);
		projectMainImageUploader(projectMainImageUpload, pvo);

		
		if(toAddKeywords != null) {
			insertKeyword(toAddKeywords, keywordVO); //DB에 새로운 키워드 추가 메서드
			deleteProjectKeyword(pvo); // 기존 프로젝트에 있던 키워드들 삭제
			insertProjectKeyword(toAddKeywords, pvo.getProjectNo());//DB에 프로젝트와 연결되는 키워드를 추가 하는 메서드
		}
		pvo.setWriteStatus(writingInputCheck(pvo)); // 입력해야하는 작성부분 체크
		updateProjectService.updateProject(pvo);
		

		
		redirectAttributes.addAttribute("currentProjectNo", pvo.getProjectNo());
		redirectAttributes.addAttribute("msg", "저장 되었습니다");
		
		return "redirect:getWritingProject.udo";
		
		
	}


	
	@RequestMapping(value = "/showPreviewProject.udo", method = RequestMethod.POST)
	public String showPreviewProject(ProjectVO pvo, Model model) throws Exception { // 프로젝트 임시저장 시 실행되는 메서드
		System.out.println("뭐가 문제죠?");
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
		
		return "p-project-details2";

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
		
		if(projectKeywordVO == null) {
			System.out.println("projectKeywordVO Null");
			return null;
		}
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
	
	//=================== 기타 메서드 =================================

	
	
	
	public void projectIntroduceImageUploader(List<MultipartFile> toDoUploadList, ProjectIntroduceImageVO vo, int ProjectNo) throws Exception {
			
		List<String>toRemoveFilePath = new ArrayList<String>();
		
		if(!toDoUploadList.isEmpty()){ //프로젝트 소개 이미지 기존업로드 제거 및 새 업로드, DB 추가 작업 메서드
			vo.setProjectNo(ProjectNo);
			String voName = vo.getClass().getSimpleName();
			
			List<ProjectIntroduceImageVO> projectIntroduceImageList = getProjectIntroduceImageListService.getProjectIntroduceImageList(vo);
			
			for(ProjectIntroduceImageVO projectIntroduceImage : projectIntroduceImageList) {
				toRemoveFilePath.add(projectIntroduceImage.getProjectIntroduceImage());
			}
			
			List<String> tmpUploadList = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
			
			
			if(tmpUploadList != null) {
				for(String toInsertImage : tmpUploadList) {
					System.out.println("toInsertImage : " + toInsertImage);
					projectIntroduceImageVO.setProjectIntroduceImage(toInsertImage);
					
					
					insertProjectIntroduceImageService.insertProjectIntroduceImage(projectIntroduceImageVO);
				} // 소개 이미지 경로 DB에 추가
			}else {
				return;
			}
		}
		
	}	
	public void projectMainImageUploader(List<MultipartFile> toDoUploadList, ProjectVO vo) throws Exception {
		
		List<String> toRemoveFilePath = new ArrayList<String>();

				
		if(!toDoUploadList.isEmpty()) { // 업로드 시킨 파일이 이미 존재하는 경우 파일 선택을 다시 안한 경우에 나올 수 있는 상황 처리  
			toRemoveFilePath.add(vo.getProjectMainImage()); //제거될 파일경로를 vo객체에서 가져오기
			String voName = vo.getClass().getSimpleName();
			List<String> toSettingPath = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
			if(toSettingPath == null) return;
			
			int cnt = 1;
			for(String toInsertImage : toSettingPath) {
				System.out.println("cnt : " + cnt++);
				vo.setProjectMainImage(toInsertImage);
			}
		}
	}
	
	
	
	public char writingInputCheck(ProjectVO vo) {

		boolean result = nullCheck(vo);

		if(result) {
			return 'y';
		}
		return 'n';
	}
	public boolean nullCheck(ProjectVO project) { //임시 저장된 프로젝트 빈칸 체크
		// 추후에 이미지, 홍보 영상, 동의  등 체크 변수에 추가해야한다. 
		if(
				project.getGoalMoney() == 0 ||
				project.getProjectTitle() == null || project.getProjectTitle() == "" || 
				project.getProjectSubTitle() == null || project.getProjectSubTitle() == "" ||
//				project.getProjectStory() == null || project.getProjectStory() == "" ||
				project.getProjectSummary() == null || project.getProjectSummary() == "" 
				) 
		{
			return false;

		}
		else {
			return true;

		}
	}
	
	
}













