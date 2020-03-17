
package com.team5.funthing.user.service.impl.schedulingServiceImpl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.PaymentReserveDAO;
import com.team5.funthing.user.model.dao.ProjectDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.schedulingService.UpdateProjectDeadlineService;


@Service
public class UpdateProjectDeadlineServiceImpl implements UpdateProjectDeadlineService {

	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private PaymentReserveDAO paymentReserveDAO;
	
	@Override
	@Scheduled(cron= "1 0 0 * * ?")
	public void updateProjectDeadline() {
		
		projectDAO.updateProjectDeadline();
		
		List<ProjectVO> todayClosedProjectList = projectDAO.getTodayClosedProjectList();
		
		
		List<ProjectVO> successProjectList = new ArrayList<ProjectVO>();
		List<ProjectVO> failedProjectList = new ArrayList<ProjectVO>();
		for(ProjectVO todayClosedProject : todayClosedProjectList) {
			
			int goalMoney = todayClosedProject.getGoalMoney();
			int fundingMoney = todayClosedProject.getFundingMoney();
			
			if(fundingMoney >= goalMoney) {
				successProjectList.add(todayClosedProject);
			}else {
				failedProjectList.add(todayClosedProject);
			}
		}
		
		
		
		for(ProjectVO successProject : successProjectList) {
			paymentReserveDAO.updatePaymentComplete(successProject.getProjectNo());
		}
		for(ProjectVO failedProject : failedProjectList) {
			paymentReserveDAO.updatePaymentCancel(failedProject.getProjectNo());
		}
	}

}
