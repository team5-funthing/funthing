package com.team5.funthing.admin.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.service.userMainImageChangeService.UpdateUserMainImageNullService;
import com.team5.funthing.admin.service.userMainImageChangeService.UpdateUserMainImageService;

@Controller
public class AdminUserMainImageChangeController {
	
	private String SAVE_PATH = "C:\\funthing\\project\\funthing\\src\\main\\webapp\\resources\\user\\img\\main\\";
	
	@Autowired
	UpdateUserMainImageService updateUserMainImageService;
	@Autowired
	UpdateUserMainImageNullService updateUserMainImageNullService;

	@RequestMapping("userMainImageChange.ado")
    public String upload(
            @RequestParam(value="file1", required = false) MultipartFile mf,AdminUserMainImageChangeVO vo) {
 
            String originalFileName = mf.getOriginalFilename();
            long fileSize = mf.getSize();
            String safeFile = SAVE_PATH + System.currentTimeMillis() + originalFileName;
            System.out.println("originalFileName:"+originalFileName);
            System.out.println("fileSize:"+fileSize);
            System.out.println("safeFile:"+safeFile);
            
            String imageName = System.currentTimeMillis() + originalFileName;
            String imagePath = SAVE_PATH;

            vo.setImageName(imageName);
            vo.setImagePath(imagePath);
       
            if(fileSize!=0) {
       
            updateUserMainImageService.updateUserMainImage(vo);
            try {
                mf.transferTo(new File(safeFile));
               } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
            if(fileSize == 0) {
            	
            	updateUserMainImageNullService.updateUserMainImageNull(vo);
            	
            }
  

			return "redirect: userMainImageChangeForm.ado";
        }
      


}
