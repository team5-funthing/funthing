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


// ===================== �꽌鍮꾩뒪 二쇱엯 ==============

   
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
   

// ===================== VO 二쇱엯 =====================

   
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
   
   

// ===================== �쑀�떥 二쇱엯 =====================


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


// ===================== 硫붿꽌�뱶 =======================   

   
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

         model.addAttribute("msg", "濡쒓렇�씤 �썑 �씠�슜 媛��뒫�빀�땲�떎.");
         return "p-index";
      }
      model.addAttribute("loginEmail", memberVO.getEmail()); 
      return "p-start-project"; // �떆�옉�븯湲� �럹�씠吏�濡� �씠�룞�븯�옄
   } // 濡쒓렇�씤 �떆�뿉留� �봽濡쒖젥�듃 留뚮뱾湲� �젒洹� 媛��뒫�븯�룄濡� �븯湲곗쐞�빐 �꽭�뀡�뿉 ���옣�맂 媛� �솗�씤 �썑 �럹�씠吏� �씠�룞.

   
   @RequestMapping(value="/getWritingProject.udo", method = RequestMethod.GET)
   public String getProject(   @RequestParam int currentProjectNo, 
                        @RequestParam(required = false)String msg, 
                        @RequestParam String creator,
                        AdminCategoryVO cvo, Model model) {
      
	   

	  System.out.println("�꽆�뼱�삩 媛� : " + creator); 

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
      

      return "f-create-project-basic"; // �봽濡쒖젥�듃 �옉�꽦 �뤌
   } // �봽濡쒖젥�듃 留뚮뱾湲� �떆�옉 �럹�씠吏��뿉�꽌 �닔�뻾
   
   //由ъ썙�뱶 �벑濡앹떆�뿉 紐⑸줉�쓣 異붽��븯�뒗 硫붿꽌�뱶 異붽��빐�빞�븳�떎()

  
   @RequestMapping(value = "/insertCreatorAndInsertProject.udo", method = RequestMethod.POST)
   public String insertProject(   
		   					@RequestParam(name = "creatorUploadImage", required = false)List<MultipartFile> creatorUploadImage,
                           @RequestParam(name = "businessUploadFile", required = false)List<MultipartFile> businessUploadFile,
                           HttpSession session, 
                           ProjectVO pvo, 
                           CreatorVO cvo,
                           AdminCategoryVO acvo,
                           Model model) throws Exception {


      // �봽濡쒖젥�듃 �젣�옉 泥� �떆�옉�떆�뿉留� �떆�옉
      ProjectVO checkVO = (ProjectVO)session.getAttribute("updatingProject");


      // �깉濡쒓퀬移⑥쓣 �븷 寃쎌슦�뿉 諛섎났�쟻�쑝濡� requestMapping �옉�뾽�씠 �닔�뻾�릺�뒗 遺�遺꾩쓣 諛⑹��븯湲� �쐞�븳 肄붾뱶

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

   } // �봽濡쒖젥�듃 �옉�꽦 �떆�옉�븷�븣 硫붿꽌�뱶 

   
   @RequestMapping(value = "/updateCreatorAndInsertProject.udo", method = RequestMethod.POST)
   public String updateCreatorAndInsertProject(   @RequestParam(name = "creatorUploadImage", required = false)List<MultipartFile> creatorUploadImage,
                                       @RequestParam(name = "businessUploadFile", required = false)List<MultipartFile> businessUploadFile,
                                       HttpSession session, 
                                       ProjectVO pvo, 
                                       CreatorVO cvo, 
                                       AdminCategoryVO acvo,
                                       Model model) throws Exception {
      
      System.out.println("cvo : " + cvo == null);

      // �봽濡쒖젥�듃 �젣�옉 泥� �떆�옉�떆�뿉留� �떆�옉
      ProjectVO checkVO = (ProjectVO)session.getAttribute("updatingProject");


      // �깉濡쒓퀬移⑥쓣 �븷 寃쎌슦�뿉 諛섎났�쟻�쑝濡� requestMapping �옉�뾽�씠 �닔�뻾�릺�뒗 遺�遺꾩쓣 諛⑹��븯湲� �쐞�븳 肄붾뱶

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

   } // �봽濡쒖젥�듃 �옉�꽦 �떆�옉�븷�븣 硫붿꽌�뱶 

   
   
   
   
   
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

                           Model model) throws Exception { // �봽濡쒖젥�듃 �엫�떆���옣 �떆 �떎�뻾�릺�뒗 硫붿꽌�뱶


   
	   System.out.println(cvo.toString());
      
      int ProjectNo = pvo.getProjectNo();
      
      projectIntroduceImageUploader(projectIntroduceImageUploadList, projectIntroduceImageVO, ProjectNo, projectIntroduceImageNoList);
      projectMainImageUploader(projectMainImageUpload, pvo);
//      creatorProfileImageUploader(creatorUploadImage, cvo);
//      creatorBusinessfileUploader(businessUploadFile, cvo);
      
      
      
      
      if(toAddKeywords != null) {

         insertKeyword(toAddKeywords, keywordVO); //DB�뿉 �깉濡쒖슫 �궎�썙�뱶 異붽� 硫붿꽌�뱶
         deleteProjectKeyword(pvo); // 湲곗〈 �봽濡쒖젥�듃�뿉 �엳�뜕 �궎�썙�뱶�뱾 �궘�젣
         insertProjectKeyword(toAddKeywords, pvo.getProjectNo());//DB�뿉 �봽濡쒖젥�듃�� �뿰寃곕릺�뒗 �궎�썙�뱶瑜� 異붽� �븯�뒗 硫붿꽌�뱶
      }
      
      char checkResult = inputCompleteCheck(pvo);
      pvo.setWriteStatus(checkResult); // �엯�젰�빐�빞�븯�뒗 �옉�꽦遺�遺� 泥댄겕
      updateProjectService.updateProject(pvo);
      
      if(checkResult == 'y') {
         redirectAttributes.addAttribute("msg", "�옉�꽦�씠 �셿猷� �릺�뿀�뒿�땲�떎.");
      }else {
         redirectAttributes.addAttribute("msg", "���옣 �릺�뿀�뒿�땲�떎");

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

      System.out.println("�닔�젙�쟾�쓽 �봽濡쒖젥�듃 �긽�깭 : " + pvo.toString());
      updateProjectService.updateProject(pvo);
      System.out.println("�닔�젙�썑�쓽 �봽濡쒖젥�듃 �긽�깭 : " + pvo.toString());
      
      //////////////////////////////////////////////////////////////

      avo.setAlarmType(pvo.getProjectTitle() + " �떖�궗�슂泥�");
      avo.setReceiveId("admin@funthing.com");
      avo.setReadConfirm('n');
      avo.setProjectNo(pvo.getProjectNo());
      avo.setDetailAlarmType("�슂泥�");

      System.out.println(avo.toString());
      insertProjectJudgeRequestAlarmService.insertProjectJudgeRequestAlarm(avo);
      
      redirectAttributes.addAttribute("creator", creator);

      redirectAttributes.addAttribute("msg", "�떖�궗�슂泥��쓣 �셿猷뚰븯���뒿�땲�떎.");

      redirectAttributes.addAttribute("currentProjectNo", pvo.getProjectNo());
      return "redirect:getWritingProject.udo";
   }
   
   @RequestMapping(value="projectDetailsFromProjectBoard.udo", method = RequestMethod.GET)
   public String showProjectDetails(   @RequestParam int currentProjectNo,


                              ProjectVO pvo, MemberActivityVO mavo, Model model) { // 占싱뱄옙占쏙옙클占쏙옙占쏙옙 占쏙옙占쏙옙트 占쏙옙 占쏙옙占쏙옙占쏙옙占� 占싱듸옙

      System.out.println("currentProjectNo : " + currentProjectNo);
      pvo.setProjectNo(currentProjectNo);
      getProjectDetails(pvo, mavo, model);
      

      return "p-project-details"; //�봽濡쒖젥�듃 �긽�꽭�럹�씠吏�

   }
   
   @RequestMapping(value="projectDetails.udo", method = RequestMethod.GET)
   public String showProjectDetails(ProjectVO pvo, 
		   							MemberActivityVO mavo, 
		   							Model model,
		   							@RequestParam(value="projectNo") String projectNo
		   							) { // 占싱뱄옙占쏙옙클占쏙옙占쏙옙 占쏙옙占쏙옙트 占쏙옙 占쏙옙占쏙옙占쏙옙占� 占싱듸옙
	   mavo.setProjectNo(Integer.parseInt(projectNo));
	   System.out.println(projectNo);
	   
	   if(pvo == null) {
		   ProjectVO provo = new ProjectVO();
		   
		   provo.setProjectNo(Integer.parseInt(projectNo));
		   pvo = getProjectService.getProject(provo);
	   }
	   getProjectDetails(pvo,mavo, model);
	   
	   return "p-project-details"; //占쏙옙占쏙옙트 占쏙옙占쏙옙占쏙옙占쏙옙
   }
   
   
   
   @RequestMapping(value = "/showPreviewProject.udo", method = RequestMethod.POST)

   public String showPreviewProject(ProjectVO pvo, Model model) throws Exception { // �봽濡쒖젥�듃 �엫�떆���옣 �떆 �떎�뻾�릺�뒗 硫붿꽌�뱶

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
   

         //�엯�젰�븳 �궎�썙�뱶 以묒뿉 DB�뿉 議댁옱�븯�뒗 �궎�썙�뱶媛� �븘�땲�씪硫� �궎�썙�뱶 異붽�

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
   

   //=================== �뾽濡쒕뱶 硫붿꽌�뱶 =================================


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
      

      if(!toDoUploadList.isEmpty()){ //�봽濡쒖젥�듃 �냼媛� �씠誘몄� 湲곗〈�뾽濡쒕뱶 �젣嫄� 諛� �깉 �뾽濡쒕뱶, DB 異붽� �옉�뾽 硫붿꽌�뱶

         
         List<String> tmpUploadList = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
         insertProjectIntroduceImageService.insertProjectIntroduceImage(projectIntroduceImageVO, tmpUploadList);
         

      }else {
         uploadUtil.removeUtil(voName, toRemoveFilePath);
      
      }
      
      
      
   }   
   
   public void projectMainImageUploader(List<MultipartFile> toDoUploadList, ProjectVO vo) throws Exception {
      
      List<String> toRemoveFilePath = new ArrayList<String>();
            

      if(!toDoUploadList.get(0).isEmpty()) { // �뾽濡쒕뱶 �떆�궓 �뙆�씪�씠 �씠誘� 議댁옱�븯�뒗 寃쎌슦 �뙆�씪 �꽑�깮�쓣 �떎�떆 �븞�븳 寃쎌슦�뿉 �굹�삱 �닔 �엳�뒗 �긽�솴 泥섎━  
         toRemoveFilePath.add(vo.getProjectMainImage()); //�젣嫄곕맆 �뙆�씪寃쎈줈瑜� vo媛앹껜�뿉�꽌 媛��졇�삤湲�

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

      

      if(!toDoUploadList.get(0).isEmpty()) { // �뾽濡쒕뱶 �떆�궓 �뙆�씪�씠 �씠誘� 議댁옱�븯�뒗 寃쎌슦 �뙆�씪 �꽑�깮�쓣 �떎�떆 �븞�븳 寃쎌슦�뿉 �굹�삱 �닔 �엳�뒗 �긽�솴 泥섎━  
         toRemoveFilePath.add(cvo.getCreatorProfileImage()); //�젣嫄곕맆 �뙆�씪寃쎈줈瑜� vo媛앹껜�뿉�꽌 媛��졇�삤湲�

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


      if(!toDoUploadList.get(0).isEmpty()) { // �뾽濡쒕뱶 �떆�궓 �뙆�씪�씠 �씠誘� 議댁옱�븯�뒗 寃쎌슦 �뙆�씪 �꽑�깮�쓣 �떎�떆 �븞�븳 寃쎌슦�뿉 �굹�삱 �닔 �엳�뒗 �긽�솴 泥섎━  
         toRemoveFilePath.add(cvo.getBusinessFileLink()); //�젣嫄곕맆 �뙆�씪寃쎈줈瑜� vo媛앹껜�뿉�꽌 媛��졇�삤湲�

         String voName = "creatorBusinessFiles";
         List<String> toSettingPath = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
         if(toSettingPath == null) return;

         for(String toInsertImage : toSettingPath) {
            cvo.setBusinessFileLink(toInsertImage);
         }
      }
   }
   

   // 援ы쁽 OK - �닔�젙 �슂援щ맖
   public char inputCompleteCheck(ProjectVO vo) { //�엫�떆 ���옣�맂 �봽濡쒖젥�듃 鍮덉뭏 泥댄겕

      
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

            //由ъ썙�뱶 泥댄겕 異붽� �빐�빞�븳�떎.

            
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

      model.addAttribute("getProjectBoardList", getProjectBoardList); //�쟾泥대ぉ濡앸━�뒪�듃 �씠由꾩씠�옉 媛숈씠 議곗씤�빐�꽌 媛��졇�삤湲�

      model.addAttribute("projectIntroduceImageList", projectIntroduceImageList);
      model.addAttribute("projectKeywordList", projectKeywordList);
      model.addAttribute("project", pvo);
      model.addAttribute("likeCount", likeCount);
      
   }
   
}












