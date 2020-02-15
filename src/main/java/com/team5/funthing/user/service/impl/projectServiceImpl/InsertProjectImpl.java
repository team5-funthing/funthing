package com.team5.funthing.user.service.impl.projectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.projectService.InsertProject;

@Service
public class InsertProjectImpl implements InsertProject {

	@Autowired
	MemberDAO memberDAO;

	@Override
	public void insertSocialMember(MemberVO vo) {
		memberDAO.insertSocialMember(vo);
	}
	
	@Override
	   public void insertMember(MemberVO vo) {
	      memberDAO.insertMember(vo);
	   }

	@Override
	public void saveImage(MemberVO vo) {
		memberDAO.saveImage(vo);
		
	}
}
