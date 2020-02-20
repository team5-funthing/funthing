package com.team5.funthing.common.utils.uploadUtils;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
//@RequestMapping("/*")
public class InitRealPathController {
	
	@Autowired
	ServletContext context;
	
	private String realPath;
	
	@PostConstruct
	public void initController() {
		this.realPath = context.getRealPath("/resources/upload");
		System.out.println( "InitRealPath : " + realPath );
	}

	public String getRealPath() {
		return realPath;
	}
	
	
	

}
