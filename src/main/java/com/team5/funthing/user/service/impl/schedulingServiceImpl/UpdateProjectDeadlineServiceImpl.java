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
		
		// 1.�������� ������Ʈ �߿��� ������ �� ��¥�� endDate �� ��ġ�ϴ� ������Ʈ�� funding = 'n' ���� ����
		projectDAO.updateProjectDeadline();
		List<Integer> closedProjectNoList = projectDAO.getClosedProjectNoList();
//		
//		for(int closedProjectNo : closedProjectNoList) {
//			
//			
//		}
		
		
		
		// 2. ������ �� ������Ʈ �� �߿��� ������ ���� ����
		
		// 3. ������ �� ������ ������Ʈ�� �������� ó�� ==> 1.���� ������ ���� �Ϸ�� ���� ó��(�۱�ó��), �׿� ���� ������ ó��(10%),
		
		
	}

}
