package com.team5.funthing.admin.service.impl.userMainImageChangeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminUserMainImageChangeDAO;
import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.service.userMainImageChangeService.UpdateUserMainImageContentService;

@Service
public class UpdateUserMainImageContentServiceImpl implements UpdateUserMainImageContentService {

	@Autowired
	AdminUserMainImageChangeDAO adminUserMainImageChangeDAO;

	@Override
	public void updateUserMainImageContent(AdminUserMainImageChangeVO vo, List<String> toUpdateImageContentList,
			List<Integer> userMainImageNoContentList) {

		if (userMainImageNoContentList != null) {

			for (int i = 0; i < userMainImageNoContentList.size(); i++) {

				vo.setImageNo(userMainImageNoContentList.get(i));

				if (toUpdateImageContentList != null) {

					if (toUpdateImageContentList.isEmpty()) {
						adminUserMainImageChangeDAO.updateUserMainImageContentNull(vo);
					} else {
						vo.setImageContent(toUpdateImageContentList.get(i));
						adminUserMainImageChangeDAO.updateUserMainImageContent(vo);
					}
				}

			}

		}

	}

}
