package com.team5.funthing.user.model.dao;



import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.MemberActivityVO;

@Repository
public class MemberActivityDAO {
	@Autowired
	SqlSessionTemplate st;

	public MemberActivityVO getMemberActivityProjectList(MemberActivityVO vo) {
		vo.setProjectReportCount(st.selectOne("MeberActivityDAO.projectLikeCount").toString());
		vo.setProjectLikeCount(st.selectOne("MeberActivityDAO.projectReportCount").toString());
		vo.setProjectReservationCount(st.selectOne("MeberActivityDAO.projectReservationCount").toString());
		return vo;
	}

	public MemberActivityVO getMemberActivityMemberList(MemberActivityVO vo) {
		vo.setMemberLikeCount(st.selectOne("MeberActivityDAO.memberLikeCount").toString());
		vo.setMemberReportCount(st.selectOne("MeberActivityDAO.memberReportCount").toString());
		vo.setMemberReservationCount(st.selectOne("MeberActivityDAO.memberReservationCount").toString());

		return vo;
	}

	public List<MemberActivityVO> getLikeProjectnoList(MemberActivityVO vo){

		return st.selectList("MemberActivityDAO.getLikeProjectno", vo);
	}
	public List<MemberActivityVO> getReportProjectnoList(MemberActivityVO vo){

		return st.selectList("MemberActivityDAO.getReportProjectno", vo);
	}
	public List<MemberActivityVO> getReservationProjectnoList(MemberActivityVO vo){

		return st.selectList("MemberActivityDAO.getReservationProjectno", vo);
	}

	public void insertMemberActivity(MemberActivityVO vo) {
		st.insert("MemberActivityDAO.insertMemberActivity",vo);
	}

	public void updateMemberActivity(MemberActivityVO vo) {
		st.update("MemberActivityDAO.updateMemberActivity",vo);
	}

	public void deleteMemberActivity(MemberActivityVO vo){
		st.delete("MemberActivityDAO.deleteMemberActivity",vo);
	}


}
