package com.team5.funthing.user.service.impl.memberServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberDAO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.memberService.InsertImageService;

@Service
public class InsertImageServiceImpl implements InsertImageService{
    
	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public void insertImage(MemberVO vo) {
		memberDAO.saveImage(vo);
	}

}
