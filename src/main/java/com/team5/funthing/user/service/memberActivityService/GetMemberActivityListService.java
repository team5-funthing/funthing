package com.team5.funthing.user.service.memberActivityService;

import java.util.List;

import com.team5.funthing.user.model.vo.MemberActivityVO;

public interface GetMemberActivityListService {

	public MemberActivityVO getMemberActivityProjectList(MemberActivityVO vo);

	public MemberActivityVO getMemberActivityMemberList(MemberActivityVO vo);
	
	public List<MemberActivityVO> getLikeProjectnoList(MemberActivityVO vo);
	
	public List<MemberActivityVO> getReportProjectnoList(MemberActivityVO vo);
	
	public List<MemberActivityVO> getReservationProjectnoList(MemberActivityVO vo);
}
