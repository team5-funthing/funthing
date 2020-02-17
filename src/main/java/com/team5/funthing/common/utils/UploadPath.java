package com.team5.funthing.common.utils;

import org.springframework.stereotype.Component;

@Component
public class UploadPath {
	
	private String uploadPath = "C:/funthing/project/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/funthing/resources/user/";

	public String getUploadPath() {
		return uploadPath;
	}

	
	
}
