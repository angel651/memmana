package com.example.memmana6.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.memmana6.dao.entity.Admin;
import com.example.memmana6.dao.mapper.IAdminMapper;
import com.example.memmana6.service.AdminService;

@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	private IAdminMapper adminDao;

	//@Override
	public Admin queryAdminByUsername(String username) {

		return adminDao.queryAdminByUsername(username);
	}
}
