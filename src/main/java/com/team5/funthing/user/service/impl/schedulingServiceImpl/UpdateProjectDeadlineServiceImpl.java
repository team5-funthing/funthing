/**
 * 
 */
package com.team5.funthing.user.service.impl.schedulingServiceImpl;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.PaymentReserveDAO;
import com.team5.funthing.user.model.dao.ProjectDAO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.service.schedulingService.UpdateProjectDeadlineService;

@Service
public class UpdateProjectDeadlineServiceImpl implements UpdateProjectDeadlineService {

	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private PaymentReserveDAO paymentReserveDAO;
	
	@Override
	@Scheduled(cron= "0/1 0 0 * * ?")
	public void updateProjectDeadline() {
		
		// 1.진행중인 프로젝트 중에서 자정이 된 날짜와 endDate 가 일치하는 프로젝트의 funding = 'n' 으로 변경
		projectDAO.updateProjectDeadline();
		List<Integer> closedProjectNoList = projectDAO.getClosedProjectNoList();
//		
//		for(int closedProjectNo : closedProjectNoList) {
//			
//			
//		}
		
		
		
		// 2. 마감이 된 프로젝트 들 중에서 성공과 실패 구분
		
		// 3. 마감이 된 성공한 프로젝트의 결제예약 처리 ==> 1.결제 예약을 결제 완료로 변경 처리(송금처리), 그에 따른 수수료 처리(10%),
		
		
	}

}
