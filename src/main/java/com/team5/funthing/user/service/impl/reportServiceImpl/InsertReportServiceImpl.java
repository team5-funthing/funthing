package com.team5.funthing.user.service.impl.reportServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ReportDAO;
import com.team5.funthing.user.model.vo.ReportVO;
import com.team5.funthing.user.service.reportService.InsertReportService;

@Service
public class InsertReportServiceImpl implements InsertReportService{
	@Autowired
	private ReportDAO ReportDAO;
	
	@Override
	public void insertReport(ReportVO vo) {
		
		ReportDAO.insertReport(vo);
		
	}

	
	
}
