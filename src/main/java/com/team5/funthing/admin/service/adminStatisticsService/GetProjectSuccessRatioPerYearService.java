package com.team5.funthing.admin.service.adminStatisticsService;

import com.team5.funthing.admin.model.vo.AdminStatisticsVO;
import com.team5.funthing.user.model.vo.ProjectVO;

public interface GetProjectSuccessRatioPerYearService {

	public AdminStatisticsVO getProjectSuccessRatioPerYear(ProjectVO vo);
}
