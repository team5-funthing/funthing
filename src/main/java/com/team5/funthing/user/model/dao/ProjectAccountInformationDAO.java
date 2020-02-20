package com.team5.funthing.user.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ProjectAccountInformationVO;

@Repository
public class ProjectAccountInformationDAO {

	@Autowired
	private SqlSessionTemplate projectAccountSqlSessionTemplate;
	
	public void InsertProjectAccountInformation(ProjectAccountInformationVO vo) {
		projectAccountSqlSessionTemplate.insert("ProjectAccountInformationDAO.insertProjectAccountInformation",vo);
	}
	
	public void updateProjectAccountInformation(ProjectAccountInformationVO vo) {
		projectAccountSqlSessionTemplate.update("ProjectAccountInformationDAO.updateProjectAccountInformation",vo);
	}
	
	public ProjectAccountInformationVO getProjectAccountInformation(ProjectAccountInformationVO vo) {
		return projectAccountSqlSessionTemplate.selectOne("ProjectAccountInformationDAO.getProjectAccountInformation",vo);
	}
	
	public void deleteProjectAccountInformation(ProjectAccountInformationVO vo) {
		projectAccountSqlSessionTemplate.delete("ProjectAccountInformationDAO.deleteProjectAccountInformation",vo);
	}
	
	public boolean accountcheck(ProjectAccountInformationVO vo) {
		boolean result;
		if(projectAccountSqlSessionTemplate.selectOne("ProjectAccountInformationDAO.getProjectAccountInformation",vo)==null) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}
}



