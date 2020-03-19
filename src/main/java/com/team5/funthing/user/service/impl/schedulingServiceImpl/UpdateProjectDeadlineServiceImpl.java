
package com.team5.funthing.user.service.impl.schedulingServiceImpl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.PaymentReserveDAO;
import com.team5.funthing.user.model.dao.ProjectDAO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.schedulingService.UpdateProjectDeadlineService;


@Service
public class UpdateProjectDeadlineServiceImpl implements UpdateProjectDeadlineService {
 
	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private PaymentReserveDAO paymentReserveDAO;
	
	
	@Override
	public List<PaymentReserveVO> updateProjectDeadline() {
		
		System.out.println(" * UpdateProjectDeadlineService 실행");
		
		int closedProjectCnt = projectDAO.updateProjectDeadline(); 
		System.out.println("오늘 마감된 프로젝트 수 : " + closedProjectCnt + "개");
		
		List<ProjectVO> todayClosedProjectList = projectDAO.getTodayClosedProjectList();
		
		System.out.println("==============오늘 마감 리스트==============");
		for(ProjectVO todayClosedProject : todayClosedProjectList) {
			System.out.println(todayClosedProject.toString());
		}
		System.out.println("======================================");
		
		
		
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
		
		int cnt = 0;
		System.out.println("==============성공==============");
		for(ProjectVO successProject : successProjectList) {
		
			System.out.println(++cnt + ":" + successProject.getProjectNo());
			paymentReserveDAO.updatePaymentComplete(successProject.getProjectNo());
		}
		System.out.println("==============================");
		
		
		cnt = 0;
		List<PaymentReserveVO> toCancelOrders = new ArrayList<PaymentReserveVO>();
		System.out.println("==============실패==============");
		
		for(ProjectVO failedProject : failedProjectList) {
			
			System.out.println(++cnt + ":" + failedProject.getProjectNo());
			paymentReserveDAO.updatePaymentCancel(failedProject.getProjectNo());
			
			for(PaymentReserveVO order : paymentReserveDAO.getToCancelOrderList(failedProject)) {
				toCancelOrders.add(order);
			}
		}
		
		System.out.println("==============================");
		
		System.out.println(" * UpdateProjectDeadlineService 종료");
		
		return toCancelOrders;
		
	}

}
