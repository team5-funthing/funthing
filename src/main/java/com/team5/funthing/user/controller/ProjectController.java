package com.team5.funthing.user.controller;

import java.net.URL;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.team5.funthing.common.utils.uploadUtils.UploadUtil;
import com.team5.funthing.user.model.vo.KeywordVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectKeywordVO;
import com.team5.funthing.user.model.vo.ProjectStoryVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.keywordService.GetKeywordListService;
import com.team5.funthing.user.service.keywordService.InsertKeywordService;
import com.team5.funthing.user.service.projectKeywordService.DeleteProjectKeywordService;
import com.team5.funthing.user.service.projectKeywordService.GetProjectKeywordListService;
import com.team5.funthing.user.service.projectKeywordService.InsertProjectKeywordService;
import com.team5.funthing.user.service.projectService.CreateProjectService;
import com.team5.funthing.user.service.projectService.DeleteProjectService;
import com.team5.funthing.user.service.projectService.GetProjectService;
import com.team5.funthing.user.service.projectService.InsertProjectService;
import com.team5.funthing.user.service.projectService.UpdateProjectService;
import com.team5.funthing.user.service.projectStoryService.DeleteProjectStoryService;
import com.team5.funthing.user.service.projectStoryService.GetProjectStoryService;
import com.team5.funthing.user.service.projectStoryService.InsertProjectStoryService;
import com.team5.funthing.user.service.projectStoryService.UpdateProjectStoryService;


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
	
	// ProjectStory Service
	@Autowired
	private InsertProjectStoryService insertProjectStoryService;
	@Autowired
	private DeleteProjectStoryService deleteProjectStoryService;
	@Autowired
	private UpdateProjectStoryService updateProjectStoryService;
	@Autowired
	private GetProjectStoryService getProjectStoryService;
	
	
// ===================== VO 주입 =====================
	
	@Autowired
	private ProjectKeywordVO projectKeywordVO;
	@Autowired
	private KeywordVO keywordVO;
	@Autowired
	private ProjectStoryVO projectStory;
	
	
	
	
// ===================== 유틸 주입 =====================

	@Autowired
	private UploadUtil projectMainImageUploadUtils;

	
	
// ===================== 메서드 =======================	
	
	@RequestMapping(value="/showStartProjectPage.udo", method = RequestMethod.GET)
	public String showStartProjectPage(HttpSession session, Model model) {

		// 테스트 용 코드
		MemberVO test = new MemberVO();
		test.setEmail("test@naver.com");
		session.setAttribute("email", test.getEmail());

		String loginId = (String)session.getAttribute("email");


		if(loginId == null) {
			model.addAttribute("msg", "로그인 후 이용 가능합니다.");
			return "p-index";
		}

		model.addAttribute("member", test); 
		return "p-start-project"; // 시작하기 페이지로 이동하자
	} // 로그인 시에만 프로젝트 만들기 접근 가능하도록 하기위해 세션에 저장된 값 확인 후 페이지 이동.

	
	
	@RequestMapping(value="/showCreateProjectBasicForm.udo", method = RequestMethod.GET)
	public String showCreateProjectBasicForm(HttpSession session, ProjectVO vo, Model model) {

		session.removeAttribute("insertedProject");
		model.addAttribute("basicProjectSetting", vo);

		return "f-create-project-basic"; // 프로젝트 작성 폼
	} // 프로젝트 만들기 시작 페이지에서 수행
  
	//리워드 등록시에 목록을 추가하는 메서드 입력()
	@RequestMapping(value = "/insertProject.udo", method = RequestMethod.POST)
	public String insertProject(HttpSession session, ProjectVO vo, Model model) {

		// 프로젝트 제작 첫 시작시에만 시작
		ProjectVO checkVO = (ProjectVO)session.getAttribute("insertedProject");


		// 새로고침을 할 경우에 반복적으로 requestMapping 작업이 수행되는 부분을 방지하기 위한 코드
		if(checkVO == null) {
			vo = insertProjectService.insertProject(vo);
			session.setAttribute("insertedProject", vo);
		}
		else {
			System.out.println("새로고침 확인 : " + checkVO.getProjectNo());
			vo = checkVO;
		}

		System.out.println("insertProject 또는 새로고침 실행 후 =======> " + vo.toString());
		model.addAttribute("writingProject", vo);
		model.addAttribute("projectNo", vo.getProjectNo());

		return "f-create-project";
	} // 프로젝트 작성 시작할때 메서드 


	
//	redirectAttributes.addAttribute("","")
	@RequestMapping(value = "/saveInputWritingProject.udo", method = RequestMethod.POST)
	public String saveInputWritingProject(	@RequestParam(name = "uploadImage", required = false)MultipartFile uploadFile,
											@RequestParam(name = "projectStoryImageUpload", required = false)MultipartFile projectStoryImageUpload,
											@RequestParam(name = "keywords", required = false)List<String> toAddKeywords, 
											@RequestParam(name = "projectVideo", required = false)String projectStoryVideoPath,
//											RedirectAttributes redirectAttributes,
											ProjectStoryVO psvo,
											ProjectVO pvo,
											Model model) throws Exception { // 프로젝트 임시저장 시 실행되는 메서드
		

		if(!uploadFile.isEmpty()) { // 업로드 시킨 파일이 이미 존재하는 경우 파일 선택을 다시 안한 경우에 나올 수 있는 상황 처리  
			String toRemoveFilePath = pvo.getProjectMainImage(); //제거될 파일경로를 vo객체에서 가져오기
			String voName = pvo.getClass().getSimpleName();
			String toSettingPath = projectMainImageUploadUtils.upload(uploadFile, voName, toRemoveFilePath);
			pvo.setProjectMainImage(toSettingPath);
		}
		
		if(toAddKeywords != null) {
			insertKeyword(toAddKeywords, keywordVO); //DB에 새로운 키워드 추가 메서드
			deleteProjectKeyword(pvo);
			insertProjectKeyword(toAddKeywords, pvo.getProjectNo());//DB에 프로젝트와 연결되는 키워드를 추가 하는 메서드
		}
		
		
		pvo.setWriteStatus(writingInputCheck(pvo));
		updateProjectService.updateProject(pvo);

		
		List<ProjectKeywordVO> projectKeywordList = getProjectKeywordList(pvo);

		model.addAttribute("writingProject", pvo);
		model.addAttribute("addedKeywordList", projectKeywordList);
		model.addAttribute("msg", "저장 되었습니다");
		
		
		return "f-create-project";
		
	}
	
	
	@RequestMapping(value = "/showPreviewProject.udo", method = RequestMethod.POST)
	public String showPreviewProject(ProjectVO pvo, Model model) throws Exception { // 프로젝트 임시저장 시 실행되는 메서드
		
		projectKeywordVO.setProjectNo(pvo.getProjectNo());
		List<ProjectKeywordVO> projectKeywordList = getProjectKeywordListService.getProjectKeywordList(projectKeywordVO);
		
		model.addAttribute("previewProjectKeywordList", projectKeywordList);
		model.addAttribute("previewProject", pvo);
		return "p-project-details";

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
			System.out.println(i + "번째 keyword : " + keyword);
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













