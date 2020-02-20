package com.team5.funthing.admin.service.impl.adminReportServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminReportDAO;
import com.team5.funthing.admin.service.adminReportService.GetReportService;
import com.team5.funthing.user.model.vo.ReportVO;

@Service
public class GetReportServiceImpl implements GetReportService{

	@Autowired
	private AdminReportDAO adminReportDAO;

	@Override
	public ReportVO getReport(ReportVO vo) {
		
		return adminReportDAO.getReprot(vo);
		
	}

	
	

}
