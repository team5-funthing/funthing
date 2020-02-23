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

// ===================== �ֿ� �ʼ� ���� ���� ==============
	
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

	
// ===================== �� ���� ���� ================	

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
	
	
// ===================== VO ���� =====================
	
	@Autowired
	private ProjectKeywordVO projectKeywordVO;
	@Autowired
	private KeywordVO keywordVO;
	@Autowired
	private ProjectStoryVO projectStory;
	
	
	
	
// ===================== ��ƿ ���� =====================

	@Autowired
	private UploadUtil projectMainImageUploadUtils;

	
	
// ===================== �޼��� =======================	
	
	@RequestMapping(value="/showStartProjectPage.udo", method = RequestMethod.GET)
	public String showStartProjectPage(HttpSession session, Model model) {

		// �׽�Ʈ �� �ڵ�
		MemberVO test = new MemberVO();
		test.setEmail("test@naver.com");
		session.setAttribute("email", test.getEmail());

		String loginId = (String)session.getAttribute("email");


		if(loginId == null) {
			model.addAttribute("msg", "�α��� �� �̿� �����մϴ�.");
			return "p-index";
		}

		model.addAttribute("member", test); 
		return "p-start-project"; // �����ϱ� �������� �̵�����
	} // �α��� �ÿ��� ������Ʈ ����� ���� �����ϵ��� �ϱ����� ���ǿ� ����� �� Ȯ�� �� ������ �̵�.

	
	
	@RequestMapping(value="/showCreateProjectBasicForm.udo", method = RequestMethod.GET)
	public String showCreateProjectBasicForm(HttpSession session, ProjectVO vo, Model model) {

		session.removeAttribute("insertedProject");
		model.addAttribute("basicProjectSetting", vo);

		return "f-create-project-basic"; // ������Ʈ �ۼ� ��
	} // ������Ʈ ����� ���� ���������� ����
  
	//������ ��Ͻÿ� ����� �߰��ϴ� �޼��� �Է�()
	@RequestMapping(value = "/insertProject.udo", method = RequestMethod.POST)
	public String insertProject(HttpSession session, ProjectVO vo, Model model) {

		// ������Ʈ ���� ù ���۽ÿ��� ����
		ProjectVO checkVO = (ProjectVO)session.getAttribute("insertedProject");


		// ���ΰ�ħ�� �� ��쿡 �ݺ������� requestMapping �۾��� ����Ǵ� �κ��� �����ϱ� ���� �ڵ�
		if(checkVO == null) {
			vo = insertProjectService.insertProject(vo);
			session.setAttribute("insertedProject", vo);
		}
		else {
			System.out.println("���ΰ�ħ Ȯ�� : " + checkVO.getProjectNo());
			vo = checkVO;
		}

		System.out.println("insertProject �Ǵ� ���ΰ�ħ ���� �� =======> " + vo.toString());
		model.addAttribute("writingProject", vo);
		model.addAttribute("projectNo", vo.getProjectNo());

		return "f-create-project";
	} // ������Ʈ �ۼ� �����Ҷ� �޼��� 


	
//	redirectAttributes.addAttribute("","")
	@RequestMapping(value = "/saveInputWritingProject.udo", method = RequestMethod.POST)
	public String saveInputWritingProject(	@RequestParam(name = "uploadImage", required = false)MultipartFile uploadFile,
											@RequestParam(name = "projectStoryImageUpload", required = false)MultipartFile projectStoryImageUpload,
											@RequestParam(name = "keywords", required = false)List<String> toAddKeywords, 
											@RequestParam(name = "projectVideo", required = false)String projectStoryVideoPath,
//											RedirectAttributes redirectAttributes,
											ProjectStoryVO psvo,
											ProjectVO pvo,
											Model model) throws Exception { // ������Ʈ �ӽ����� �� ����Ǵ� �޼���
		

		if(!uploadFile.isEmpty()) { // ���ε� ��Ų ������ �̹� �����ϴ� ��� ���� ������ �ٽ� ���� ��쿡 ���� �� �ִ� ��Ȳ ó��  
			String toRemoveFilePath = pvo.getProjectMainImage(); //���ŵ� ���ϰ�θ� vo��ü���� ��������
			String voName = pvo.getClass().getSimpleName();
			String toSettingPath = projectMainImageUploadUtils.upload(uploadFile, voName, toRemoveFilePath);
			pvo.setProjectMainImage(toSettingPath);
		}
		
		if(toAddKeywords != null) {
			insertKeyword(toAddKeywords, keywordVO); //DB�� ���ο� Ű���� �߰� �޼���
			deleteProjectKeyword(pvo);
			insertProjectKeyword(toAddKeywords, pvo.getProjectNo());//DB�� ������Ʈ�� ����Ǵ� Ű���带 �߰� �ϴ� �޼���
		}
		
		
		pvo.setWriteStatus(writingInputCheck(pvo));
		updateProjectService.updateProject(pvo);

		
		List<ProjectKeywordVO> projectKeywordList = getProjectKeywordList(pvo);

		model.addAttribute("writingProject", pvo);
		model.addAttribute("addedKeywordList", projectKeywordList);
		model.addAttribute("msg", "���� �Ǿ����ϴ�");
		
		
		return "f-create-project";
		
	}
	
	
	@RequestMapping(value = "/showPreviewProject.udo", method = RequestMethod.POST)
	public String showPreviewProject(ProjectVO pvo, Model model) throws Exception { // ������Ʈ �ӽ����� �� ����Ǵ� �޼���
		
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
		
				//�Է��� Ű���� �߿� DB�� �����ϴ� Ű���尡 �ƴ϶�� Ű���� �߰�
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
			System.out.println(i + "��° keyword : " + keyword);
			projectKeywordList.get(i).setKeyword(keyword);
			
		}
		
		return projectKeywordList;
		
	}
	public int deleteProjectKeyword(ProjectVO pvo) {
		
		projectKeywordVO.setProjectNo(pvo.getProjectNo());
		int deleteCount = deleteProjectKeywordService.deleteProjectKeyword(projectKeywordVO);
		
		return deleteCount;
	}
	
	//=================== ��Ÿ �޼��� =================================

	public char writingInputCheck(ProjectVO vo) {

		boolean result = nullCheck(vo);

		if(result) {
			return 'y';
		}

		return 'n';
	}
	public boolean nullCheck(ProjectVO project) { //�ӽ� ����� ������Ʈ ��ĭ üũ
		// ���Ŀ� �̹���, ȫ�� ����, ����  �� üũ ������ �߰��ؾ��Ѵ�. 
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













