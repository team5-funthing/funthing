package com.team5.funthing.admin.service.impl.adminReportServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminReportDAO;
import com.team5.funthing.admin.service.adminReportService.SelectEntireReportListService;
import com.team5.funthing.user.model.vo.ReportVO;

@Service
public class SelectEntireReportListServiceImpl implements SelectEntireReportListService{

	@Autowired
	private AdminReportDAO adminReportDAO;

	@Override
	public List<ReportVO> selectEntireReportList(ReportVO vo) {
		
		return adminReportDAO.selectEntireReportList(vo);
	}
	
	

	
	
}
