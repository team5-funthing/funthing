package com.team5.funthing.user.memberServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.memberService.InsertImageService;
import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.model.vo.MemberVO;

@Service
public class InsertImageServiceImpl implements InsertImageService{
    
	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public void insertImage(MemberVO vo) {
		memberDAO.saveImage(vo);
	}

}