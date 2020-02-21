package com.team5.funthing.admin.service.adminMemberManagementService;

import java.util.List;

import com.team5.funthing.user.model.vo.MemberVO;

public interface GetMemberListService {
		List<MemberVO> getMemberList(MemberVO vo);
}
