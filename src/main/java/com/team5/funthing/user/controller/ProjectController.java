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
import com.team5.funthing.user.model.vo.MemberActivityVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.model.vo.ProjectIntroduceImageVO;
import com.team5.funthing.user.model.vo.ProjectKeywordVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.AlarmService.InsertProjectJudgeRequestAlarmService;
import com.team5.funthing.user.service.creatorService.GetCreatorListByEmailService;
import com.team5.funthing.user.service.creatorService.GetCreatorService;
import com.team5.funthing.user.service.creatorService.InsertCreatorService;
import com.team5.funthing.user.service.creatorService.UpdateCreatorService;
import com.team5.funthing.user.service.keywordService.GetKeywordListService;
import com.team5.funthing.user.service.keywordService.InsertKeywordService;
import com.team5.funthing.user.service.memberActivityService.GetProjectLikeCountService;
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

// ===================== ���� ���� ==============
   
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
   
   // MemberActivityService
   @Autowired
   private GetProjectLikeCountService getProjectLikeCountService;

   // ProjectBoard Service
   @Autowired
   private GetEntireProjectBoardListService getEntireProjectBoardListService;
   
   // Creator Service
   @Autowired
   private InsertCreatorService insertCreatorService;
   @Autowired
   private UpdateCreatorService updateCreatorService;
   @Autowired
   private GetCreatorService getCreatorService;

   // Reward Service
   @Autowired
   private GetRewardListService getRewardListService;
   
   // Alarm Service
   @Autowired
   private InsertProjectJudgeRequestAlarmService insertProjectJudgeRequestAlarmService;
   
   //category Service
   @Autowired
   private GetCategoryListService getCategoryListSerivce;
   
// ===================== VO ���� =====================
   
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
   @Autowired
   private CreatorVO creatorVO;
   
   
// ===================== �ƿ ���� =====================

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

// ===================== �޼��� =======================   
   
   @RequestMapping(value="getAllFundingProjectList.udo", method = RequestMethod.GET)
   public String getAllFundingProjectList(Model model) {
      
      List<ProjectVO> getAllFundingProjectList = getAllFundingProjectListService.getAllFundingProjectList();
      model.addAttribute("getAllFundingProjectList", getAllFundingProjectList);
      
      return "p-project-list";
   }
   
   @RequestMapping(value="/showStartProjectPage.udo", method = RequestMethod.GET)
   public String startProject(HttpSession session, Model model) {
      
      memberVO = (MemberVO)session.getAttribute("memberSession");
      if(memberVO == null) {
         model.addAttribute("msg", "�α��� �� �̿� �����մϴ�.");
         return "p-index";
      }
      model.addAttribute("loginEmail", memberVO.getEmail()); 
      return "p-start-project"; // �����ϱ� ������� �̵�����
   } // �α��� �ÿ��� ����Ʈ ����� ��� �����ϵ��� �ϱ���� ���ǿ� ����� �� Ȯ�� �� ������ �̵�.
   
   @RequestMapping(value="/getWritingProject.udo", method = RequestMethod.GET)
   public String getProject(   @RequestParam int currentProjectNo, 
                        @RequestParam(required = false)String msg, 
                        @RequestParam String creator,
                        AdminCategoryVO cvo, Model model) {
      
	   
	  System.out.println("�Ѿ�� �� : " + creator); 
	  creatorVO.setCreator(creator);
	  creatorVO = getCreatorService.getCreator(creatorVO);
	  
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
      model.addAttribute("writingCreator",creatorVO);
      
      return "f-create-project";
   }

   @RequestMapping(value="/showCreateProjectBasicForm.udo", method = RequestMethod.GET)
   public String showCreateProjectBasicForm(   HttpSession session, 
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
      
      return "f-create-project-basic"; // ����Ʈ �ۼ� ��
   } // ����Ʈ ����� ���� ������� ����
   
   //����� ��Ͻÿ� ���� �߰��ϴ� �޼��� �߰��ؾ��Ѵ�()
  
   @RequestMapping(value = "/insertCreatorAndInsertProject.udo", method = RequestMethod.POST)
   public String insertProject(   
		   					@RequestParam(name = "creatorUploadImage", required = false)List<MultipartFile> creatorUploadImage,
                           @RequestParam(name = "businessUploadFile", required = false)List<MultipartFile> businessUploadFile,
                           HttpSession session, 
                           ProjectVO pvo, 
                           CreatorVO cvo,
                           AdminCategoryVO acvo,
                           Model model) throws Exception {

      // ����Ʈ ��� ù ���۽ÿ��� ����
      ProjectVO checkVO = (ProjectVO)session.getAttribute("updatingProject");


      // ��ΰ�ħ� �� ��쿡 �ݺ������ requestMapping �۾��� ����Ǵ� �κ�� �����ϱ� ��� �ڵ�
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
      model.addAttribute("writingCreator",cvo);
      model.addAttribute("writingProject", pvo);

      return "f-create-project";
   } // ����Ʈ �ۼ� �����Ҷ� �޼��� 
   
   @RequestMapping(value = "/updateCreatorAndInsertProject.udo", method = RequestMethod.POST)
   public String updateCreatorAndInsertProject(   @RequestParam(name = "creatorUploadImage", required = false)List<MultipartFile> creatorUploadImage,
                                       @RequestParam(name = "businessUploadFile", required = false)List<MultipartFile> businessUploadFile,
                                       HttpSession session, 
                                       ProjectVO pvo, 
                                       CreatorVO cvo, 
                                       AdminCategoryVO acvo,
                                       Model model) throws Exception {
      
      System.out.println("cvo : " + cvo == null);
      
      // ����Ʈ ��� ù ���۽ÿ��� ����
      ProjectVO checkVO = (ProjectVO)session.getAttribute("updatingProject");


      // ��ΰ�ħ� �� ��쿡 �ݺ������ requestMapping �۾��� ����Ǵ� �κ�� �����ϱ� ��� �ڵ�
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
      model.addAttribute("categoryList", getCategoryListSerivce.getCategoryList(acvo));
      model.addAttribute("writingCreator",cvo);
      model.addAttribute("writingProject", pvo);

      return "f-create-project";
   } // ����Ʈ �ۼ� �����Ҷ� �޼��� 
   
   
   
   
   
   @RequestMapping(value = "deleteProject.udo", method = RequestMethod.GET)
   public String deleteProject(@RequestParam int currentProjectNo) {
      
      projectVO.setProjectNo(currentProjectNo);
      deleteProjectService.deleteProject(projectVO);
      
      return "redirect:mypage.udo";
   }
   
   @RequestMapping(value = "/saveInputWritingProject.udo", method = RequestMethod.POST)
   public String updateProject(   @RequestParam(name = "projectIntroduceImageNo", required = false)List<Integer> projectIntroduceImageNoList,
                           @RequestParam(name = "uploadImage", required = false)List<MultipartFile> projectMainImageUpload,
                           @RequestParam(name = "projectIntroduceImageUpload", required = false)List<MultipartFile> projectIntroduceImageUploadList,
                           @RequestParam(name = "keywords", required = false)List<String> toAddKeywords,
//                           @RequestParam(name = "creatorUploadImage", required = false)List<MultipartFile> creatorUploadImage,
//                           @RequestParam(name = "businessUploadFile", required = false)List<MultipartFile> businessUploadFile,
                           ProjectVO pvo,
                           CreatorVO cvo,
                           RedirectAttributes redirectAttributes,
                           Model model) throws Exception { // ����Ʈ �ӽ����� �� ����Ǵ� �޼���

   
	   System.out.println(cvo.toString());
      
      int ProjectNo = pvo.getProjectNo();
      
      projectIntroduceImageUploader(projectIntroduceImageUploadList, projectIntroduceImageVO, ProjectNo, projectIntroduceImageNoList);
      projectMainImageUploader(projectMainImageUpload, pvo);
//      creatorProfileImageUploader(creatorUploadImage, cvo);
//      creatorBusinessfileUploader(businessUploadFile, cvo);
      
      
      
      
      if(toAddKeywords != null) {
         insertKeyword(toAddKeywords, keywordVO); //DB�� ��ο� Ű��� �߰� �޼���
         deleteProjectKeyword(pvo); // ��� ����Ʈ�� �ִ� Ű���� ���
         insertProjectKeyword(toAddKeywords, pvo.getProjectNo());//DB�� ����Ʈ�� ����Ǵ� Ű��带 �߰� �ϴ� �޼���
      }
      
      char checkResult = inputCompleteCheck(pvo);
      pvo.setWriteStatus(checkResult); // �Է��ؾ��ϴ� �ۼ��κ� üũ
      updateProjectService.updateProject(pvo);
      
      if(checkResult == 'y') {
         redirectAttributes.addAttribute("msg", "�ۼ��� �Ϸ� �Ǿ��ϴ�.");
      }else {
         redirectAttributes.addAttribute("msg", "���� �Ǿ��ϴ�");
      }
      redirectAttributes.addAttribute("creator", cvo.getCreator());
      redirectAttributes.addAttribute("currentProjectNo", pvo.getProjectNo());
      
      return "redirect:getWritingProject.udo";
      
      
   }

   @RequestMapping(value = "requestCheckProject.udo", method = RequestMethod.POST)
   public String requestCheckProject(   ProjectVO pvo, AlarmVO avo, 
		   								@RequestParam String creator,
		   								RedirectAttributes redirectAttributes) {
      
      pvo = getProjectService.getProject(pvo);
      pvo.setStatus('w');
      System.out.println("������� ����Ʈ ���� : " + pvo.toString());
      updateProjectService.updateProject(pvo);
      System.out.println("������� ����Ʈ ���� : " + pvo.toString());
      
      //////////////////////////////////////////////////////////////

      avo.setAlarmType(pvo.getProjectTitle() + " �ɻ��û");
      avo.setReceiveId("admin@funthing.com");
      avo.setReadConfirm('n');
      avo.setProjectNo(pvo.getProjectNo());
      avo.setDetailAlarmType("��û");
      System.out.println(avo.toString());
      insertProjectJudgeRequestAlarmService.insertProjectJudgeRequestAlarm(avo);
      
      redirectAttributes.addAttribute("creator", creator);
      redirectAttributes.addAttribute("msg", "�ɻ��û� �Ϸ��Ͽ���ϴ�.");
      redirectAttributes.addAttribute("currentProjectNo", pvo.getProjectNo());
      return "redirect:getWritingProject.udo";
   }
   
   @RequestMapping(value="projectDetailsFromProjectBoard.udo", method = RequestMethod.GET)
   public String showProjectDetails(   @RequestParam int currentProjectNo,
                              ProjectVO pvo, MemberActivityVO mavo, Model model) { // �̹���Ŭ���� ����Ʈ �� ������� �̵�
      System.out.println("currentProjectNo : " + currentProjectNo);
      pvo.setProjectNo(currentProjectNo);
      getProjectDetails(pvo, mavo, model);
      
      return "p-project-details"; //����Ʈ ��������
   }
   
   @RequestMapping(value="projectDetails.udo", method = RequestMethod.GET)
   public String showProjectDetails(ProjectVO pvo, 
		   							MemberActivityVO mavo, 
		   							Model model,
		   							@RequestParam(value="projectNo") String projectNo
		   							) { // �̹���Ŭ���� ����Ʈ �� ������� �̵�
	   mavo.setProjectNo(Integer.parseInt(projectNo));
	   System.out.println(projectNo);
	   getProjectDetails(pvo,mavo, model);
	   
	   return "p-project-details"; //����Ʈ ��������
   }
   
   
   
   @RequestMapping(value = "/showPreviewProject.udo", method = RequestMethod.POST)
   public String showPreviewProject(ProjectVO pvo, Model model) throws Exception { // ����Ʈ �ӽ����� �� ����Ǵ� �޼���
      pvo = getProjectService.getProject(pvo);
      int projectNo = pvo.getProjectNo();
      String creator = pvo.getCreator();
      
      projectKeywordVO.setProjectNo(projectNo);
      List<ProjectKeywordVO> projectKeywordList = getProjectKeywordListService.getProjectKeywordList(projectKeywordVO);
      
      projectIntroduceImageVO.setProjectNo(projectNo);
      List<ProjectIntroduceImageVO>projectIntroduceImageList = getProjectIntroduceImageListService.getProjectIntroduceImageList(projectIntroduceImageVO);
      
      rewardVO.setProjectNo(projectNo);
      List<RewardVO> rewardList = getRewardListService.getRewardList(rewardVO);
      
      model.addAttribute("creator", creator);
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
   
         //�Է��� Ű��� �߿� DB�� ����ϴ� Ű��尡 �ƴ϶�� Ű��� �߰�
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
   
   //=================== ��ε� �޼��� =================================

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
      
      if(!toDoUploadList.isEmpty()){ //����Ʈ �Ұ� �̹��� �����ε� ��� �� �� ��ε�, DB �߰� �۾� �޼���
         
         List<String> tmpUploadList = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
         insertProjectIntroduceImageService.insertProjectIntroduceImage(projectIntroduceImageVO, tmpUploadList);
         

      }else {
         uploadUtil.removeUtil(voName, toRemoveFilePath);
      
      }
      
      
      
   }   
   
   public void projectMainImageUploader(List<MultipartFile> toDoUploadList, ProjectVO vo) throws Exception {
      
      List<String> toRemoveFilePath = new ArrayList<String>();
            
      if(!toDoUploadList.get(0).isEmpty()) { // ��ε� ��Ų ������ �̹� ����ϴ� ��� ���� ����� �ٽ� ���� ��쿡 ���� �� �ִ� ��Ȳ ó��  
         toRemoveFilePath.add(vo.getProjectMainImage()); //��ŵ� ���ϰ�θ� vo��ü���� ������
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

      
      if(!toDoUploadList.get(0).isEmpty()) { // ��ε� ��Ų ������ �̹� ����ϴ� ��� ���� ����� �ٽ� ���� ��쿡 ���� �� �ִ� ��Ȳ ó��  
         toRemoveFilePath.add(cvo.getCreatorProfileImage()); //��ŵ� ���ϰ�θ� vo��ü���� ������
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

      if(!toDoUploadList.get(0).isEmpty()) { // ��ε� ��Ų ������ �̹� ����ϴ� ��� ���� ����� �ٽ� ���� ��쿡 ���� �� �ִ� ��Ȳ ó��  
         toRemoveFilePath.add(cvo.getBusinessFileLink()); //��ŵ� ���ϰ�θ� vo��ü���� ������
         String voName = "creatorBusinessFiles";
         List<String> toSettingPath = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
         if(toSettingPath == null) return;

         for(String toInsertImage : toSettingPath) {
            cvo.setBusinessFileLink(toInsertImage);
         }
      }
   }
   
   // ���� OK - ��� �䱸��
   public char inputCompleteCheck(ProjectVO vo) { //�ӽ� ����� ����Ʈ ��ĭ üũ
      
      System.out.println(vo.toString());
      
      if(      vo.getProjectNo() == -1 ||
            vo.getCreator() == null || vo.getCreator().equals("") ||
            vo.getEmail() == null || vo.getEmail().equals("") ||
            
            vo.getGoalMoney() == 0 ||
            vo.getProjectMainImage() == null || vo.getProjectMainImage().equals("") ||
            vo.getProjectTitle() == null || vo.getProjectTitle().equals("") ||
            vo.getProjectSubTitle() == null || vo.getProjectSubTitle().equals("") ||
            vo.getCategory() == null || vo.getCategory().equals("") ||
//            vo.getStartDate() == null ||
            vo.getEndDate() == null ||

            vo.getProjectSummary() == null || vo.getProjectSummary().equals("") ||
//            vo.getProjectCaution() == null || vo.getProjectCaution().equals("") ||
            vo.getProjectIntroduceVideo() == null || vo.getProjectIntroduceVideo().equals("") || 
            vo.getProjectStory() == null || vo.getProjectStory().equals("")
//            vo.getInformationAgree() == 'n'
            //����� üũ �߰� �ؾ��Ѵ�.
            
      ){
         
         return 'n';

      }
      
      
      return 'y';
   }
   
   
   
   public void getProjectDetails(ProjectVO pvo,MemberActivityVO mavo, Model model) {
      
      pvo = getProjectService.getProject(pvo);
      int projectNo = pvo.getProjectNo();
      
      mavo.setProjectNo(pvo.getProjectNo());
	   int likeCount = getProjectLikeCountService.getProjectLikeCount(mavo);
      
      
      projectBoardVO.setProjectNo(projectNo);
      List<ProjectBoardVO> getProjectBoardList = getEntireProjectBoardListService.getEntireProjectBoardList(projectBoardVO);

      projectKeywordVO.setProjectNo(projectNo);
      List<ProjectKeywordVO> projectKeywordList = getProjectKeywordListService.getProjectKeywordList(projectKeywordVO);
      
      projectIntroduceImageVO.setProjectNo(projectNo);
      List<ProjectIntroduceImageVO>projectIntroduceImageList = getProjectIntroduceImageListService.getProjectIntroduceImageList(projectIntroduceImageVO);
      
      rewardVO.setProjectNo(projectNo);
      List<RewardVO> rewardList = getRewardListService.getRewardList(rewardVO);
      
      
      model.addAttribute("rewardList", rewardList);
      model.addAttribute("getProjectBoardList", getProjectBoardList); //��ü��ϸ���Ʈ �̸��̶� ���� ����ؼ� ������
      model.addAttribute("projectIntroduceImageList", projectIntroduceImageList);
      model.addAttribute("projectKeywordList", projectKeywordList);
      model.addAttribute("project", pvo);
      model.addAttribute("likeCount", likeCount);
      
   }
   
}












