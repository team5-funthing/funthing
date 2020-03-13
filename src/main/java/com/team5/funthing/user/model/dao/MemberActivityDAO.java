package com.team5.funthing.user.model.dao;



import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.MemberActivityVO;

@Repository
public class MemberActivityDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public MemberActivityVO getMemberActivityProjectList(MemberActivityVO vo) {
		//vo.setProjectReportCount(sqlSessionTemplate.selectOne("MeberActivityDAO.projectLikeCount").toString());
		//vo.setProjectLikeCount(sqlSessionTemplate.selectOne("MeberActivityDAO.projectReportCount").toString());
		//vo.setProjectReservationCount(sqlSessionTemplate.selectOne("MeberActivityDAO.projectReservationCount").toString());
		return vo;
	}

	public MemberActivityVO getMemberActivityMemberList(MemberActivityVO vo) {
		//vo.setMemberLikeCount(sqlSessionTemplate.selectOne("MeberActivityDAO.memberLikeCount").toString());
		//vo.setMemberReportCount(sqlSessionTemplate.selectOne("MeberActivityDAO.memberReportCount").toString());
		//vo.setMemberReservationCount(sqlSessionTemplate.selectOne("MeberActivityDAO.memberReservationCount").toString());

		return vo;
	}

	public List<MemberActivityVO> getLikeProjectNoList(MemberActivityVO vo){
		return sqlSessionTemplate.selectList("MemberActivityDAO.getLikeProjectNoList", vo);
	}
	
	public List<MemberActivityVO> getReportProjectNoList(MemberActivityVO vo){
		return sqlSessionTemplate.selectList("MemberActivityDAO.getReportProjectNoList", vo);
	}
	
	public List<MemberActivityVO> getReservationProjectNoList(MemberActivityVO vo){
		return sqlSessionTemplate.selectList("MemberActivityDAO.getReservationProjectNoList", vo);
	}

	public void insertMemberActivity(MemberActivityVO vo) {
		sqlSessionTemplate.insert("MemberActivityDAO.insertMemberActivity",vo);
	}

	public void updateMemberActivity(MemberActivityVO vo) {
		sqlSessionTemplate.update("MemberActivityDAO.updateMemberActivity",vo);
	}

	public void deleteMemberActivity(MemberActivityVO vo){
		sqlSessionTemplate.delete("MemberActivityDAO.deleteMemberActivity",vo);
	}

	public int getProjectLikeCount(MemberActivityVO vo) {
		return sqlSessionTemplate.selectOne("MemberActivityDAO.projectLikeCount",vo);
	}

}
