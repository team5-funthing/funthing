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
	
	@Autowired 
	private GetProjectListByEmailService getProjectListByEmailService;

	
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
	
	
	// ProjectIntroduceImage Service
	@Autowired
	private InsertProjectIntroduceImageService insertProjectIntroduceImageService;
	@Autowired
	private GetProjectIntroduceImageListService getProjectIntroduceImageListService;
	@Autowired
	private GetRewardListService getRewardListService;
	
	
// ===================== VO ���� =====================
	
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
	
	
// ===================== ��ƿ ���� =====================

	@Autowired
	private UploadUtil uploadUtil;
	
	
	
// ===================== initBinder ==================
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            
			@Override
            public void setAsText(String text) throws IllegalArgumentException {
                // "text" �Ķ���ʹ� Ŭ���̾�Ʈ�� ���� �������̴�.
                // �̷��� ���ڿ��� ���� �����ʹ� java.sql.Date ��ü�� �ٲ�� �Ѵ�.
                this.setValue(Date.valueOf(text));
            }
        });
	}
	
	
	
	
// ===================== �޼��� =======================	
	
	@RequestMapping(value="/showStartProjectPage.udo", method = RequestMethod.GET)
	public String startProject(HttpSession session, Model model) {
		String loginEmail = (String)session.getAttribute("memberSessionEmail");
		if(loginEmail == null) {
			model.addAttribute("msg", "�α��� �� �̿� �����մϴ�.");
			return "p-index";
		}
		model.addAttribute("loginEmail", loginEmail); 
		return "p-start-project"; // �����ϱ� �������� �̵�����
	} // �α��� �ÿ��� ������Ʈ ����� ���� �����ϵ��� �ϱ����� ���ǿ� ����� �� Ȯ�� �� ������ �̵�.
	
	

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
		
		return "f-create-project-basic"; // ������Ʈ �ۼ� ��
	} // ������Ʈ ����� ���� ���������� ����
	
	
  
	
	
	
	//������ ��Ͻÿ� ����� �߰��ϴ� �޼��� �Է�()
	@RequestMapping(value = "/insertProject.udo", method = RequestMethod.POST)
	public String insertProject(HttpSession session, ProjectVO vo, Model model) {

		// ������Ʈ ���� ù ���۽ÿ��� ����
		ProjectVO checkVO = (ProjectVO)session.getAttribute("updatingProject");


		// ���ΰ�ħ�� �� ��쿡 �ݺ������� requestMapping �۾��� ����Ǵ� �κ��� �����ϱ� ���� �ڵ�
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
	} // ������Ʈ �ۼ� �����Ҷ� �޼��� 

	
	
	@RequestMapping(value = "/saveInputWritingProject.udo", method = RequestMethod.POST)
	public String updateProject(	@RequestParam(name = "uploadImage", required = false)List<MultipartFile> projectMainImageUpload,
									@RequestParam(name = "projectIntroduceImageUpload", required = false)List<MultipartFile> projectIntroduceImageUploadList,
									@RequestParam(name = "keywords", required = false)List<String> toAddKeywords,
									ProjectVO pvo,
									RedirectAttributes redirectAttributes,
									Model model) throws Exception { // ������Ʈ �ӽ����� �� ����Ǵ� �޼���

		
		int ProjectNo = pvo.getProjectNo();
		
		System.out.println("-------------�ӽ����� ����----------------");
		System.out.println(pvo.toString());
		System.out.println("--------------------------------------");
		
		
		projectIntroduceImageUploader(projectIntroduceImageUploadList, projectIntroduceImageVO, ProjectNo);
		projectMainImageUploader(projectMainImageUpload, pvo);

		
		if(toAddKeywords != null) {
			insertKeyword(toAddKeywords, keywordVO); //DB�� ���ο� Ű���� �߰� �޼���
			deleteProjectKeyword(pvo); // ���� ������Ʈ�� �ִ� Ű����� ����
			insertProjectKeyword(toAddKeywords, pvo.getProjectNo());//DB�� ������Ʈ�� ����Ǵ� Ű���带 �߰� �ϴ� �޼���
		}
		pvo.setWriteStatus(writingInputCheck(pvo)); // �Է��ؾ��ϴ� �ۼ��κ� üũ
		updateProjectService.updateProject(pvo);
		

		
		redirectAttributes.addAttribute("currentProjectNo", pvo.getProjectNo());
		redirectAttributes.addAttribute("msg", "���� �Ǿ����ϴ�");
		
		return "redirect:getWritingProject.udo";
		
		
	}


	
	@RequestMapping(value = "/showPreviewProject.udo", method = RequestMethod.POST)
	public String showPreviewProject(ProjectVO pvo, Model model) throws Exception { // ������Ʈ �ӽ����� �� ����Ǵ� �޼���
		System.out.println("���� ������?");
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
	
	//=================== ��Ÿ �޼��� =================================

	
	
	
	public void projectIntroduceImageUploader(List<MultipartFile> toDoUploadList, ProjectIntroduceImageVO vo, int ProjectNo) throws Exception {
			
		List<String>toRemoveFilePath = new ArrayList<String>();
		
		if(!toDoUploadList.isEmpty()){ //������Ʈ �Ұ� �̹��� �������ε� ���� �� �� ���ε�, DB �߰� �۾� �޼���
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
				} // �Ұ� �̹��� ��� DB�� �߰�
			}else {
				return;
			}
		}
		
	}	
	public void projectMainImageUploader(List<MultipartFile> toDoUploadList, ProjectVO vo) throws Exception {
		
		List<String> toRemoveFilePath = new ArrayList<String>();

				
		if(!toDoUploadList.isEmpty()) { // ���ε� ��Ų ������ �̹� �����ϴ� ��� ���� ������ �ٽ� ���� ��쿡 ���� �� �ִ� ��Ȳ ó��  
			toRemoveFilePath.add(vo.getProjectMainImage()); //���ŵ� ���ϰ�θ� vo��ü���� ��������
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













