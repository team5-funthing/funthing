package com.team5.funthing.admin.service.adminReportService;

import java.util.List;

import com.team5.funthing.user.model.vo.ReportVO;

public interface GetReportListService {

	List<ReportVO> getReportList(ReportVO vo);
	
}
