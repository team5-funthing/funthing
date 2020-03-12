package com.team5.funthing.user.service.impl.reportServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ReportDAO;
import com.team5.funthing.user.model.vo.ReportVO;
import com.team5.funthing.user.service.reportService.GetReportService;

@Service
public class GetReportServiceImpl implements GetReportService {

	@Autowired
	private ReportDAO reportDAO;
	
	@Override
	public ReportVO getReport(ReportVO vo) {
		return reportDAO.getReport(vo);
	}

}
