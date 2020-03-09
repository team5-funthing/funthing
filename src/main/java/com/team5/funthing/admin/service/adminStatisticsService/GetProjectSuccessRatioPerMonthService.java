package com.team5.funthing.admin.service.adminStatisticsService;

import com.team5.funthing.admin.model.vo.AdminStatisticsVO;
import com.team5.funthing.user.model.vo.ProjectVO;

public interface GetProjectSuccessRatioPerMonthService {

	public AdminStatisticsVO getProjectSuccessRatioPerMonth(ProjectVO vo);
}
