package com.team5.funthing.user.service.impl.reportServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ReportDAO;
import com.team5.funthing.user.model.vo.ReportVO;
import com.team5.funthing.user.service.reportService.GetReportListService;

@Service
public class GetReportListServiceImpl implements GetReportListService{

	@Autowired
	private ReportDAO reportDAO;

	@Override
	public List<ReportVO> getReportList(ReportVO vo) {
		
		return reportDAO.getReportList(vo);
		
	}
	
}
