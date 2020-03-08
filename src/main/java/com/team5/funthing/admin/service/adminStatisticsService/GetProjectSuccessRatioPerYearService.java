package com.team5.funthing.admin.service.adminStatisticsService;

import java.util.List;

import com.team5.funthing.admin.model.vo.AdminStatisticsVO;

public interface GetProjectSuccessRatioPerYearService {

	public List<AdminStatisticsVO> getProjectSuccessRatioPerYear(AdminStatisticsVO vo);
}
